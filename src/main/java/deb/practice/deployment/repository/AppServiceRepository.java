package deb.practice.deployment.repository;

import deb.practice.deployment.entity.GreetingUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppServiceRepository extends CrudRepository<GreetingUser, Integer> {
    Optional<GreetingUser> findOneByName(String name);

}
