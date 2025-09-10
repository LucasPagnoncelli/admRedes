
public class Producer extends Thread {

    private int valores[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private Buffer buffer = null;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int index = 0; index < 15; index++) {
            try {
                System.out.println("Produtor produzindo " + valores[index]);
                synchronized (buffer) {

                    if (!this.buffer.isFull()) {
                        this.buffer.add(Integer.valueOf(this.valores[index]));
                        buffer.notifyAll();
                    } else {
                        System.out.println("Produtor esperando...");
                        buffer.wait();
                    }
                }
            } catch (BufferOverflow e) {
                System.out.println("Buffer cheio!");
            } catch (InterruptedException e) {
                System.out.println("Erro na Thread");
            }
        }
    }
}
