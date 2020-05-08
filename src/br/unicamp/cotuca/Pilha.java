package br.unicamp.cotuca;

import java.util.Arrays;

public class Pilha {
    private Object[] pilha;
    private int posicao;

    public Pilha (){
        this.posicao = -1;
        this.pilha = new Object[30];
    }

    public boolean estaVazia() {
        return this.posicao == -1;
    }

    public int tamanho() {
        if(estaVazia())
            return 0;

        return this.posicao+1;
    }

    public void empilhar(int valor) {
        for(int i = posicao; i <= tamanho(); i++){
            this.pilha[++i] = valor;
        }
    }

    public Object desempilhar() {
        if(estaVazia())
            return null;
        return this.pilha[posicao--];
    }

    @Override
    public String toString() {
        return "Pilha{" +
            "pilha=" + Arrays.toString(pilha) +
            ", posicao=" + posicao +
            '}';
    }
}
