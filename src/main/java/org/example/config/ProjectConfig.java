package org.example.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @PostConstruct
    public void init() {
        System.out.println("DASTUR ISHLADI");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("DASTUR QULADI");
    }

}
