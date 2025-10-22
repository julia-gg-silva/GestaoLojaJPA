package com.senai.gestaoLoja.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CriacaoCategoriaRequisicaoDTO(

        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "A descrição é obrigatório!")
        String descricao
) {
}
