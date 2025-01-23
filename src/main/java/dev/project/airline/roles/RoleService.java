package dev.project.airline.roles;

import java.util.HashSet;
import java.util.Set;

import dev.project.airline.roles.exceptions.RoleNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
 
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role getById(Long id) {
        Role role = repository.findById(id).orElseThrow( () -> new RoleNotFoundException("Role not found"));
        return role;
    }

    public Set<Role> assignDefaultRole() {
        Role defaultRole = this.getById(1L);

        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        return roles;
    }

}
