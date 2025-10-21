package com.senai.gestaoLoja.dto.response;

public record CriacaoProdutoRespostaDTO(

        Long id,
        String nome,
        String descricao,
        java.math.BigDecimal preco,
        int quantidade
) {
}
