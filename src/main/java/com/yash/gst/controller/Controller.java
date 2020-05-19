package com.yash.gst.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/rss-feed-converter")
    public String home() {
        return "rss-feed-converter is running";
    }
}
