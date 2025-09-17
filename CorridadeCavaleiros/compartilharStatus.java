package simulacao;

import java.util.*;
import java.util.concurrent.locks.*;

class SharedState {
    private boolean tochaPegue = false;
    private boolean pedraPegue = false;
    private final Lock lock = new ReentrantLock();

    private List<Integer> portasDisponiveis = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    private int portaSegura = -1;

    public boolean tentarPegarTocha(Cavaleiro c) {
        lock.lock();
        try {
            if (!tochaPegue) {
                tochaPegue = true;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean tentarPegarPedra(Cavaleiro c) {
        lock.lock();
        try {
            if (!pedraPegue) {
                pedraPegue = true;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void sortearPortaSegura() {
        portaSegura = new Random().nextInt(4) + 1;
        System.out.println(">> Porta segura é a: " + portaSegura + "\n");
    }

    public int getPortaSegura() {
        return portaSegura;
    }

    public synchronized int sortearPorta() {
        Random rand = new Random();
        int index = rand.nextInt(portasDisponiveis.size());
        return portasDisponiveis.remove(index);
    }
}

