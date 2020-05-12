package br.unicamp.cotuca;

import java.text.Normalizer;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite uma expressão aritmética:");

            String exp = s.nextLine();

            Expressao.resolva(exp);
//
//            //teste métodos pilha
//            Pilha teste = new Pilha(3);
//            teste.empilhar(10);
//            teste.empilhar(25);
//            teste.empilhar(7);
//            teste.desempilharEretornar();
//            System.out.println(teste);
//
//            //teste métodos fila
//            Fila fila = new Fila(4);
//            fila.adicionar(5);
//            fila.adicionar(5);
//            fila.adicionar(19);
//            fila.adicionar(25);
//            fila.adicionar(4);
//            fila.removerEretornar();
//            fila.removerEretornar();
//            System.out.println(fila);

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
