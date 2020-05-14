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
}
