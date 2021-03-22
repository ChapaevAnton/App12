import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConsoleClock extends Thread {

    @Override
    public void run() {
        //QUESTION: 22.03.2021 https://metanit.com/java/tutorial/8.4.php почитать статью про прерывание потоков...
        while (true) {
            try {
                System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("The clock was stopped");
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ConsoleClock();
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        thread.join();
        System.out.println("finish");

    }
}
