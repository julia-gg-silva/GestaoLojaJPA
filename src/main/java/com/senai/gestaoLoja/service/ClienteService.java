package com.senai.gestaoLoja.service;

import com.senai.gestaoLoja.dto.request.CriacaoClienteRequisicaoDTO;
import com.senai.gestaoLoja.dto.response.CriacaoClienteRespostaDTO;
import com.senai.gestaoLoja.mapper.ClienteMapper;
import com.senai.gestaoLoja.model.Cliente;
import com.senai.gestaoLoja.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository repository;
    private ClienteMapper mapper;


    public CriacaoClienteRespostaDTO criarCliente(CriacaoClienteRequisicaoDTO requisicaoDTO){
        if(repository.existsByNome(requisicaoDTO.nome())){
            throw new RuntimeException("Cliente já cadastrado!");
        }
        return mapper.paraRespostaDTO(repository.save(mapper.paraEntidade(requisicaoDTO)));
    }

    public List<CriacaoClienteRespostaDTO> buscarClientes(){
        return repository.findAll().stream()
                .map(mapper::paraRespostaDTO)
                .toList();
    }

    public CriacaoClienteRespostaDTO buscarClientePorId(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(() ->
                new RuntimeException("O Cliente não existe!"));

        return mapper.paraRespostaDTO(cliente);
    }

    public CriacaoClienteRespostaDTO atualizarCliente(Long id, CriacaoClienteRequisicaoDTO requisicaoDTO){
        Cliente cliente = repository.findById(id).orElseThrow(() ->
                new RuntimeException("O Cliente não existe!"));

        Cliente newCliente = mapper.paraUpdate(cliente, requisicaoDTO);
        repository.save(newCliente);
        return mapper.paraRespostaDTO(newCliente);

    }

    public void deletarCliente(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(() ->
                new RuntimeException("O Cliente não existe!"));

        repository.deleteById(id);
    }

}
