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
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
