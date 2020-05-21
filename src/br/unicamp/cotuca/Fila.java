/********************************
 * NOME: GIOVANA PINHEIRO CUNHA *
 * RA: 19358                    *
 ********************************/
package br.unicamp.cotuca;

import java.util.Arrays;

public class Fila<T> {
    private int inicio;
    private int fim;
    private int qtdElementos;
    private Object[] fila;

    public Fila(int tamanho) {
        inicio = fim = -1;
        this.fila = new Object[tamanho];
        this.qtdElementos = 0;
    }

    public Fila() {
        this(20);
    }

    public boolean estaVazia() {
        return qtdElementos == 0;
    }

    public boolean estaCheia() {
        return qtdElementos == fila.length -1;
    }

    public void adicionar (T elemento) throws Exception {
        if (elemento == null)
            throw new Exception("Elemento inválido");
        if(!estaCheia()){
            if (inicio == -1)
                inicio = 0;
        }
        fim++;
        fila[fim] = elemento; //sempre inserimos o elemento no final da fila
        qtdElementos++;
    }

    public T removerEretornar() throws Exception{
        if (estaVazia())
            throw new Exception("A fila está vazia");
        T elemento = (T) this.fila[inicio];
        fila[inicio] = null; //só podemos retirar o elemento do inicio
        inicio++;
        qtdElementos--;
        return elemento;
    }

    @Override
    public String toString() {
        return "Fila{" +
            "inicio=" + inicio +
            ", fim=" + fim +
            ", qtdElementos=" + qtdElementos +
            ", fila=" + Arrays.toString(fila) +
            '}';
    }

}
