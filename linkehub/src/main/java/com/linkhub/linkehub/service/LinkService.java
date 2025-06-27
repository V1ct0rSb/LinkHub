package com.linkhub.linkehub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkhub.linkehub.dto.LinkCreateDTO;
import com.linkhub.linkehub.dto.LinkResponseDTO;
import com.linkhub.linkehub.entity.CategoriaModel;
import com.linkhub.linkehub.entity.LinkModel;
import com.linkhub.linkehub.repository.CategoriaRepository;
import com.linkhub.linkehub.repository.LinkRepository;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    //POST
    public LinkResponseDTO criarLink(Long categoriaId, LinkCreateDTO linkCreateDTO) {
        CategoriaModel categoriaModel = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!!"));

        LinkModel linkModel = new LinkModel();

        linkModel.setTitulo(linkCreateDTO.titulo());
        linkModel.setUrlOriginal(linkCreateDTO.urlOriginal());
        linkModel.setCategoriaModel(categoriaModel);
        linkModel.setCodigoCurto(UUID.randomUUID().toString().substring(0, 6));

        LinkModel link = linkRepository.save(linkModel);

        return new LinkResponseDTO(
                link.getId(),
                link.getTitulo(),
                link.getUrlOriginal(),
                link.getCodigoCurto(),
                link.getDataCriacao(),
                link.getCategoriaModel().getId()
        );
    }


    //GET
    public List<LinkResponseDTO> listarLink(Long categoriaId) {
        List<LinkModel> linkModelList = linkRepository.findByCategoriaModelId(categoriaId);

        List<LinkResponseDTO> linkResponseDTOList = new ArrayList<>();

        for (LinkModel l : linkModelList) {
            LinkResponseDTO linkResponseDTO = new LinkResponseDTO(
                    l.getId(),
                    l.getTitulo(),
                    l.getUrlOriginal(),
                    l.getCodigoCurto(),
                    l.getDataCriacao(),
                    l.getCategoriaModel().getId()
            );
            linkResponseDTOList.add(linkResponseDTO);
        }
        return linkResponseDTOList;
    }

}
