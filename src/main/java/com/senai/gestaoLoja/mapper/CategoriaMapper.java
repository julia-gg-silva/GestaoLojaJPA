package com.senai.gestaoLoja.mapper;

import com.senai.gestaoLoja.dto.request.CriacaoCategoriaRequisicaoDTO;
import com.senai.gestaoLoja.dto.request.CriacaoProdutoRequisicaoDTO;
import com.senai.gestaoLoja.dto.response.CriacaoCategoriaRespostaDTO;
import com.senai.gestaoLoja.model.Categoria;
import com.senai.gestaoLoja.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria paraEntidade(CriacaoCategoriaRequisicaoDTO requisicaoDTO) {
        return new Categoria(requisicaoDTO.nome(), requisicaoDTO.descricao());
    }

    public CriacaoCategoriaRespostaDTO paraRespostaDTO(Categoria categoria) {
        return new CriacaoCategoriaRespostaDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }

    public Categoria paraUpdate(Categoria categoria, CriacaoCategoriaRequisicaoDTO requisicaoDTO) {

        if (!categoria.getNome().equals(requisicaoDTO.nome()) && requisicaoDTO.nome() != null) {
            categoria.setNome(requisicaoDTO.nome());
        }

        if (!categoria.getDescricao().equals(requisicaoDTO.descricao()) && requisicaoDTO.descricao() != null) {
            categoria.setDescricao(requisicaoDTO.descricao());
        }
        return categoria;
    }
}
