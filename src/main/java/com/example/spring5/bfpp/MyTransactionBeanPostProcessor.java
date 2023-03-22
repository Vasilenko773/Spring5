package com.example.spring5.bfpp;

import com.example.spring5.domain.MyTransaction;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.beans.Transient;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MyTransactionBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Class<?>> transactionBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(MyTransaction.class)) {
            transactionBeans.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = transactionBeans.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("Open transactional");
                        try {
                            return method.invoke(bean, args);
                        } finally {
                            System.out.println("Close transactional");
                        }
                    });
        }
        return bean;
    }
}
