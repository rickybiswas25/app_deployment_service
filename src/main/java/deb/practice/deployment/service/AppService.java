package deb.practice.deployment.service;

import deb.practice.deployment.entity.GreetingUser;

import java.util.List;

public interface AppService {
    Iterable<GreetingUser> findAllUsers();
    void addData(String name);
}
