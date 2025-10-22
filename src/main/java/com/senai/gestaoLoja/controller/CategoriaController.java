package com.senai.gestaoLoja.controller;

import com.senai.gestaoLoja.dto.request.CriacaoCategoriaRequisicaoDTO;
import com.senai.gestaoLoja.dto.response.CriacaoCategoriaRespostaDTO;
import com.senai.gestaoLoja.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaController {

    private CategoriaService service;

    @PostMapping
    public ResponseEntity<CriacaoCategoriaRespostaDTO> criarCategoria(
            @Valid @RequestBody CriacaoCategoriaRequisicaoDTO requisicaoDTO
            ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarCategoria(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CriacaoCategoriaRespostaDTO>> buscarCategorias(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoCategoriaRespostaDTO> buscarCategoriaPorId(
            @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarCategoriaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoCategoriaRespostaDTO> atualizarCategoria(
            @PathVariable Long id, @RequestBody CriacaoCategoriaRequisicaoDTO requisicaoDTO
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.atualizarCategoria(id, requisicaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(
            @PathVariable Long id
    ){
        service.deletarCategoria(id);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
