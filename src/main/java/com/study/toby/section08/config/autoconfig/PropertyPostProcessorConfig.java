package com.study.toby.section08.config.autoconfig;

import com.study.toby.section08.config.MyAutoConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Map;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
import static org.springframework.core.annotation.AnnotationUtils.getAnnotationAttributes;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    BeanPostProcessor propertyPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean,
                                                         String beanName) throws BeansException {
                MyConfigurationProperties annotation = findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if (annotation == null) return bean;

                Map<String, Object> attributes = getAnnotationAttributes(annotation);
                String prefix = (String) attributes.get("prefix");

                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }
}
