package com.senac.projeto2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="premio")
public class Premio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="premio_id")
    private int id;

    @Column(name="premio_nome", nullable = false, length = 50)
    private String nome;

    @Column(name="premio_descricao", length = 200)
    private String descricao;

    @Column(name="premio_valor", nullable = false)
    private double valor;


}
