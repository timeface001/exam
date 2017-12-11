package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("item")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/list")
    public String index(HttpServletRequest request) {

        request.setAttribute("list", itemService.selectList(getMember()));
        return "admin/itemList";

    }

    @RequestMapping("/toAdd")
    public String add(HttpServletRequest request) {

        return "admin/itemAdd";

    }

    @PostMapping("/save")
    public String save(HttpServletRequest request) {

        return "redirect:/item/list";

    }


}
