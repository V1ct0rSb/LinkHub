package com.linkhub.linkehub.service;

import com.linkhub.linkehub.dto.CategoriaDTO;
import com.linkhub.linkehub.entity.CategoriaModel;
import com.linkhub.linkehub.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //POST
    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = new CategoriaModel(categoriaDTO.nome());
        CategoriaModel salvo = categoriaRepository.save(categoriaModel);

        return new CategoriaDTO(salvo.getId(), salvo.getNome());
    }

    //GET
    public List<CategoriaDTO> listarCategoria() {
        List<CategoriaModel> categoriaModelList = categoriaRepository.findAll();

        return categoriaModelList.stream().map(u -> new CategoriaDTO(u.getId(), u.getNome())).toList();
    }

}
