package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.domain.Point;
import com.fs.ntes.dto.RespGenerator;
import com.fs.ntes.dto.RespResult;
import com.fs.ntes.dto.ResultCode;
import com.fs.ntes.service.ItemService;
import com.fs.ntes.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("item/point/")
public class PointController extends BaseController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private PointService pointService;

    @Autowired
    private ResultCode resultCode;

    @RequestMapping("/list")
    public String index(HttpServletRequest request, Integer itemId) {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        request.setAttribute("list", pointService.selectPointList(map));
        request.setAttribute("item", itemService.findById(itemId));
        return "admin/point";
    }

    @RequestMapping("/add")
    @ResponseBody
    public RespResult add(HttpServletRequest request, Point point) {

        point.setCreateUid(getMember().getUid());
        point = pointService.save(point);
        return RespGenerator.generateSuccess(point);
    }

    @RequestMapping("/del")
    @ResponseBody
    public RespResult del(HttpServletRequest request, Integer itemId, Integer pointId) {

        int i = pointService.delPoint(pointId, itemId);
        return RespGenerator.generateDependBol(i == 1, i == 1 ? resultCode.getCommon().getDelSuccess() : resultCode.getCommon().getDelFailed());
    }
}
