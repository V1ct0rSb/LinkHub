package com.linkhub.linkehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.linkhub.linkehub.dto.CategoriaDTO;
import com.linkhub.linkehub.service.CategoriaService;

@RestController
@RequestMapping(value = "/api")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO categoria = categoriaService.criarCategoria(categoriaDTO);
        return ResponseEntity.status(201).body(categoria);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDTO>> listarCategoria() {
        List<CategoriaDTO> categoriaDTOList = categoriaService.listarCategoria();
        return ResponseEntity.ok().body(categoriaDTOList);
    }
}
