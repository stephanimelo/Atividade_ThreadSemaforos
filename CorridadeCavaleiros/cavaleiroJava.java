package simulacao;

public class AeroportoControlador {
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


class Cavaleiro implements Runnable {
    private String nome;
    private int velocidade;
    private int posicao;
    private SharedState shared;
    private boolean temTocha = false;
    private boolean temPedra = false;
    private int portaEscolhida = -1;

    public Cavaleiro(String nome, SharedState shared) {
        this.nome = nome;
        this.shared = shared;
        this.velocidade = new Random().nextInt(3) + 2;
    }

    public void run() {
        while (posicao < 2000) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            posicao += velocidade;

            if (posicao >= 500 && !temTocha && shared.tentarPegarTocha(this)) {
                temTocha = true;
                velocidade += 2;
                System.out.println(nome + " pegou a TOCHA! Nova velocidade: " + velocidade);
            }

            if (posicao >= 1500 && !temPedra && !temTocha && shared.tentarPegarPedra(this)) {
                temPedra = true;
                velocidade += 2;
                System.out.println(nome + " pegou a PEDRA! Nova velocidade: " + velocidade);
            }
        }

        System.out.println(nome + " chegou ao final com velocidade " + velocidade);
    }

    public void escolherPorta() {
        portaEscolhida = shared.sortearPorta();
        if (portaEscolhida == shared.getPortaSegura()) {
            System.out.println(nome + " escolheu a porta " + portaEscolhida + " e ESCAPOU!");
        } else {
            System.out.println(nome + " escolheu a porta " + portaEscolhida + " e foi DEVORADO!");
        }
    }
}
    }
}
