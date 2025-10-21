package com.senai.gestaoLoja.service;

import com.senai.gestaoLoja.dto.request.CriacaoProdutoRequisicaoDTO;
import com.senai.gestaoLoja.dto.response.CriacaoProdutoRespostaDTO;
import com.senai.gestaoLoja.mapper.ProdutoMapper;
import com.senai.gestaoLoja.model.Produto;
import com.senai.gestaoLoja.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository repository;
    private ProdutoMapper mapper;

    public CriacaoProdutoRespostaDTO criarProduto(CriacaoProdutoRequisicaoDTO requisicaoDTO){
        if(repository.existsByNome(requisicaoDTO.nome())){
            throw new RuntimeException("Produto já cadastrado!");
        }
        return mapper.paraRespostaDTO(repository.save(mapper.paraEntidade(requisicaoDTO)));
    }

    public List<CriacaoProdutoRespostaDTO> buscarProdutos(){
        return repository.findAll().stream()
                .map(mapper::paraRespostaDTO)
                .toList();
    }

    public CriacaoProdutoRespostaDTO buscarProdutoPorId(Long id){
        Produto produto = repository.findById(id).orElseThrow(() ->
                 new RuntimeException("Produto não encontrado!"));

        return mapper.paraRespostaDTO(produto);
    }

    public CriacaoProdutoRespostaDTO atualizarProduto(Long id, CriacaoProdutoRequisicaoDTO requisicaoDTO){
        Produto produto = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Produto não encontrado!"));

        Produto newProduto = mapper.paraUpdate(produto, requisicaoDTO);
        repository.save(newProduto);
        return mapper.paraRespostaDTO(newProduto);
    }

    public void deletarProduto(Long id){
        Produto produto = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Produto não encontrado!"));

        repository.deleteById(id);

    }
}
