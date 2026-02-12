package com.example.api.service.impl;

import java.util.List;

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

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO dto){

        Usuario u = new Usuario(null,
                dto.getNombre(),
                dto.getApellido(),
                dto.getUsername(),
                dto.getPassword());

        repo.save(u);

        return new UsuarioResponseDTO(
                dto.getNombre().toUpperCase(),
                dto.getApellido().toUpperCase());
    }

    @Override
    public List<Usuario> listar(){
        return repo.findAll();
    }

    @Override
    public Usuario obtener(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public NombreCompletoDTO params(String nombre,String apellido){
        return new NombreCompletoDTO(nombre+" "+apellido);
    }
}
