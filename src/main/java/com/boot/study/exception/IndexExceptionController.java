package com.boot.study.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hujh on 2018/3/24.
 */
@Controller
public class IndexExceptionController {

    Logger logger = LoggerFactory.getLogger(AccessController.class);


//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public void processMethod(MissingServletRequestParameterException ex, HttpServletRequest request , HttpServletResponse response) throws IOException {
//        System.out.println("抛异常了！"+ex.getLocalizedMessage());
//        logger.error("抛异常了！"+ex.getLocalizedMessage());
//        response.getWriter().printf(ex.getMessage());
//        response.flushBuffer();
//    }

    @RequestMapping("/index1")
    public String index1(@RequestParam String id, ModelMap modelMap){
        return "login";
    }

}
