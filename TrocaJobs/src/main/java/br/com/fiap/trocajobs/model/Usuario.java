package br.com.fiap.trocajobs.model;

import java.util.Random;

public record Usuario(Long id, String imagemPerfil, String senha, String email, String nome, String sobrenome, String telefone, String profissao, String localidade, String sobreMim) {
    public Usuario(Long id, String imagemPerfil, String senha, String email, String nome, String sobrenome, String telefone, String profissao, String localidade, String sobreMim){
        this.id = Math.abs( new Random().nextLong() );
        this.imagemPerfil = imagemPerfil;
        this.senha = senha;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.profissao = profissao;
        this.localidade = localidade;
        this.sobreMim = sobreMim;
    }

}

    