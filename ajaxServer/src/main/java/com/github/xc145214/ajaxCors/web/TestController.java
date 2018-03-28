/*************************************************************************
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *
 *                COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 *    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *************************************************************************/
package com.github.xc145214.ajaxCors.web;

import com.github.xc145214.ajaxCors.support.ResultBean;
import com.github.xc145214.ajaxCors.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author xiachuan at 2018/3/27 17:15。
 */
@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {

    @GetMapping("/get1")
    public ResultBean get1() {
        System.out.println("TestController.get1()");
        return new ResultBean("get1 ok");
    }

    @PostMapping("/postJson")
    public ResultBean postJson(@RequestBody User user){
        System.out.println("TestController.postJson()");
        return new ResultBean("postJson " + user.getName());
    }

    @GetMapping("/getCookie")
    public ResultBean getCookie(@CookieValue(value = "cookie1") String cookie1) {
        System.out.println("TestController.getCookie()");
        return new ResultBean("getCookie " + cookie1);
    }

    @GetMapping("/getHeader")
    public ResultBean getHeader(@RequestHeader("x-header1") String header1,
                                @RequestHeader("x-header2") String header2) {
        System.out.println("TestController.getHeader()");

        return new ResultBean("getHeader " + header1 + " " + header2);
    }
}

