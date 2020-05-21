package br.unicamp.cotuca;

import java.text.Normalizer;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // 10   + (  2      * 3  -     4 ) ^  2  / 4 +   6   * 2
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite uma expressão aritmética:");
            String exp = s.nextLine();
            System.out.println(Expressao.resolva(exp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
