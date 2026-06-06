package io.aiven.spring.mysql.springboot1;

import org.springframework.data.repository.CrudRepository;
import io.aiven.spring.mysql.springboot1.User;

public interface UserRepository  extends CrudRepository<User,Integer> {

}
