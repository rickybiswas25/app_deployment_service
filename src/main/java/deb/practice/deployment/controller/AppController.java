package deb.practice.deployment.controller;

import deb.practice.deployment.entity.GreetingUser;
import deb.practice.deployment.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AppController {
    private final AppService appService;

    @Autowired
    public AppController(@Qualifier("appService") AppService appService) {
        this.appService = appService;
    }

    @PostMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        this.appService.addData(name);
        return String.format("Hello %s from app-deployment service", name);
    }

    @GetMapping("/users")
    public Iterable<GreetingUser> findAllUser() {
        return this.appService.findAllUsers();
    }


}
