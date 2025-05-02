public class Count extends Thread {
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new Count();
        Thread t2 = new Count();

        // Correct usage: Start threads using start() method
        t1.start(); 
//        t1.start(); 
//        t1.start(); // This will cause an IllegalThreadStateException

        t2.start(); 
//        t2.start(); 
//        t2.start(); // This will cause an IllegalThreadStateException
    }
}
