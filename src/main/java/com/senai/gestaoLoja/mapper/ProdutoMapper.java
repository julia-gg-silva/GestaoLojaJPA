package com.senai.gestaoLoja.mapper;

import com.senai.gestaoLoja.dto.request.CriacaoProdutoRequisicaoDTO;
import com.senai.gestaoLoja.dto.response.CriacaoProdutoRespostaDTO;
import com.senai.gestaoLoja.model.Produto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProdutoMapper {

    public CriacaoProdutoRespostaDTO paraRespostaDTO(Produto produto){
        return new CriacaoProdutoRespostaDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade());
    }

    public Produto paraEntidade(CriacaoProdutoRequisicaoDTO requisicaoDTO){
        return new Produto(requisicaoDTO.nome(), requisicaoDTO.descricao(), requisicaoDTO.preco(), requisicaoDTO.quantidade());
    }

    public Produto paraUpdate(Produto produto, CriacaoProdutoRequisicaoDTO requisicaoDTO){

        if(!produto.getNome().equals(requisicaoDTO.nome()) && requisicaoDTO.nome() != null){
            produto.setNome(requisicaoDTO.nome());
        }

        if(!produto.getDescricao().equals(requisicaoDTO.descricao()) && requisicaoDTO.descricao() != null){
            produto.setDescricao(requisicaoDTO.descricao());
        }

        if((!Objects.equals(produto.getPreco(), requisicaoDTO.preco()))){
            produto.setPreco(requisicaoDTO.preco());
        }

        if(!(produto.getQuantidade() == requisicaoDTO.quantidade())){
            produto.setQuantidade(requisicaoDTO.quantidade());
        }
        return produto;
    }
}
