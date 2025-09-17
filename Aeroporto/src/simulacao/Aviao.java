package simulacao;

import java.util.Random;

public class Aviao implements Runnable {
    private final String nome;
    private final Aeroporto aeroporto;
    private final String pista;
    
    public Aviao(String nome, Aeroporto aeroporto) {
        this.nome = nome;
        this.aeroporto = aeroporto;
        this.pista = (new Random().nextBoolean()) ? "Norte" : "Sul"; // Decide aleatoriamente a pista
    }

    @Override
    public void run() {
        try {
            System.out.println(nome + " está aguardando na pista " + pista + " para decolar.");

            // Aguardar a área de decolagem
            aeroporto.aguardarAreaDeColagem();

            // Fase 1: Taxiar
            int tempoTaxiar = new Random().nextInt(501) + 500; // De 500 a 1000 ms
            System.out.println(nome + " começando a taxiar na pista " + pista + " por " + tempoTaxiar + " ms.");
            Thread.sleep(tempoTaxiar);

            // Fase 2: Decolagem
            int tempoDecolagem = new Random().nextInt(201) + 600; // De 600 a 800 ms
            System.out.println(nome + " decolando na pista " + pista + " por " + tempoDecolagem + " ms.");
            Thread.sleep(tempoDecolagem);

            // Fase 3: Afastamento da área
            int tempoAfastamento = new Random().nextInt(501) + 300; // De 300 a 800 ms
            System.out.println(nome + " afastando-se da área na pista " + pista + " por " + tempoAfastamento + " ms.");
            Thread.sleep(tempoAfastamento);

            // Fase 4: Manobra
            int tempoManobra = new Random().nextInt(401) + 300; // De 300 a 700 ms
            System.out.println(nome + " realizando manobra na pista " + pista + " por " + tempoManobra + " ms.");
            Thread.sleep(tempoManobra);

            System.out.println(nome + " completou a decolagem na pista " + pista);

            // Libera a área de decolagem e pista após o uso
            aeroporto.liberarAreaDeColagem();
            if (pista.equals("Norte")) {
                aeroporto.liberarPistaNorte();
            } else {
                aeroporto.liberarPistaSul();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
