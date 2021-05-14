package deb.practice.deployment.service;

import deb.practice.deployment.entity.GreetingUser;
import deb.practice.deployment.repository.AppServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("appService")
public class AppServiceImpl implements AppService {
    private final AppServiceRepository repo;

    @Autowired
    public AppServiceImpl(AppServiceRepository repo) {
        this.repo = repo;
    }

    @Override
    public Iterable<GreetingUser> findAllUsers() {
        return this.repo.findAll();
    }

    @Override
    public void addData(String name) {
        Optional<GreetingUser> existingName = this.repo.findOneByName(name);
        if (existingName.isEmpty()) {
            this.repo.save(new GreetingUser(name));
        }
    }
}
