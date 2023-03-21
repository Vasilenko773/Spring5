package com.example.spring5;

import com.example.spring5.domain.MyXMLBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Spring5Application {

    public static void main(String[] args) {

           try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            MyXMLBean myXMLBean1 = context.getBean("myXMLBean1", MyXMLBean.class);
            System.out.println(myXMLBean1);
        }


    }
}