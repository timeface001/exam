package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.domain.ItemPoint;
import com.fs.ntes.dto.RespGenerator;
import com.fs.ntes.dto.RespResult;
import com.fs.ntes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/add")
    @ResponseBody
    public RespResult add(HttpServletRequest request, ItemPoint point) {

        point.setCreateUid(getMember().getUid());
        point = itemService.saveItemPoint(point);
        return RespGenerator.generateSuccess(point);
    }

    @RequestMapping("/del")
    @ResponseBody
    public RespResult del(HttpServletRequest request, Integer itemId, Integer pointId) {

        int i = itemService.delItemPoint(pointId, itemId);
        return RespGenerator.generateSuccessDependBol(i == 1);
    }
}
