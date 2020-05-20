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
          calculadoraDaExpressao();

        return 2.0; //posso retornar o ultimo elemento da fila (em double)
    }

    private double calculadoraDaExpressao() throws Exception {

        String elementoDaFila = filaDeSaida.removerEretornar();
        while (!elementoDaFila.matches("[\\^\\/*+\\-]")) {
            if (elementoDaFila.matches("[0-9]+")) {
                pilhaResultado.empilhar(elementoDaFila);
                elementoDaFila = filaDeSaida.removerEretornar();
            }
        }
        operador = elementoDaFila;
        String elemento = pilhaResultado.desempilharEretornar();
        if (elemento.matches("[0-9]+")) {
            valor2 = Double.parseDouble(elemento);
            elemento = pilhaResultado.desempilharEretornar();
            valor1 = Double.parseDouble(elemento);
        }
            if(operador.matches("[\\^\\/*+\\-]")) {
                double resultado = Operador.calcular(operador, valor1, valor2);
                pilhaResultado.empilhar(String.valueOf(resultado));
        }
            //repetir o processo casa ainda haja elementos na fila de saída;
        return 2.0;
    }

    private String eliminaEspacosEmBranco(String expressao) {
        expressao = expressao.replaceAll("\\s+", "");
        System.out.println(expressao);
        return expressao;
    }

    static double resolva(String strExp) throws Exception {
        Expressao expressao = new Expressao();
        return expressao.resolver(strExp);
    }
}
