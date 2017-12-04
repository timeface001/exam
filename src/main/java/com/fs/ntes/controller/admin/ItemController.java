package com.fs.ntes.controller.admin;

import com.fs.ntes.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("index")
public class ItemController extends BaseController {


    @RequestMapping("/")
    public String index(HttpServletRequest request) {

        //request.setAttribute("11");
        return "admin/itemList";

    }


}
