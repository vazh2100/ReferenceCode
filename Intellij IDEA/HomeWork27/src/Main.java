public class Main {
 static final long i = (long) (Math.random()*1000000000);
 static boolean ifCatch = true;

 public static void main(String[] args) {
        System.out.println(i);

        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
               try {
                   while (ifCatch) {
                       System.out.println(i);
                       i++;
                       Thread.sleep(1000);
                   }
               } catch (Exception e) {}



            }
        });

        timer.start();


        Thread numCatcher = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                while (a!=i) {
                    a = (int) (Math.random()*1000000000);
                }  if (a==i) { System.out.println( "Число угадано. Число: " + a ); ifCatch = false; }}
        });
        numCatcher.start();

    }
}
