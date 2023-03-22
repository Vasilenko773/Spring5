package com.example.spring5;

import com.example.spring5.domain.MyBeanInjectAnnotation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Spring5Application {

    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            MyBeanInjectAnnotation injectAnnotationBean = context.getBean("myBeanInjectAnnotation",
                    MyBeanInjectAnnotation.class);

            System.out.println(injectAnnotationBean);
        }
    }
}