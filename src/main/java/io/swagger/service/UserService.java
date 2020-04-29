package io.swagger.service;

import io.swagger.dao.TransactionRepository;
import io.swagger.dao.UserRepository;
import io.swagger.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    public void createUser(User user) {userRepository.save(user);}

    @Modifying
    public void updateUser(User user) {userRepository.save(user);}

    public User getUserById(Long id) {
        return userRepository.getUserByIdEquals(id);
    }

    public User login(String username, String password) {
        return userRepository.getUserByUsernameEqualsAndPasswordEquals(username, password);
    }

}
