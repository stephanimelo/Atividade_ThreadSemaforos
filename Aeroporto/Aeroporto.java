package simulacao;

public class SimulacaoCavaleiros {
    public static void main(String[] args) throws InterruptedException {
        int distanciaTotal = 2000;
        Cavaleiro[] cavaleiros = new Cavaleiro[4];
        Thread[] threads = new Thread[4];

        SharedState shared = new SharedState();

        for (int i = 0; i < 4; i++) {
            cavaleiros[i] = new Cavaleiro("Cavaleiro " + (i + 1), shared);
            threads[i] = new Thread(cavaleiros[i]);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\nTodos os cavaleiros chegaram ao final. Escolhendo portas...\n");

        shared.sortearPortaSegura();

        for (Cavaleiro c : cavaleiros) {
            c.escolherPorta();
        }
    }
}
