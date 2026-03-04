package com.example.api.service;

import java.util.List;

import com.example.api.dto.NombreCompletoDTO;
import com.example.api.dto.UsuarioRequestDTO;
import com.example.api.dto.UsuarioResponseDTO;

public interface UsuarioService {

    UsuarioResponseDTO crear(UsuarioRequestDTO dto);

    List<UsuarioResponseDTO> listar();

    UsuarioResponseDTO obtener(Long id);

    NombreCompletoDTO params(String nombre, String apellido);
}