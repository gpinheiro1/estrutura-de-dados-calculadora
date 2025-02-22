/********************************
 * NOME: GIOVANA PINHEIRO CUNHA *
 * RA: 19358                    *
 ********************************/
package br.unicamp.cotuca;

import java.util.Arrays;

public class Pilha<T> {
    private Object[] pilha;
    private int topo;

    public Pilha (int tamanho){
        this.topo = -1;
        this.pilha = new Object[tamanho];
    }
    public Pilha() {
        this(20);
    }

    public boolean estaVazia() {
        return this.topo <= -1;
    }

    public int tamanho() {
        return this.topo +1;
    }

    public void empilhar(T elemento) throws Exception {
        if (elemento == null)
            throw new Exception("Elemento inválido");
        topo++;
        this.pilha[topo] = elemento;
    }

    public T desempilharEretornar() throws Exception {
        if(estaVazia())
            throw new Exception("A pilha está vazia, não é possível remover");
        T elemento = (T) this.pilha[topo];
        this.pilha[topo] = null;
        topo--;
        return elemento;
    }

    public void desempilhar() throws Exception {
        if(estaVazia())
            throw new Exception("A pilha está vazia, não é possível remover");
        this.pilha[topo] = null;
        topo--;
    }

    public T exibeTopo() {
        T elemento = (T) this.pilha[topo];
        return elemento;
    }

    @Override
    public String toString() {
        return "Pilha {" +
            "pilha=" + Arrays.toString(pilha) +
            ", última posicao preenchida: " + topo +
            '}';
    }
}
