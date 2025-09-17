package simulacao;

import java.util.concurrent.Semaphore;

public class Aeroporto {
    // Limitando a 2 aviões na área de decolagem ao mesmo tempo
    private final Semaphore semaforoAreaDeColagem = new Semaphore(2);
    
    // Gerencia o controle de decolagem nas pistas
    private final Semaphore semaforoPistaNorte = new Semaphore(1);
    private final Semaphore semaforoPistaSul = new Semaphore(1);

    /**
     * Método para aguardar a liberação da área de decolagem.
     */
    public void aguardarAreaDeColagem() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " aguardando na área de decolagem.");
        semaforoAreaDeColagem.acquire(); // Avisa que um avião entrou na área de decolagem
    }

    /**
     * Método para liberar a área de decolagem.
     */
    public void liberarAreaDeColagem() {
        System.out.println(Thread.currentThread().getName() + " liberando a área de decolagem.");
        semaforoAreaDeColagem.release(); // Libera a área para outro avião
    }

    /**
     * Método para aguardar a liberação da pista norte.
     */
    public void aguardarPistaNorte() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " aguardando na pista norte.");
        semaforoPistaNorte.acquire(); // Apenas um avião por vez
    }

    /**
     * Método para liberar a pista norte.
     */
    public void liberarPistaNorte() {
        System.out.println(Thread.currentThread().getName() + " liberando a pista norte.");
        semaforoPistaNorte.release();
    }

    /**
     * Método para aguardar a liberação da pista sul.
     */
    public void aguardarPistaSul() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " aguardando na pista sul.");
        semaforoPistaSul.acquire(); // Apenas um avião por vez
    }

    /**
     * Método para liberar a pista sul.
     */
    public void liberarPistaSul() {
        System.out.println(Thread.currentThread().getName() + " liberando a pista sul.");
        semaforoPistaSul.release();
    }
}
