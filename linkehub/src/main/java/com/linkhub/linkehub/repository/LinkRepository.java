package com.linkhub.linkehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.linkhub.linkehub.entity.LinkModel;

public interface LinkRepository extends JpaRepository<LinkModel, Long> {

    List<LinkModel> findByCategoriaModelId(Long categoriaId);
}
