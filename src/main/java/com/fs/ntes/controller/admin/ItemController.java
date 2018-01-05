package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.domain.Item;
import com.fs.ntes.dto.RespGenerator;
import com.fs.ntes.dto.RespResult;
import com.fs.ntes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("item")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/list")
    public String index(HttpServletRequest request) {

        setAttribute("list", itemService.selectList(getMember()));
        return RespGenerator.generateSuccessView("admin/itemList");

    }

    @RequestMapping("/toAdd")
    public String add(HttpServletRequest request, Integer itemId) {

        setAttribute("item", itemService.findById(itemId));
        return "admin/itemAdd";

    }

    @PostMapping("/save")
    @ResponseBody
    public RespResult save(Item item) {
        item.setUid(getMember().getUid());
        itemService.save(item);
        return RespGenerator.generateSuccess();

    }


}
