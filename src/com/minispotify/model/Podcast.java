package com.minispotify.model;

public class Podcast extends Midia {
    private int episodios;

    public Podcast(String titulo, String artista, double duracao, Genero genero, int episodios) {
        super(titulo, artista, duracao, genero);
        this.episodios = episodios;
    }

    public int getEpisodios() {
        return episodios;
    }

    @Override
    public String toString() {
        return super.toString() + " | Episodios: " + episodios;
    }
}
