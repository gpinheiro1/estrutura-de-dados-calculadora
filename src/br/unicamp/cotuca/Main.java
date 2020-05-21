/********************************
 * NOME: GIOVANA PINHEIRO CUNHA *
 * RA: 19358                    *
 ********************************/
package br.unicamp.cotuca;

import java.util.Scanner;

//EXPRESSÃO:              10   + (  2      * 3  -     4 ) ^  2  / 4 +   6   * 2
public class Main {

    public static void main(String[] args) {

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
