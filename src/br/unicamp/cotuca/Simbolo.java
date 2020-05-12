package br.unicamp.cotuca;

public class Simbolo {

    public static boolean alocaOperadores(String pedaço, String topo) {
        switch (pedaço) {
            case "*":
                switch (topo) {
                    case "(":
                        return false;
                }
        }
        return true;
    }
}
