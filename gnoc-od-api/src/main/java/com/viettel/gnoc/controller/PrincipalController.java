package com.viettel.gnoc.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrincipalController.class);

    @GetMapping("/me")
    public Principal getUser(Principal principal) {
        return principal;
    }

}
