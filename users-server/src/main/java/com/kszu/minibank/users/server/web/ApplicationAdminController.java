package com.kszu.minibank.users.server.web;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ApplicationAdminController {

    @PostMapping("/actuator/refresh")
    public void refreshBeans(){}

}
