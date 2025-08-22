package com.senac.projeto2.entity;

import jakarta.persistence.*;

@Entity
@Table(name="participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="participante_id")
    private int id;

    @Column(name="participante_nome", nullable = false, length = 50)
    private String nome;

    @Column(name="participante_email", nullable = false, length = 100)
    private String email;

    @Column(name="participante_telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name="participante_status", nullable = false)
    private int status;


}
