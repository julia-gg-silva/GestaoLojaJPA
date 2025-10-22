package com.senai.gestaoLoja.service;

import com.senai.gestaoLoja.dto.request.CriacaoCategoriaRequisicaoDTO;
import com.senai.gestaoLoja.dto.response.CriacaoCategoriaRespostaDTO;
import com.senai.gestaoLoja.dto.response.CriacaoProdutoRespostaDTO;
import com.senai.gestaoLoja.mapper.CategoriaMapper;
import com.senai.gestaoLoja.model.Categoria;
import com.senai.gestaoLoja.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaMapper mapper;
    private CategoriaRepository repository;

    public CriacaoCategoriaRespostaDTO criarCategoria(CriacaoCategoriaRequisicaoDTO requisicaoDTO){
        if(repository.existsByNome(requisicaoDTO.nome())){
            throw new RuntimeException("A Categoria já foi cadastrada!");
        }
        return mapper.paraRespostaDTO(repository.save(mapper.paraEntidade(requisicaoDTO)));
    }

    public List<CriacaoCategoriaRespostaDTO> buscarCategorias(){
        return repository.findAll().stream()
                .map(mapper::paraRespostaDTO)
                .toList();
    }

    public CriacaoCategoriaRespostaDTO buscarCategoriaPorId(Long id){
        Categoria categoria = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada!"));

        return mapper.paraRespostaDTO(categoria);
    }

    public CriacaoCategoriaRespostaDTO atualizarCategoria(Long id, CriacaoCategoriaRequisicaoDTO requisicaoDTO){
        Categoria categoria = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada!"));

        Categoria newCategoria = mapper.paraUpdate(categoria, requisicaoDTO);
        repository.save(newCategoria);
        return mapper.paraRespostaDTO(newCategoria);
    }

    public void deletarCategoria(Long id){
        Categoria categoria = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada!"));

        repository.deleteById(id);
    }
}
