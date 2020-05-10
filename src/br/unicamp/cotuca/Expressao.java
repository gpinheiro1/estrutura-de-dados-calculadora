package br.unicamp.cotuca;

import validations.ValidationUtils;

import java.util.Queue;
import java.util.StringTokenizer;

public class Expressao {
    private String expressao;
    private char operador;


    public String toString() {
        String ret = "";

        ret += "Expressão aritmética: " + this.expressao + "\n";

        return ret;
    }

    public static String eliminaEspacosEmBranco(String expressao) {
        expressao = expressao.replaceAll("\\s+", "");
        System.out.println(expressao);
        return expressao;
    }

    public static double resolva(String strExp) throws Exception{

        String expressao = eliminaEspacosEmBranco(strExp);
        ValidationUtils.validaExpressao(expressao);
        StringTokenizer separador = new StringTokenizer(expressao, "()^/*-+", true);

        while(separador.hasMoreTokens()) {
            String pedaço = separador.nextToken();
            //é exatamente aqui onde cada pedacinho é direcionado para a fila(numeros) ou pilha(operadores)

            System.out.println(pedaço);
        }
        return 0;
    }


}
