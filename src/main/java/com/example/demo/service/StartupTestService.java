package com.example.demo.service;

import com.example.demo.controller.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupTestService implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private TestRepository repo;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        for (int i=0; i<20; i++)
            repo.execute();

    }
}
