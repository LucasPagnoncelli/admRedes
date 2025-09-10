
import java.nio.BufferUnderflowException;

public class Consumer extends Thread {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (buffer) {
                    if (!this.buffer.isEmpty()) {
                        Integer valor = this.buffer.extract();
                        System.out.println("Consumidor consumiu o valor: " + valor);
                        buffer.notifyAll();
                    } else {
                        System.out.println("Consumidor esperando...");
                        buffer.wait();
                    }
                }
            } catch (BufferUnderflowException e) {
                System.out.println("Buffer vazio!");
            } catch (InterruptedException e) {
                System.out.println("Erro na thread consumidora!");
            }
        }
    }
}
