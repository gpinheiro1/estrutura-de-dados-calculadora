package br.unicamp.cotuca;

import validations.ValidationUtils;

import java.util.StringTokenizer;

public class Expressao {

    Fila<String> filaDeSaida;
    Pilha<String> pilhaDeOperadores;
    Pilha<String> pilhaResultado;
    private double valor1;
    private double valor2;
    private String operador;

    private Expressao() {
        filaDeSaida = new Fila(20);
        pilhaDeOperadores = new Pilha(20);
        pilhaResultado = new Pilha(20);
    }

    double resolver(String strExp) throws Exception {

        String expressao = eliminaEspacosEmBranco(strExp);
        ValidationUtils.validaExpressao(expressao);
        StringTokenizer separador = new StringTokenizer(expressao, "()^/*-+", true);
        while (separador.hasMoreTokens()) {
            String pedaço = separador.nextToken();
            if (pedaço.matches("[0-9]+")) {
                filaDeSaida.adicionar(pedaço);
            } else if (pedaço.matches("[(]+")) {
                pilhaDeOperadores.empilhar(pedaço);
            } else if (pedaço.matches("[\\^\\/*+\\-]")) {
                if (pilhaDeOperadores.estaVazia()) {
                    pilhaDeOperadores.empilhar(pedaço);
                } else {
                    String topo = pilhaDeOperadores.exibeTopo();
                    while (Operador.alocar(pedaço, topo)) {
                        filaDeSaida.adicionar(topo);
                        pilhaDeOperadores.desempilhar();
                        if (pilhaDeOperadores.estaVazia()) break;
                        topo = pilhaDeOperadores.exibeTopo();
                    }
                    pilhaDeOperadores.empilhar(pedaço);
                }
            } else if (pedaço.matches("[)]+")) {
                String elemento = pilhaDeOperadores.desempilharEretornar();
                while (!elemento.equals("(")) {
                    filaDeSaida.adicionar(elemento);
                    elemento = pilhaDeOperadores.desempilharEretornar();
                }
            }
        }
        while (!pilhaDeOperadores.estaVazia()) {
            String topo = pilhaDeOperadores.desempilharEretornar();
            filaDeSaida.adicionar(topo);
        }

        return calculadoraDaExpressao();
    }

    private double calculadoraDaExpressao() throws Exception {

        while (!filaDeSaida.estaVazia()) {
            String elementoDaFila = filaDeSaida.removerEretornar();
            while (!elementoDaFila.matches("[\\^\\/*+\\-]")) {
                if (elementoDaFila.matches("[0-9]+")) {
                    pilhaResultado.empilhar(elementoDaFila);
                    elementoDaFila = filaDeSaida.removerEretornar();
                }
            }
            operador = elementoDaFila;
            String elemento = pilhaResultado.desempilharEretornar();
            valor2 = Double.parseDouble(elemento);
            elemento = pilhaResultado.desempilharEretornar();
            valor1 = Double.parseDouble(elemento);
            double resultado = Operador.calcular(operador, valor1, valor2);
            pilhaResultado.empilhar(String.valueOf(resultado));
        }
        if (pilhaResultado.tamanho() > 1)
            throw new Exception("Expressão inválida");
        return Double.parseDouble(pilhaResultado.desempilharEretornar());
    }

    private String eliminaEspacosEmBranco(String expressao) {
        expressao = expressao.replaceAll("\\s+", "");
        return expressao;
    }

    static double resolva(String strExp) throws Exception {
        Expressao expressao = new Expressao();
        return expressao.resolver(strExp);
    }
}
