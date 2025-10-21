package com.senai.gestaoLoja.controller;

import com.senai.gestaoLoja.dto.request.CriacaoProdutoRequisicaoDTO;
import com.senai.gestaoLoja.dto.response.CriacaoProdutoRespostaDTO;
import com.senai.gestaoLoja.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService service;

    @PostMapping
    public ResponseEntity<CriacaoProdutoRespostaDTO> criarProduto(
            @Valid @RequestBody CriacaoProdutoRequisicaoDTO requisicaoDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarProduto(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CriacaoProdutoRespostaDTO>> buscarProdutos(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoProdutoRespostaDTO> buscarProdutoPorId(
            @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarProdutoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoProdutoRespostaDTO> atualizaProduto(
            @PathVariable Long id, @Valid@RequestBody CriacaoProdutoRequisicaoDTO requisicaoDTO
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.atualizarProduto(id, requisicaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(
            @PathVariable Long id
    ){
        service.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
