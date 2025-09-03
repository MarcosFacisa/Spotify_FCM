package com.minispotify.model;

public class Audiobook extends Midia {
    private String narrador;

    public Audiobook(String titulo, String artista, double duracao, Genero genero, String narrador) {
        super(titulo, artista, duracao, genero);
        this.narrador = narrador;
    }

    public String getNarrador() {
        return narrador;
    }

    @Override
    public String toString() {
        return super.toString() + " | Narrador: " + narrador;
    }
}
