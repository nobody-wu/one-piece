package com.cornelius.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 17:09 2018/3/27
 */
@RestController
public class Controller {

    @RequestMapping("/hello")
    public String ok(ModelMap map, HttpServletRequest request, HttpServletResponse response){
//        try {
////            response.sendRedirect("index");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "ok";
    }

}
