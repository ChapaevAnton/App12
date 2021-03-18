public class StockAccount extends Thread {

    int money = 1000;

    @Override
    public void run() {
        System.err.println("start thread");
        while (true) {
            money++;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
