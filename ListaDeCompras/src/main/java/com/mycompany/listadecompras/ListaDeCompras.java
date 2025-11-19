/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listadecompras;
import java.util.ArrayList;
import java.util.Scanner;
public class ListaDeCompras {

    public static void main(String[] args) {
            Scanner leitor = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        int executar = 1;
        
        System.out.println("Lista de Compras");
        
        while (executar == 1) {
            exibirMenu();
            
            if (leitor.hasNextInt()) {
                int opcao = leitor.nextInt();
                leitor.nextLine();
                
                switch(opcao) {
                    case 1:
                        adicionarItem(lista, leitor);
                        break;
                    case 2:
                        removerItem(lista, leitor);
                        break;
                    case 3:
                        alterarItem(lista, leitor);
                        break;
                    case 4:
                        limparLista(lista);
                        break;
                    case 5:
                        visualizarLista(lista);
                        break;
                    case 6:
                        System.out.println("Obrigado por usar o meu programa!");
                        executar = 0;
                        break;
                    default:
                        System.out.println("Opção inválida! Digite de 1 a 6.");
                }
            } else {
                System.out.println("Por favor, digite apenas números!");
                leitor.nextLine();
            }
        }
        leitor.close();
    }
    
    // Menuzinho de opções
    public static void exibirMenu() {
        System.out.println("\n Menu");
        System.out.println("1 - Adicionar um item");
        System.out.println("2 - Remover um item");
        System.out.println("3 - Alterar um item");
        System.out.println("4 - Limpar a lista");
        System.out.println("5 - Visualizar a lista");
        System.out.println("6 - Sair");
        System.out.print("Digite a opção que deseja executar: ");
    }
    
    // Adicionar um novo item
    public static void adicionarItem(ArrayList<String> lista, Scanner leitor) {
        System.out.print("Digite o item para adicionar: ");
        String item = leitor.nextLine();
        
        if (!item.isEmpty()) {
            lista.add(item);
            System.out.println("Item '" + item + "' adicionado com sucesso!");
        } else {
            System.out.println("Item vazio! Nada foi adicionado.");
        }
    }
    
    // Remover o item da lista por nome
    public static void removerItem(ArrayList<String> lista, Scanner leitor) {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia! Nada para remover.");
            return;
        }
        
        visualizarLista(lista);
        System.out.print("Digite o nome do item para remover: ");
        String itemRemover = leitor.nextLine();
        
        if (lista.remove(itemRemover)) {
            System.out.println("Item '" + itemRemover + "' removido com sucesso!");
        } else {
            System.out.println("Item nao encontrado na lista!");
        }
    }
    
    // Alterar um item existente na lista
    public static void alterarItem(ArrayList<String> lista, Scanner leitor) {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia! Não há nada para alterar.");
            return;
        }
        
        visualizarLista(lista);
        System.out.print("Digite o nome do item que deseja alterar: ");
        String itemAntigo = leitor.nextLine();
        
        if (lista.contains(itemAntigo)) {
            int indice = lista.indexOf(itemAntigo);
            System.out.print("Digite o novo nome para o item: ");
            String itemNovo = leitor.nextLine();
            
            if (!itemNovo.isEmpty()) {
                lista.set(indice, itemNovo);
                System.out.println("Item alterado de '" + itemAntigo + "' para '" + itemNovo + "'");
            } else {
                System.out.println("Nome vazio! Alteração cancelada.");
            }
        } else {
            System.out.println("Item '" + itemAntigo + "' nao encontrado!");
        }
    }
    
    // Limpar toda a lista
    public static void limparLista(ArrayList<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("A lista já esta vazia!");
        } else {
            System.out.print("Tem certeza que deseja limpar toda a lista? (s/n): ");
            Scanner tempScanner = new Scanner(System.in);
            String confirmacao = tempScanner.nextLine();
            
            if (confirmacao.equalsIgnoreCase("s")) {
                lista.clear();
                System.out.println("Lista limpa com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }
        }
    }
    
    // Exibir todos os itens da lista
    public static void visualizarLista(ArrayList<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia! Adicione alguns itens.");
        } else {
            System.out.println("\n Sua Lista de Compras");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + ". " + lista.get(i));
            }
            System.out.println("Total de itens: " + lista.size());
        }
    }
}