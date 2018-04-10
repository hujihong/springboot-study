package com.boot.study.properties;

import com.boot.study.SpringbootStudyApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by hujh on 2018/3/26.
 */
@Controller
public class PropertiesController {

    private Logger logger = LoggerFactory.getLogger(PropertiesController.class);

    @Autowired
    WiselySettings wiselySettings;
    @Autowired
    Wisely2Settings wisely2Settings;

    @Value("${path.filePathLocation}")
    private String path;

    // 带默认值
    @Value("${path.filePathLocation1:/User/hujh/Desktop/tmp}")
    private String filePathLocation1;

    @Resource
    private EmployProperty employ;

    @RequestMapping("/prop/test")
    public @ResponseBody
    String test() {
        logger.info(wiselySettings.getGender() + "---" + wiselySettings.getName());
        logger.warn(wisely2Settings.getGender() + "===" + wisely2Settings.getGender());
        logger.error("error...");
        logger.info("path:{}", path);
        logger.info("filePathLocation1:{}", filePathLocation1);
        logger.info("list Employs:{}", wisely2Settings.getEmploys());
        logger.info("wiselySettings:{}", wiselySettings);
        logger.info("employ:{}", employ);
        return "ok";
    }

}
