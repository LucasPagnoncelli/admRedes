public class Main {
    public static void main(String[] args) {
        Buffer myBuffer = new Buffer(5);
        Producer producer = new Producer(myBuffer);
        producer.start();
    }
    
}
