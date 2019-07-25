package com.neuedu.project.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController2 {
    private Logger log = Logger.getLogger(PageController2.class);

    @GetMapping(value = "/{page}.html")
    public String htmlRedirect(@PathVariable String page) {
        log.info("Trying to visit " + page + ".html");
        return page;
    }

    @GetMapping(value = "/{page}.jsp")
    public String jspRedirect(@PathVariable String page) {
        log.info("Trying to visit " + page + ".jsp");
        return page;
    }
}
