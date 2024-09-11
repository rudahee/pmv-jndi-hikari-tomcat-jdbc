package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TestRepository {

    private final DataSource dataSource;

    @Autowired
    public TestRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void execute() {
        System.out.println(this.dataSource);
    }

}
