package com.dobackaofront;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        //Adicionando Itens
        biblioteca.adicionarLivro(new Livro("Imitacao de Cristo","Tomas Kempis"));
        biblioteca.adicionarLivro(new Livro("Poder da Acao","Paulo Vieira"));
        biblioteca.adicionarUsuario(new Usuario("Alcides"));
        biblioteca.adicionarUsuario(new Usuario("Wilismar"));

        // Iteração com o usuário
        while(true){
            System.out.println("******Sistema de Biblioteca DoBackAoFront******");
            System.out.println("1 - Alugar Livro!");
            System.out.println("2 - Devolver Livro!");
            System.out.println("3 - Sair!");
            System.out.println("Escolha uma das opções: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao == 1){
                System.out.print("Digite o nome do usuário: ");
                String nomeUsuario = scanner.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if(usuario != null) {
                    System.out.print("Digite o nome do livro: ");
                    String tituloLivro = scanner.nextLine();
                    Livro livro = biblioteca.buscarLivro(tituloLivro);

                    if (livro != null) {
                        usuario.alugarLivro(livro);
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                }
            }else if(opcao == 2){
                System.out.print("Digite o nome do usuário: ");
                String nomeUsuario = scanner.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if(usuario != null){
                    usuario.devolverLivro();
                }else {
                    System.out.println("Usuário não encontrado!");
                }
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            }else {
                System.out.println("Opção inválida.");
                }
            }
            scanner.close();
        }
}