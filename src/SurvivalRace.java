import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SurvivalRace {


    static final int SIZE = 10_000_000;

    public static void main(String[] args) {

        List<Integer> maxList = new ArrayList<>(SIZE);
        List<Integer> sortList = new ArrayList<>(SIZE);
        List<Integer> lastRemoveList = new ArrayList<>(SIZE);

        Runnable run1 = () -> {
            for (int i = 0; i < SIZE; i++) {
                maxList.add(i);
            }

            int max = Collections.max(maxList);
            System.out.println("max ready: " + max);
        };


        Runnable run2 = () -> {
            for (int i = SIZE; i > 0; i--) {
                sortList.add(i);
            }

            Collections.sort(sortList);
            System.out.println("sort ready...");
        };

        Runnable run3 = () -> {
            for (int i = 0; i < SIZE; i++) {
                lastRemoveList.add(i);
            }

            while (lastRemoveList.size() != 0) {
                lastRemoveList.remove(lastRemoveList.size() - 1);
            }
            System.out.println("clear ready...");
        };

        ThreadGroup threadGroup = new ThreadGroup("threadAll");
        Thread[] threads = {new Thread(threadGroup, run1), new Thread(threadGroup, run2), new Thread(threadGroup, run3)};
        //threadGroup.setMaxPriority(Thread.MAX_PRIORITY);

        long time_start = System.currentTimeMillis();

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException err) {
                System.err.println(err.getMessage());
            }
        }


        long time_stop = System.currentTimeMillis();
        System.out.println("time: " + (time_stop - time_start));
    }


}
