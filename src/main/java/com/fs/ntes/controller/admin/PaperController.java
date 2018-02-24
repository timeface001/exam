package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.Paper;
import com.fs.ntes.domain.Point;
import com.fs.ntes.domain.em.QuestionType;
import com.fs.ntes.dto.*;
import com.fs.ntes.dto.exchange.ExchangeUtils;
import com.fs.ntes.service.*;
import com.fs.ntes.utils.GeneralUtils;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private RelationsService relationsService;

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
    public String selectPaperQuestion(Integer pointId, Integer type, Integer paperId) {
        Point point = pointService.selectOneById(pointId);
        final List<Integer> questionIds = relationsService.selectQuestionIdsByPaperId(paperId, pointId);
        setAttribute("list", ExchangeUtils.getList(questionService.selectListByPointId(pointId, type), v -> new PaperQuestionSelectDto(GeneralUtils.isNotNullOrEmpty(questionIds) && questionIds.contains(v.getId()), v)));
        setAttribute("point", point);
        setAttribute("typeName", QuestionType.getTypeDesc(type));
        setAttribute("type", type);
        setAttribute("typeCount", GeneralUtils.questionTypeCount(point, type));
        return "admin/paperAddQuestionSelect";
    }

    @RequestMapping("/selectPoint")
    @ResponseBody
    public RespResult selectPoints(String items, Integer paperId) {
        return RespGenerator.generateSuccess(ExchangeUtils.getList(pointService.selectListByItemIds(Arrays.stream(items.split(",")).filter(StringUtils::isNoneBlank).map(Integer::valueOf).collect(Collectors.toList())), v -> new PaperPointSelectDto(v, relationsService.countPointSelect(paperId, v.getId()))
        ));
    }

    @RequestMapping("/updateQuestion")
    @ResponseBody
    public RespResult updateQuestion(String questionIds, Integer pointId, @RequestParam(value = "itemIds[]") Integer[] itemIds, Integer paperId) {
        relationsService.updatePaperQuestion(paperId, pointId, GeneralUtils.spilt(questionIds));
        return RespGenerator.generateSuccess();
    }
}
