package com.minispotify.repository;

import com.minispotify.model.*;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Midia> midias;

    public Catalogo() {
        this.midias = new ArrayList<>();
    }

    public void adicionarMidia(Midia midia) {
        midias.add(midia);
    }

    public List<Midia> buscarPorTitulo(String titulo) {
        List<Midia> resultado = new ArrayList<>();
        for (Midia m : midias) {
            if (m.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public List<Midia> buscarPorArtista(String artista) {
        List<Midia> resultado = new ArrayList<>();
        for (Midia m : midias) {
            if (m.getArtista().toLowerCase().contains(artista.toLowerCase())) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public List<Midia> buscarPorGenero(Genero genero) {
        List<Midia> resultado = new ArrayList<>();
        for (Midia m : midias) {
            if (m.getGenero() == genero) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public void exibirCatalogo() {
        System.out.println("🎧 Catálogo de Mídias:");
        for (Midia m : midias) {
            System.out.println(" - " + m);
        }
        System.out.println();
    }
}
