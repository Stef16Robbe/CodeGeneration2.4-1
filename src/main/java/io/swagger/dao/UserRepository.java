package io.swagger.dao;

import io.swagger.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    void deleteByIdEquals(Integer id);
}
