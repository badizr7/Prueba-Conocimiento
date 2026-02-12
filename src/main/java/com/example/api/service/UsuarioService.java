package com.example.api.service;

import java.util.List;

import com.example.api.dto.NombreCompletoDTO;
import com.example.api.dto.UsuarioRequestDTO;
import com.example.api.dto.UsuarioResponseDTO;
import com.example.api.model.Usuario;

public interface UsuarioService {

    UsuarioResponseDTO crear(UsuarioRequestDTO dto);

    List<Usuario> listar();

    Usuario obtener(Long id);

    NombreCompletoDTO params(String nombre,String apellido);
}
