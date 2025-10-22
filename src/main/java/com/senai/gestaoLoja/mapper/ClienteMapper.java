package com.senai.gestaoLoja.mapper;

import com.senai.gestaoLoja.dto.request.CriacaoClienteRequisicaoDTO;
import com.senai.gestaoLoja.dto.response.CriacaoClienteRespostaDTO;
import com.senai.gestaoLoja.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente paraEntidade(CriacaoClienteRequisicaoDTO requisicaoDTO) {
        return new Cliente(requisicaoDTO.nome(), requisicaoDTO.email(), requisicaoDTO.telefone(), requisicaoDTO.cpf());
    }

    public CriacaoClienteRespostaDTO paraRespostaDTO(Cliente cliente) {
        return new CriacaoClienteRespostaDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf());
    }

    public Cliente paraUpdate(Cliente cliente, CriacaoClienteRequisicaoDTO requisicaoDTO) {

        if (!cliente.getNome().equals(requisicaoDTO.nome()) && requisicaoDTO.nome() != null) {
            cliente.setNome(requisicaoDTO.nome());
        }

        if (!cliente.getEmail().equals(requisicaoDTO.email()) && requisicaoDTO.email() != null) {
            cliente.setEmail(requisicaoDTO.email());
        }

        if (!cliente.getTelefone().equals(requisicaoDTO.telefone()) && requisicaoDTO.telefone() != null) {
            cliente.setTelefone(requisicaoDTO.telefone());
        }

        if (!cliente.getCpf().equals(requisicaoDTO.cpf()) && requisicaoDTO.cpf() != null) {
            cliente.setCpf(requisicaoDTO.cpf());
        }

        return cliente;
    }
}
