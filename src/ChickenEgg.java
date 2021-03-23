import java.util.Random;

public class ChickenEgg extends Thread {

    final Random random = new Random();
    int time;

    ChickenEgg(String name, int time) {
        super(name);
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(getTimeSlip(time));
                System.out.println(getName());
            } catch (InterruptedException err) {
                System.err.println(err.getMessage());
            }
        }
    }

    int getTimeSlip(int time) {
        return random.nextInt(time);
    }


    public static void main(String[] args) {

        ChickenEgg chicken = new ChickenEgg(" урица", 100);
        ChickenEgg egg = new ChickenEgg("яйцо", 100);
        System.out.println("—пор...");
        egg.start();
        chicken.start();


        while (chicken.isAlive() && egg.isAlive()) {
            try {
                Thread.sleep(500);

            } catch (InterruptedException err) {
                System.err.println(err.getMessage());
            }
        }

        if (egg.isAlive()) {
            System.out.println("ѕервым по€вилась €йцо...");
            try {
                egg.interrupted();
                egg.join();
            } catch (InterruptedException err) {
                System.err.println(err.getMessage());
            }

        } else {
            System.out.println("ѕервым по€вилась курица...");
            try {
                chicken.interrupted();
                chicken.join();
            } catch (InterruptedException err) {
                System.err.println(err.getMessage());
            }

        }
        System.out.println("—пор закончен");
    }


}
