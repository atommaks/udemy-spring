package ru.atom.eventlistener.config.bfpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecondBeanPostProcessor implements BeanFactoryPostProcessor, Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("Started class: {}", this.getClass().getName());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
