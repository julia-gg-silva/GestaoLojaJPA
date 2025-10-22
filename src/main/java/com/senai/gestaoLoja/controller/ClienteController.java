package com.senai.gestaoLoja.controller;

import com.senai.gestaoLoja.dto.request.CriacaoClienteRequisicaoDTO;
import com.senai.gestaoLoja.dto.response.CriacaoClienteRespostaDTO;
import com.senai.gestaoLoja.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService service;

    @PostMapping
    public ResponseEntity<CriacaoClienteRespostaDTO> criarCliente(
            @Valid @RequestBody CriacaoClienteRequisicaoDTO requisicaoDTO
            ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarCliente(requisicaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CriacaoClienteRespostaDTO>> buscarClientes(){

        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriacaoClienteRespostaDTO> buscarClientePorId(
            @PathVariable Long id
    ){

        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarClientePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriacaoClienteRespostaDTO> atualizarCliente(
            @PathVariable Long id, @Valid@RequestBody CriacaoClienteRequisicaoDTO requisicaoDTO
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.atualizarCliente(id, requisicaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> buscarClientes(
            @PathVariable Long id
    ){
        service.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
