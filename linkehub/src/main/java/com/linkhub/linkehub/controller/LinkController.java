package com.linkhub.linkehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.linkhub.linkehub.dto.LinkCreateDTO;
import com.linkhub.linkehub.dto.LinkResponseDTO;
import com.linkhub.linkehub.service.LinkService;

@RestController
@RequestMapping(value = "/api")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/categorias/{categoriaId}/links")
    public ResponseEntity<LinkResponseDTO> criarLink(@PathVariable Long categoriaId,
                                                     @RequestBody LinkCreateDTO linkCreateDTO) {
        LinkResponseDTO linkResponseDTO = linkService.criarLink(categoriaId, linkCreateDTO);
        return ResponseEntity.status(201).body(linkResponseDTO);
    }


    @GetMapping("/categorias/{categoriaId}/links")
    public ResponseEntity<List<LinkResponseDTO>> listarLink(@PathVariable Long categoriaId) {
        List<LinkResponseDTO> linkResponseDTOList = linkService.listarLink(categoriaId);
        return ResponseEntity.ok().body(linkResponseDTOList);
    }
}
