package com.fs.ntes.controller;

import com.fs.ntes.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexController extends BaseController {

    @RequestMapping("/index")
    public String index(){
        //分流
        int type = getMember().getType();
        if (type == Constant.MEMBER_TYPE_ADMIN) {
            return "/admin/itemList";
        }

        if (type == Constant.MEMBER_TYPE_STUDENT) {
            return "student/itemList";
        }

        return "login";
    }
}
