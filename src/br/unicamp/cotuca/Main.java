package br.unicamp.cotuca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite uma expressão aritmética:");

            String exp = s.nextLine();

            double resultado = Expressao.resolva(exp);
            System.out.println(resultado);


            Pilha teste = new Pilha();
            teste.empilhar(5);
            System.out.println(teste);
            teste.desempilharEretornar();
            System.out.println(teste);

        } catch (Exception e){
            e.getMessage();
        }


    }
}
