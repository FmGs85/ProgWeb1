package com.senac.projeto2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categoria_id")
    private int id;

    @Column(name="categoria_nome", nullable = false, length = 50)
    private String nome;

    @Column(name="categoria_descricao", length = 200)
    private String descricao;


}
