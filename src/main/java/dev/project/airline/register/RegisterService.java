package dev.project.airline.register;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;
import java.util.Base64.Decoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.project.airline.profile.Profile;
import dev.project.airline.profile.ProfileRepository;
import dev.project.airline.roles.RoleService;
import dev.project.airline.user.User;
import dev.project.airline.user.UserRepository;
import dev.project.airline.user.UserRequest;

@Service
public class RegisterService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final RoleService roleService;

    public RegisterService(UserRepository userRepository, RoleService roleService, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.profileRepository = profileRepository;
    }

    public Map<String, String> save(UserRequest userData) {

        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(userData.password());
        String passwordDecoded = new String(decodedBytes);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncoded = encoder.encode(passwordDecoded);

        User newUser = new User(userData.username(), passwordEncoded);

        if(userData.roles().isEmpty()){
            newUser.setRoles(roleService.assignDefaultRole());
        } else {
            newUser.setRoles(userData.roles());
        }

        userRepository.save(newUser);
        Profile profile = new Profile(userData.profile().firstName(), userData.profile().lastName(), userData.profile().dni(), userData.profile().img(), userData.profile().email());
        profile.setUser(newUser);
        profileRepository.save(profile);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Success");

        return response;
    }

}






























