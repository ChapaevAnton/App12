import javax.swing.plaf.TableHeaderUI;

public class CheckResults {

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        });

        thread.start();
        thread.join();
        System.out.println(count);


//        while (count < 1000000000) {
//            System.out.println("Not reached yet");
//            Thread.sleep(100);
//        }
//        System.out.println("Reached");
    }
}
