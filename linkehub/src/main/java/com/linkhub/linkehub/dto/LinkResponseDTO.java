package com.linkhub.linkehub.dto;

import java.time.LocalDateTime;

public record LinkResponseDTO(Long id, String titulo, String urlOriginal, String codigoCurto,
                              LocalDateTime dataCriacao, Long categoriaId) {
}
