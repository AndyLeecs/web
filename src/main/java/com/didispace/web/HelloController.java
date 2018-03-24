package com.didispace.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//注意 @RestController 和 @Controller 的区别
//已知：页面渲染时，使用 @Controller
//Json数据交互时，使用 @RestController
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map)
    {
        map.addAttribute("host","姥姥已经好起来了");

        //注意返回值的写法
        return "/Index";
    }

}