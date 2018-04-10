package com.boot.study.validator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hujh on 2018/4/5.
 */
@Controller
@RequestMapping("/validat")
public class ValidatorController {

    @RequestMapping("/demo")
    public String demo(Model model){
        model.addAttribute("validatorDemo", new ValidatorDemo());
        return "/validatdemo";
    }


    // <p th:if="${#fields.hasErrors('name')}" th:errors="*{name}">Name Error</p>
    // <p th:if="${#fields.hasErrors('password')}" th:errors="*{password}">password Error</p>
    @RequestMapping("/demoAdd")
    public String demoAdd(@Valid ValidatorDemo validatorDemo, BindingResult result, Model model){
        System.out.println("result:" + result);
        System.out.println(model );
        // ValidationMessages.properties 国际化文件中 增加 demo.name = `name` is not empty.
        // 然后注解中 用 @NotEmpty(message="{demo.name}")
        //有错误信息.
        // 自定义错误
        result.rejectValue("name", "misFormat", "这个name已经注册过了！");
        model.addAttribute("validatorDemo", validatorDemo);
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for(ObjectError  error:list){
                System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
            }
            return "/validatdemo";
        }
        return "/validatdemo";

    }
}
