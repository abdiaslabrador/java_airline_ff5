package dev.project.airline.register;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.project.airline.user.UserRequest;

@RestController
@RequestMapping("/api/v1/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService  registerService) {
        this.registerService = registerService;
    }

    @PostMapping("")
    public ResponseEntity<Map<String,String>> register(@RequestBody UserRequest newUser) {

        Map<String, String> response = registerService.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
