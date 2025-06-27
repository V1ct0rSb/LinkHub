package com.linkhub.linkehub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_categorias")
public class CategoriaModel {
    @JsonIgnore
    @OneToMany(mappedBy = "categoriaModel")
    List<LinkModel> linkModelList = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;

    public CategoriaModel(String nome) {
        this.nome = nome;
    }

    public CategoriaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LinkModel> getLinkModelList() {
        return linkModelList;
    }
}
