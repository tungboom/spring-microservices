package com.viettel.services.sso.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author TungBoom
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SsoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoAuthApplication.class, args);
    }
}
