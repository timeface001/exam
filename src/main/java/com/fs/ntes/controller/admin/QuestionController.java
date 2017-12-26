package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.domain.Question;
import com.fs.ntes.dto.RespGenerator;
import com.fs.ntes.dto.RespResult;
import com.fs.ntes.dto.ResultCode;
import com.fs.ntes.service.PointService;
import com.fs.ntes.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public String toAdd(Integer pointId, HttpServletRequest request) {
        request.setAttribute("point", pointService.selectOneById(pointId));
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
        return RespGenerator.generateSuccessDependBol(i == 1, resultCode.getCommon().getAddSuccess(),resultCode.getCommon().getAddFailed());
    }

    @RequestMapping("/view")
    public String view(String itemName, Question question) {
        getRequest().setAttribute("itemName", itemName);
        getRequest().setAttribute("question", question);
        return "questionView";
    }
}
