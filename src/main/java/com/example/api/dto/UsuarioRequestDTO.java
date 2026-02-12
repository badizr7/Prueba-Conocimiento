package com.example.api.dto;

import lombok.Data;

@Data
public class UsuarioRequestDTO {
    private String nombre;
    private String apellido;
    private String username;
    private String password;
}
