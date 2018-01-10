package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.Paper;
import com.fs.ntes.dto.PageList;
import com.fs.ntes.dto.PageRequest;
import com.fs.ntes.service.ItemService;
import com.fs.ntes.service.PaperService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("paper")
public class PaperController extends BaseController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private PaperService paperService;

    @RequestMapping("/list")
    public String list(PageRequest page) {
        Page<Paper> list = paperService.selectList(getMember().getUid(), page);
        System.out.println(list.getPages());
        setAttribute("list", new PageList<>(list));
        return "admin/paperList";
    }


    @RequestMapping("/toAdd")
    public String toAdd() {
        List<Item> list = itemService.selectList(getMember());
        setAttribute("list", list);
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
}
