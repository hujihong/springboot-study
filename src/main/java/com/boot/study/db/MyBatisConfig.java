package com.boot.study.db;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by hujh on 2018/4/1.
 */
@Configuration
@MapperScan("com.boot.study.*.mapper")
public class MyBatisConfig {


//    @Bean
//    public PageHelper pageHelper() {
//        System.out.println("MyBatisConfiguration.pageHelper()");
//        PageHelper pageHelper = new PageHelper();
//        Properties p = new Properties();
//        p.setProperty("offsetAsPageNum", "true");
//        p.setProperty("rowBoundsWithCount", "true");
//        p.setProperty("reasonable", "true");
//        pageHelper.setProperties(p);
//        return pageHelper;
//
//    }

    /**
     * 重新定义了SqlSessionFactory但是并没有配置对应的PageHelper插件，
     * 所以导致使用PageHelper.startPage(1,1);无效，那么如果要重新定义SqlSessionFactory的话，
     * 那么以下代码可以作为一个参考，其中红色部分是需要注意的地方：

     @Bean
     public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
     SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
     sqlSessionFactoryBean.setDataSource(dataSource);
     PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
     Interceptor[] plugins =  new Interceptor[]{pageHelper()};
     sqlSessionFactoryBean.setPlugins(plugins);
     // 指定mybatisxml文件路径
     sqlSessionFactoryBean.setMapperLocations(resolver
     .getResources("classpath:/mybatis/*.xml"));
     returnsqlSessionFactoryBean.getObject();
     }
     */

}
