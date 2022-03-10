package com.umebo.nbpapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.umebo.nbpapi.controller",
        "com.umebo.nbpapi.service"
})
public class TestConfiguration {

}
