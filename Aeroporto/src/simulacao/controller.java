package simulacao;

public class controller {
    public static void main(String[] args) throws InterruptedException {
        Aeroporto aeroporto = new Aeroporto();

        Thread[] avioes = new Thread[12];
        for (int i = 0; i < 12; i++) {
            String nomeAviao = "Avião " + (i + 1);
            avioes[i] = new Thread(new Aviao(nomeAviao, aeroporto));
        }

        for (Thread aviao : avioes) {
            aviao.start();
        }

        for (Thread aviao : avioes) {
            aviao.join();
        }

        System.out.println("Todos os aviões completaram a decolagem.");
    }
}
