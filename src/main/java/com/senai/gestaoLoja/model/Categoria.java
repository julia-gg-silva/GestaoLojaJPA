package com.senai.gestaoLoja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Lob
    @Column(nullable = false)
    private String descricao;

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
