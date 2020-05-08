package br.unicamp.cotuca;

import validations.ValidationUtils;

import java.util.StringTokenizer;

public class Expressao {
    private String expressao;
    private char operador;
    

    //criar uma pilha (colocação dos operadores)
    //criar uma fila (colocação dos números)

    public String toString() {
        String ret = "";

        ret += "Expressão aritmética: " + this.expressao + "\n";

        return ret;
    }

    public static double resolva(String strExp) throws Exception{

        ValidationUtils.validaExpressao(strExp);
        StringTokenizer separador = new StringTokenizer(strExp, "()^/*-+", true);

        while(separador.hasMoreTokens()) {
            String pedaço = separador.nextToken();
            //é exatamente aqui onde cada pedacinho é direcionado para a fila(numeros) ou pilha(operadores)
            System.out.println(pedaço);
        }
        return 0;
    }


}
