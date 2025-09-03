package com.minispotify.model;

public class Musica extends Midia {

    public Musica(String titulo, String artista, double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
    }

    // Aqui podemos sobrescrever métodos se quisermos comportamento específico
    @Override
    public String toString() {
        return "Música: " + super.toString();
    }
}
