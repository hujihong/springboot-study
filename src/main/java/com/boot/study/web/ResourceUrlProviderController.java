package com.boot.study.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * Created by hujh on 2018/3/24.
 * MD5的方式
 */
@ControllerAdvice
public class ResourceUrlProviderController {

    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @ModelAttribute("urls")
    public ResourceUrlProvider urls() {
        System.out.println("urls...");
        String path = resourceUrlProvider.getForLookupPath("/jquery-3.3.1.min.js");
        System.out.println(path);
        return this.resourceUrlProvider;
    }
}
