package dev.project.airline.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse findAll(){
        User users = repository.findByUsername("jose").get();
        return UserMapper.toResponse(users);
    }
}