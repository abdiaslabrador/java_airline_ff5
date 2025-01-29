package dev.project.airline.user;

import java.util.Set;

import dev.project.airline.profile.Profile;
import dev.project.airline.roles.Role;

public record  UserResponse (
    Long id,
    String username,
    String password,
    Profile profile,
    Set<Role> roles
) {
}
