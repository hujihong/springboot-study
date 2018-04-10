package com.boot.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


// 使用 @ControllerAdvice，不用任何的配置，只要把这个类放在项目中，Spring能扫描到的地方。就可以实现全局异常的回调
@ControllerAdvice
    public class SpringExceptionHandler{  
      /** 
         * 全局处理Exception 
         * 错误的情况下返回500 
         * @param ex 
         * @param req 
         * @return 
         */  
        @ExceptionHandler(value = {Exception.class})
        public ResponseEntity<Object> handleOtherExceptions(final Exception ex, final WebRequest req) {
            TResult tResult = new TResult();  
            tResult.setStatus(500);
            tResult.setErrorMessage(ex.getMessage());  
            return new ResponseEntity<Object>(tResult, HttpStatus.OK);
        }  
      
    }  