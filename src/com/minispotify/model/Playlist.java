package com.minispotify.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import com.minispotify.excepition.MidiaDuplicadaException;
import com.minispotify.excepition.MidiaNaoEncontradaExcepition;

public class Playlist {
    private String nome;
    private Usuario dono;
    private Set<Midia> midias;

    public Playlist(String nome, Usuario dono) {
        this.nome = nome;
        this.dono = dono;
        this.midias = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public Usuario getDono() {
        return dono;
    }

    public void adicionarMidia(Midia midia) throws MidiaDuplicadaException {
        if (!midias.add(midia)) {
            throw new MidiaDuplicadaException("Mídia já existe na playlist!");
        }
    }

    public void removerMidia(Midia midia) throws MidiaNaoEncontradaExcepition {
        if (!midias.remove(midia)) {
            throw new MidiaNaoEncontradaExcepition("Mídia não encontrada na playlist!");
        }
    }

    public double calcularDuracaoTotal() {
        return midias.stream().mapToDouble(Midia::getDuracao).sum();
    }

    public void listarMidias() {
        if (midias.isEmpty()) {
            System.out.println("Playlist vazia.");
        } else {
            for (Midia m : midias) {
                System.out.println("- " + m);
            }
        }
    }

    public void listarFavoritas() {
        boolean encontrou = false;
        for (Midia m : midias) {
            if (m.isFavorita()) {
                System.out.println("- " + m);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma mídia favorita na playlist.");
        }
    }

    public Set<Midia> getMidias() {
        return midias;
    }
}
