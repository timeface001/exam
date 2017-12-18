package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("item/point/")
public class ItemPointController extends BaseController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/list")
    public String index(HttpServletRequest request, Integer itemId) {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        request.setAttribute("list", itemService.selectPointList(map));
        request.setAttribute("item", itemService.findById(itemId));
        return "admin/itemPoint";
    }
}
