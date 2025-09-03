package com.minispotify.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private List<Playlist> playlists; // cada usuário pode ter várias playlists

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    // cria uma nova playlist e adiciona à lista
    public void criarPlaylist(String nome) {
        Playlist p = new Playlist(nome, this);
        playlists.add(p);
    }

    public void listarPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist criada.");
        } else {
            for (Playlist p : playlists) {
                System.out.println("- " + p.getNome());
            }
        }
    }

    @Override
    public String toString() {
        return nome + " (" + email + ")";
    }
}
