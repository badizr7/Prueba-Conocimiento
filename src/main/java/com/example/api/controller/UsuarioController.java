package com.example.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dto.NombreCompletoDTO;
import com.example.api.dto.UsuarioRequestDTO;
import com.example.api.dto.UsuarioResponseDTO;
import com.example.api.model.Usuario;
import com.example.api.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    // 1️⃣ Crear usuario (CON AUTENTICACIÓN)
    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioResponseDTO> crear(@RequestBody UsuarioRequestDTO dto) {

        UsuarioResponseDTO response = service.crear(dto);

        return ResponseEntity.ok(response);
    }

    // 2️⃣ Listar todos (SIN AUTENTICACIÓN)
    @GetMapping("/usuarios")
    public List<Usuario> listar() {
        return service.listar();
    }

    // 3️⃣ Obtener por ID (CON AUTENTICACIÓN)
    @GetMapping("/usuarios/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    // 4️⃣ Params (SIN AUTENTICACIÓN)
    @GetMapping("/params")
    public NombreCompletoDTO params(
            @RequestParam String nombre,
            @RequestParam String apellido) {

        return service.params(nombre, apellido);
    }
}
