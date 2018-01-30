package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.Paper;
import com.fs.ntes.domain.Point;
import com.fs.ntes.domain.em.QuestionType;
import com.fs.ntes.dto.PageList;
import com.fs.ntes.dto.PageRequest;
import com.fs.ntes.dto.RespGenerator;
import com.fs.ntes.dto.RespResult;
import com.fs.ntes.service.ItemService;
import com.fs.ntes.service.PaperService;
import com.fs.ntes.service.PointService;
import com.fs.ntes.service.QuestionService;
import com.fs.ntes.utils.GeneralUtils;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("paper")
public class PaperController extends BaseController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private PaperService paperService;
    @Autowired
    private PointService pointService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/list")
    public String list(PageRequest page) {
        Page<Paper> list = paperService.selectList(getMember().getUid(), page);
        setAttribute("list", new PageList<>(list));
        return "admin/paperList";
    }


    @RequestMapping("/toAdd")
    public String toAdd(Integer paperId) {
        List<Item> list = itemService.selectList(getMember());
        setAttribute("list", list);
        setAttribute("paper", Optional.ofNullable(paperId).map(v -> paperService.selectOneById(paperId)).orElse(new Paper()));
        return "admin/paperAddBase";
    }

    @RequestMapping("/addPaperQuestion")
    public String addPaperQuestion(Paper paper) {
        paper.setUid(getMember().getUid());
        paper.setUname(getMember().getName());
        paperService.save(paper);
        setAttribute("paper", paper);
        return "admin/paperAddQuestion";
    }

    @RequestMapping("/selectPaperQuestion")
    public String selectPaperQuestion(Integer pointId, Integer type) {
        Point point = pointService.selectOneById(pointId);
        setAttribute("list", questionService.selectListByPointId(pointId, type));
        setAttribute("point", point);
        setAttribute("typeName", QuestionType.getTypeDesc(type));
        setAttribute("type", type);
        setAttribute("typeCount", GeneralUtils.questionTypeCount(point, type));
        return "admin/paperAddQuestionSelect";
    }

    @RequestMapping("/selectPoint")
    @ResponseBody
    public RespResult selectPoints(String items) {
        return RespGenerator.generateSuccess(pointService.selectListByItemIds(Arrays.stream(items.split(",")).filter(StringUtils::isNoneBlank).map(Integer::valueOf).collect(Collectors.toList())));
    }
}
