package deb.practice.deployment.controller;

import deb.practice.deployment.config.AppDeploymentConfig;
import deb.practice.deployment.entity.GreetingUser;
import deb.practice.deployment.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AppController {
    private final AppService appService;
    private final AppDeploymentConfig config;

    @Autowired
    public AppController(@Qualifier("appService") AppService appService, AppDeploymentConfig config) {
        this.appService = appService;
        this.config = config;
    }

    @PostMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        this.appService.addData(name);
        return String.format(this.config.getWelComeMessageFormat(), name);
    }

    @GetMapping("/users")
    public Iterable<GreetingUser> findAllUser() {
        return this.appService.findAllUsers();
    }


}
