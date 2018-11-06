package com.abcbankinfo.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
public class SwaggerController {

    @ApiIgnore
    @GetMapping("/")
    public RedirectView redirectRootToSwagger() {
        return new RedirectView("/swagger-ui.html");
    }

}
