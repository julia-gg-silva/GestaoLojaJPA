package com.senai.gestaoLoja.dto.response;

public record CriacaoClienteRespostaDTO(

        Long id,
        String nome,
        String email,
        String telefone,
        String cpf
){
}
