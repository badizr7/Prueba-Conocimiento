package com.example.api.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.api.dto.NombreCompletoDTO;
import com.example.api.dto.UsuarioRequestDTO;
import com.example.api.dto.UsuarioResponseDTO;
import com.example.api.model.Usuario;
import com.example.api.repository.UsuarioRepository;
import com.example.api.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO dto){

        // Validar username duplicado
        if (repo.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("El username ya existe");
        }

        String passwordEncriptado = passwordEncoder.encode(dto.getPassword());

        Usuario usuario = Usuario.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .username(dto.getUsername())
                .password(passwordEncriptado)
                .build();

        Usuario guardado = repo.save(usuario);

        return new UsuarioResponseDTO(
                guardado.getNombre().toUpperCase(),
                guardado.getApellido().toUpperCase()
        );
    }

    @Override
    public List<UsuarioResponseDTO> listar(){
        return repo.findAll()
                .stream()
                .map(u -> new UsuarioResponseDTO(
                        u.getNombre(),
                        u.getApellido()))
                .toList();
    }

    @Override
    public UsuarioResponseDTO obtener(Long id){

        Usuario usuario = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        return new UsuarioResponseDTO(
                usuario.getNombre(),
                usuario.getApellido()
        );
    }

    @Override
    public NombreCompletoDTO params(String nombre,String apellido){
        return new NombreCompletoDTO(nombre + " " + apellido);
    }
}