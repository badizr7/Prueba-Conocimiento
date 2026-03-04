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
import com.example.api.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    // 1️⃣ Crear usuario
    @PostMapping("/usuarios")
    public ResponseEntity<?> crear(@RequestBody UsuarioRequestDTO dto) {
        try {
            return ResponseEntity.ok(service.crear(dto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // 2️⃣ Listar todos
    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // 3️⃣ Obtener por ID
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.obtener(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // 4️⃣ Params
    @GetMapping("/params")
    public ResponseEntity<NombreCompletoDTO> params(
            @RequestParam String nombre,
            @RequestParam String apellido) {

        return ResponseEntity.ok(service.params(nombre, apellido));
    }
}