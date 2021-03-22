public class CheckResults {

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

//        Thread thread = new Thread(() -> {
//
//            while (true) {
//                System.out.println("Working hard");
//                try {
//                    Thread.sleep(1000);
//                    ++count;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    System.out.println("Interrupted!");
//                    break;
//                }
//            }
//
//
//        });

        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Working hard");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException err) {
                System.err.println("interrupted!!!");
                err.printStackTrace();
            }
            System.out.println("All done");
        });


        thread.start();
        Thread.currentThread().sleep(2500);
        thread.interrupt();
        thread.join();
        System.out.println(count);
        System.out.println("finish");


//        while (count < 1000000000) {
//            System.out.println("Not reached yet");
//            Thread.sleep(100);
//        }
//        System.out.println("Reached");
    }
}
