package br.marco.threadsListas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Abaixo temos a maneira incorreta de fazer ao utilizar o método synchronized
//        List<String> lista = new ArrayList<>();

        List<String> lista = Collections.synchronizedList(new ArrayList<String>());

        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }
        Thread.sleep(2000);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }
    }
}
