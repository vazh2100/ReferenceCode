public class RunnableTimer implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i <1000001 ; i++) {
            System.out.println(1);
        }
    }
}
