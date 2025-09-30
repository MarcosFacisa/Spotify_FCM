package com.minispotify;

import com.minispotify.model.*;

public class Main {
    public static void main(String[] args) {
        // Cria um scanner para ler entradas do usuário pelo terminal
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        // Solicita o nome do usuário
        System.out.print("Digite o nome do usuario: ");
        String nomeUsuario = scanner.nextLine();
        // Solicita o e-mail do usuário
        System.out.print("Digite o e-mail do usuario: ");
        String emailUsuario = scanner.nextLine();
        // Cria o objeto Usuario com os dados informados
        Usuario usuario = new Usuario(nomeUsuario, emailUsuario);
        // Cria uma playlist padrão chamada "Favoritas" para o usuário
        usuario.criarPlaylist("Favoritas");
        Playlist playlist = usuario.getPlaylists().get(0);

        // Inicia o menu interativo
        int opcao = -1;
        while (opcao != 0) {
            // Exibe saudação personalizada e opções do menu
            System.out.println("\nBem-vindo, " + usuario.getNome() + "!");
            System.out.println("--- MENU MINI-SPOTIFY ---");
            System.out.println("1. Adicionar midia a playlist");
            System.out.println("2. Remover midia da playlist");
            System.out.println("3. Listar midias da playlist");
            System.out.println("4. Listar musicas favoritas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer
            switch (opcao) {
                case 1:
                    // Adiciona uma nova música à playlist
                    System.out.print("Titulo da musica: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Duracao: ");
                    double duracao = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Genero (SOFRENCIA, RAPPER, PAGODE, FORRO): ");
                    String generoStr = scanner.nextLine();
                    Genero genero;
                    try {
                        genero = Genero.valueOf(generoStr.toUpperCase());
                    } catch (Exception e) {
                        System.out.println("Genero invalido!");
                        break;
                    }
                    // Pergunta se a música já deve ser marcada como favorita
                    System.out.print("Adicionar como favorita? (s/n): ");
                    String favStr = scanner.nextLine();
                    Musica novaMusica = new Musica(titulo, artista, duracao, genero);
                    if (favStr.equalsIgnoreCase("s")) {
                        novaMusica.marcarFavorita();
                    }
                    try {
                        playlist.adicionarMidia(novaMusica);
                        System.out.println("Midia adicionada!");
                    } catch (com.minispotify.excepition.MidiaDuplicadaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    // Remove uma mídia da playlist pelo título
                    System.out.print("Titulo da midia para remover: ");
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
                            System.out.println("Midia removida!");
                        } catch (com.minispotify.excepition.MidiaNaoEncontradaExcepition e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Midia não encontrada na playlist!");
                    }
                    break;
                case 3:
                    // Lista todas as mídias da playlist
                    playlist.listarMidias();
                    break;
                case 4:
                    // Lista apenas as músicas marcadas como favoritas
                    System.out.println("Musicas favoritas da playlist:");
                    playlist.listarFavoritas();
                    break;
                case 0:
                    // Sai do programa
                    System.out.println("Saindo...");
                    break;
                default:
                    // Opção inválida
                    System.out.println("Opcao invalida!");
            }
        }
        // Fecha o scanner ao final do programa
        scanner.close();
    }
}
