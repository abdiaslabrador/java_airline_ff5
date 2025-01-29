package dev.project.airline.user;

import java.util.Set;
import dev.project.airline.profile.Profile;

public class UserMapper {
    public static User toEntity(UserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.username());
        user.setPassword(userRequest.password());
        user.setRoles(userRequest.roles());
        
        return user;
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getProfile(),
                user.getRoles());
    }
}
