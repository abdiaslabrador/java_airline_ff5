package dev.project.airline.user;

import java.util.Set;

import dev.project.airline.roles.Role;

public record UserRequest(
    String username,
    String password,
    ProfileDto profile,
    Set<Role> roles
) {
}
