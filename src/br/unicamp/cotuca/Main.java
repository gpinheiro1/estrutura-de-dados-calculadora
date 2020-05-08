package br.unicamp.cotuca;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite uma expressão aritmética:");

            String exp = s.nextLine();

            double resultado = Expressao.resolva(exp);
            System.out.println(resultado);
        } catch (Exception e){
            e.getMessage();
        }

        Pilha teste = new Pilha();
        teste.empilhar(5);
        System.out.println(teste);
        teste.desempilhar();
        System.out.println(teste);

    }
}
