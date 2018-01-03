package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.domain.Point;
import com.fs.ntes.domain.Question;
import com.fs.ntes.domain.em.QuestionType;
import com.fs.ntes.dto.RespGenerator;
import com.fs.ntes.dto.RespResult;
import com.fs.ntes.dto.ResultCode;
import com.fs.ntes.service.PointService;
import com.fs.ntes.service.QuestionService;
import com.fs.ntes.utils.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("question")
public class QuestionController extends BaseController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private PointService pointService;

    @Autowired
    private ResultCode resultCode;

    @RequestMapping("/toAdd")
    public String toAdd(Integer pointId, Integer questionId, HttpServletRequest request) {
        request.setAttribute("point", pointService.selectOneById(pointId));

        setAttribute("question", new Question());
        Optional.of(questionId).ifPresent(v -> {
            request.setAttribute("question", questionService.selectOneById(questionId));
        });
        return "admin/questionAdd";
    }

    @RequestMapping("/type")
    public String type(Integer pointId, HttpServletRequest request) {
        request.setAttribute("point", pointService.selectOneById(pointId));
        return "admin/questionType";
    }

    @RequestMapping("/add")
    @ResponseBody
    public RespResult add(Question question, HttpServletRequest request) {
        question.setUid(getMember().getUid());
        int i = questionService.save(question);
        return RespGenerator.generateDependBol(i == 1, resultCode.getCommon().getAddSuccess(), resultCode.getCommon().getAddFailed());
    }

    @RequestMapping("/del")
    @ResponseBody
    public RespResult del(Integer pointId, Integer questionId, Integer type) {

        int i = questionService.del(pointId, questionId, type);
        return RespGenerator.generateDependBol(i == 1);
    }

    @RequestMapping("/view")
    public String view(String pointName, Question question, String typeName) {
        getRequest().setAttribute("pointName", pointName);
        getRequest().setAttribute("question", question);
        getRequest().setAttribute("typeName", typeName);
        return "admin/questionView";
    }

    @RequestMapping("/view/list")
    public String viewList(Integer pointId, Integer type) {
        Point point = pointService.selectOneById(pointId);
        setAttribute("list", questionService.selectListByPointId(pointId, type));
        setAttribute("point", point);
        setAttribute("typeName", QuestionType.getTypeDesc(type));
        setAttribute("type", type);
        setAttribute("typeCount", GeneralUtils.questionTypeCount(point, type));
        return "admin/questionViewList";
    }

}
