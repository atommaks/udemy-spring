package ru.atom.springstarterannotation.config.bpp;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.atom.springstarterannotation.annotation.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionBeanPostProcessor implements BeanPostProcessor {
    /**
     * так как спринг сам очень часто использует прокси, в AfterInit нам может вернуться прокси класс, а нам нужен
     * именно наш класс. Поэтому в PostInit мы наш класс засунем в мапу, т.к. в Post не может вернутьс прокси класс
     */
    private final Map<String, Class<?>> transactionBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Transaction.class)) {
            transactionBeans.putIfAbsent(beanName, bean.getClass());
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = transactionBeans.getOrDefault(beanName, null);
        if (beanClass != null) {
            ProxyFactoryBean pfb = new ProxyFactoryBean();
            pfb.setTarget(bean);
            pfb.setAutodetectInterfaces(false);
            NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
            Arrays.stream(beanClass.getMethods()).forEach(m -> advisor.addMethodName(m.getName()));
            advisor.setAdvice((MethodInterceptor) invocation -> {
                System.out.println("Start transaction for method: " + invocation.getMethod().getName());
                Object result = invocation.getMethod().invoke(invocation.getThis(), invocation.getArguments());
                System.out.println("End transaction for method: " + invocation.getMethod().getName());
                return result;
            });
            pfb.addAdvisor(advisor);

            return pfb.getObject();
        }

        return bean;
    }
}
