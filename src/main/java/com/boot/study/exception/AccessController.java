package com.boot.study.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hujh on 2018/3/24.
 */
@Controller
public class AccessController {

        // ExceptionHandler 一个类里只能出现一次，否则会出现 Ambiguous @ExceptionHandler method mapped for [
        Logger logger = LoggerFactory.getLogger(AccessController.class);
        /**
         * 当这个Controller中任何一个方法发生异常，一定会被这个方法拦截到。然后，输出日志。封装Map并返回，页面上得到status为false
         * 异常页面控制
         * @param runtimeException
         * @return
         */
        @ExceptionHandler(RuntimeException.class)
        public @ResponseBody
        Map<String, Object> runtimeExceptionHandler(RuntimeException runtimeException) {

            logger.error(runtimeException.getLocalizedMessage());
            Map model = new TreeMap();
            model.put("status", false);
            return model;
        }

        /**
         * 异常页面控制 返回一个页面
         * @param runtimeException
         * @param modelMap
         * @return
         */
//        @ExceptionHandler(RuntimeException.class)
//        public String runtimeExceptionHandler(RuntimeException runtimeException,
//                                              ModelMap modelMap) {
//            logger.error(runtimeException.getLocalizedMessage());
//            modelMap.put("status", "false");
//            return "exception";
//        }

    @RequestMapping("/ex")
    public Integer ex() {
        return 10/0;
    }

}
