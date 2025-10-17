package com.senai.gestaoLoja.dto.request;

public record CriacaoProdutoRequisicaoDTO(


        String nome,
        String descricao,
        double preco,
        int quantidade
) {
}
