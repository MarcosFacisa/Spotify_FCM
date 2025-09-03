package com.minispotify;

import com.minispotify.model.*;

public class Main {
    public static void main(String[] args) {
        // Entrada do usuário
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite o e-mail do usuário: ");
        String emailUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nomeUsuario, emailUsuario);
        usuario.criarPlaylist("Favoritas");
        Playlist playlist = usuario.getPlaylists().get(0);

        // Menu interativo
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\nBem-vindo, " + usuario.getNome() + "!");
            System.out.println("--- MENU MINI-SPOTIFY ---");
            System.out.println("1. Adicionar mídia à playlist");
            System.out.println("2. Remover mídia da playlist");
            System.out.println("3. Listar mídias da playlist");
            System.out.println("4. Listar músicas favoritas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer
            switch (opcao) {
                case 1:
                    System.out.print("Título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Duração: ");
                    double duracao = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Gênero (ROCK, POP, JAZZ, CLASSICA): ");
                    String generoStr = scanner.nextLine();
                    Genero genero;
                    try {
                        genero = Genero.valueOf(generoStr.toUpperCase());
                    } catch (Exception e) {
                        System.out.println("Gênero inválido!");
                        break;
                    }
                    System.out.print("Adicionar como favorita? (s/n): ");
                    String favStr = scanner.nextLine();
                    Musica novaMusica = new Musica(titulo, artista, duracao, genero);
                    if (favStr.equalsIgnoreCase("s")) {
                        novaMusica.marcarFavorita();
                    }
                    try {
                        playlist.adicionarMidia(novaMusica);
                        System.out.println("Mídia adicionada!");
                    } catch (com.minispotify.excepition.MidiaDuplicadaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Título da mídia para remover: ");
                    String tituloRemover = scanner.nextLine();
                    Midia paraRemover = null;
                    for (Midia m : playlist.getMidias()) {
                        if (m.getTitulo().equalsIgnoreCase(tituloRemover)) {
                            paraRemover = m;
                            break;
                        }
                    }
                    if (paraRemover != null) {
                        try {
                            playlist.removerMidia(paraRemover);
                            System.out.println("Mídia removida!");
                        } catch (com.minispotify.excepition.MidiaNaoEncontradaExcepition e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Mídia não encontrada na playlist!");
                    }
                    break;
                case 3:
                    playlist.listarMidias();
                    break;
                case 4:
                    System.out.println("Músicas favoritas da playlist:");
                    playlist.listarFavoritas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}
