/********************************
 * NOME: GIOVANA PINHEIRO CUNHA *
 * RA: 19358                    *
 ********************************/
package br.unicamp.cotuca;

public class Operador {

    public static boolean alocar(String pedaço, String topo) {
        switch (pedaço) {
            case "*":
                switch (topo) {
                    case "(": return false;
                    case "^": return true;
                    case "*": return true;
                    case "/": return true;
                    case "+": return false;
                    case "-": return false;
                    case ")": return false;
                }
            case "^":
                switch (topo){
                    case "(": return false;
                    case "^": return true;
                    case "*": return false;
                    case "/": return false;
                    case "+": return false;
                    case "-": return false;
                    case ")": return false;
                }
            case "(":
                switch (topo) {
                    case "(": return false;
                    case "^": return false;
                    case "*": return false;
                    case "/": return false;
                    case "+": return false;
                    case "-": return false;
                    case ")": return false;
                }
            case "/":
                switch (topo) {
                    case "(": return false;
                    case "^": return true;
                    case "*": return true;
                    case "/": return true;
                    case "+": return false;
                    case "-": return false;
                    case ")": return false;
                }
            case "+":
                switch (topo) {
                    case "(": return false;
                    case "^": return true;
                    case "*": return true;
                    case "/": return true;
                    case "+": return true;
                    case "-": return true;
                    case ")": return false;
                }
            case "-":
                switch (topo) {
                    case "(": return false;
                    case "^": return true;
                    case "*": return true;
                    case "/": return true;
                    case "+": return true;
                    case "-": return true;
                    case ")": return false;
                }
            case ")":
                switch (topo) {
                    case "(": return true;
                    case "^": return true;
                    case "*": return true;
                    case "/": return true;
                    case "+": return true;
                    case "-": return true;
                    case ")": return false;
                }
        }
        return true;
    }

    public static double calcular(String operador, double valor1, double valor2) throws Exception {
        switch (operador) {
            case "*": return valor1 * valor2;
            case "/": return valor1 / valor2;
            case "+": return valor1 + valor2;
            case "-": return valor1 - valor2;
            case "^": return Math.pow(valor1, valor2);
            default: throw new Exception("");
        }
    }

}
