package fr.nassing.nauth.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nassing.nauth.service.TestService;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping
    public String test() {
        return testService.test();
    }
}