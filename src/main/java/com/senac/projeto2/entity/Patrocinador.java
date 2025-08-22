package com.senac.projeto2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="patrocinador")
public class Patrocinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patrocinador_id")
    private int id;

    @Column(name="patrocinador_nome", nullable = false, length = 50)
    private String nome;

    @Column(name="patrocinador_email", nullable = false, length = 100)
    private String email;

    @Column(name="patrocinador_telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name="patrocinador_status", nullable = false)
    private int status;


}

