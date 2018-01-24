package spring_boot_starter_hello.aa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by qxz on 2017/12/12
 * Description:
 */
@Controller
public class A {

    @RequestMapping(value="/")
    @ResponseBody
    public String index(){
        return "hello index";
    }

    @GetMapping(value="/index")
    @ResponseBody
    public String get(){
        return "hello get";
    }

    @PostMapping(value="/index")
    @ResponseBody
    public String post(){
        return "hello post";
    }
}
