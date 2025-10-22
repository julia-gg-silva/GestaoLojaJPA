package com.senai.gestaoLoja.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CriacaoClienteRequisicaoDTO(

        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @Email(message = "Formato de email incorreto!")
        String email,

        @NotBlank(message = "O telefone obrigatório!")
        String telefone,

        @NotBlank(message = "O cpf obrigatório!")
        String cpf
){
}
