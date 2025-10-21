package com.senai.gestaoLoja.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CriacaoProdutoRequisicaoDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "A descrição é obrigatória!")
        String descricao,

        @Positive(message = "O preço deve ser mais que 0!")
        BigDecimal preco,

        @Positive(message = "A quantidade deve ser maior que 0!")
        int quantidade
) {
}
