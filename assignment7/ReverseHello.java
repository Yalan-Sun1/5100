package assignment7;

public class ReverseHello extends Thread{
    static final int MAX_THREADS=50;
    static final int FIRST_THREAD=1;
    private int counter;

    public ReverseHello(int pCounter){
        this.counter=pCounter;
    }

    public static void main(String[] args) throws InterruptedException {

        ReverseHello firstThread = new ReverseHello(FIRST_THREAD);
        firstThread.start();

    }
    @Override
    public void run() {

        try{
            if(counter <= MAX_THREADS){

                startNewThread(counter++);

            }
        }catch(Exception e){
            System.out.println(e.toString());
        }

    }
    private void startNewThread(int pCounter) throws InterruptedException{
        ReverseHello reverseHelloThread = new ReverseHello(counter);
        reverseHelloThread.start();
        reverseHelloThread.join();
        System.out.println("Hello from " + getName());
    }

}