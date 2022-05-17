package edu.laverno;

import edu.laverno.service.TestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");

        TestService service = context.getBean(TestService.class);

        service.startTesting();

        context.close();
    }
}
