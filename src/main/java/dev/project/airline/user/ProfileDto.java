package dev.project.airline.user;

public record  ProfileDto (
    String firstName,
    String lastName,
    String dni,
    String img,
    String email
){
}
