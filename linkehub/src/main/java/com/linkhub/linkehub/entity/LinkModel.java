package com.linkhub.linkehub.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_links")
public class LinkModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String urlOriginal;
    @Column(nullable = false, unique = true)
    private String codigoCurto;
    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @JoinColumn(name = "categoria_id")
    @ManyToOne
    private CategoriaModel categoriaModel;

    public LinkModel() {
        this.dataCriacao = LocalDateTime.now();
    }

    public LinkModel(CategoriaModel categoriaModel,
                     Integer cliques,
                     String codigoCurto,
                     LocalDateTime dataCriacao,
                     String titulo,
                     String urlOriginal) {
        this.categoriaModel = categoriaModel;
        this.codigoCurto = codigoCurto;
        this.dataCriacao = LocalDateTime.now();
        this.titulo = titulo;
        this.urlOriginal = urlOriginal;
    }

    public CategoriaModel getCategoriaModel() {
        return categoriaModel;
    }

    public void setCategoriaModel(CategoriaModel categoriaModel) {
        this.categoriaModel = categoriaModel;
    }

    public String getCodigoCurto() {
        return codigoCurto;
    }

    public void setCodigoCurto(String codigoCurto) {
        this.codigoCurto = codigoCurto;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }
}
