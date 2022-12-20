package com.example.zup.application.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @Column(length = 100, nullable = false)
    @NotNull(message = "sobrenome é obrigatório")
    private String sobrenome;

    @Transient
    private String nomeCompleto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo de pessoa é obrigatório")
    private TipoPessoa tipoPessoa;

    @Column(length = 15, nullable = false, unique = true)
    @NotNull(message = "Documento é obrigatório")
    private String documento;

    private LocalDate nascimento;

    private LocalDate dataCadastro;

    @Column(length = 100)
    @Email(message = "Email não é valido")
    private String email;

    @PrePersist
    private void setValoresPadrao(){
        dataCadastro = LocalDate.now();
    }

    private String getNomeCompleto(){
        return this.nome + this.nomeCompleto;
    }
}
