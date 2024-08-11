package com.example.appSpring.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class myController {

    @GetMapping("/show")
    public void show(HttpServletResponse res) throws IOException {
        PrintWriter out=res.getWriter();
        out.println("Welcome to Java MVC ");
    }

    @GetMapping("/info")
    public void info(HttpServletResponse res) throws IOException {
        PrintWriter out=res.getWriter();
        String name = "Suhas N H";
        out.println("Name : "+name);
    }
}
