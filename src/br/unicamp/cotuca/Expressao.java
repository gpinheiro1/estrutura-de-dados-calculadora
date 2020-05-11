package br.unicamp.cotuca;

import validations.ValidationUtils;
import java.util.StringTokenizer;

public class Expressao {
    
    Fila filaDeSaida;
    Pilha pilhaDeOperadores;
    
    private Expressao() {
        filaDeSaida = new Fila(20);
        pilhaDeOperadores = new Pilha(20);
    }
    
    double resolver(String strExp) throws Exception {

        String expressao = eliminaEspacosEmBranco(strExp);
        ValidationUtils.validaExpressao(expressao);
        StringTokenizer separador = new StringTokenizer(expressao, "()^/*-+", true);
        while(separador.hasMoreTokens()) {
            String pedaço = separador.nextToken();
            if (pedaço.matches("[0-9]+"))
                filaDeSaida.adicionar(pedaço);
             else if (pedaço.matches("[(]+"))
                pilhaDeOperadores.empilhar(pedaço);

             //falta verificar os operadores -->  ^/*+-
        }
        return 0;
    }

    private String eliminaEspacosEmBranco(String expressao) {
        expressao = expressao.replaceAll("\\s+", "");
        System.out.println(expressao);
        return expressao;
    }

    static double resolva(String strExp) throws Exception{
        Expressao expressao = new Expressao();
        return expressao.resolver(strExp);
    }
}
