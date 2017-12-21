package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import com.fs.ntes.domain.ext.PointExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("question")
public class QuestionController extends BaseController {


    @Autowired
    private PointExtMapper pointExtMapper;


    @RequestMapping("/toAdd")
    public String toAdd(Integer pointId, HttpServletRequest request) {
        request.setAttribute("point", pointExtMapper.selectByPrimaryKey(pointId));
        return "admin/questionAdd";
    }

    @RequestMapping("/type")
    public String type(Integer pointId, HttpServletRequest request) {
        request.setAttribute("point", pointExtMapper.selectByPrimaryKey(pointId));
        return "admin/questionType";
    }
}
