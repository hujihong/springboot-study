package com.boot.study.registrybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Created by hujh on 2018/3/31.
 */
public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        RootBeanDefinition helloBean = new RootBeanDefinition(Hello.class);

        //新增Bean定义
        beanDefinitionRegistry.registerBeanDefinition("hello", helloBean);

        RootBeanDefinition worldBean = new RootBeanDefinition(WorldImpl.class);
        beanDefinitionRegistry.registerBeanDefinition("world", worldBean);

        RootBeanDefinition worldBean2 = new RootBeanDefinition(WorldImpl2.class);
        beanDefinitionRegistry.registerBeanDefinition("world2", worldBean2);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
