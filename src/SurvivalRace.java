import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SurvivalRace {


    static final int SIZE = 100_000_000;

    public static void main(String[] args) {
        long time_start = System.currentTimeMillis();

        List<Integer> maxList = new ArrayList<>(SIZE);
        List<Integer> sortList = new ArrayList<>(SIZE);
        List<Integer> lastRemoveList = new ArrayList<>(SIZE);


        for (int i = 0; i < SIZE; i++) {
            maxList.add(i);
        }

        int max = Collections.max(maxList);
        System.out.println("max ready: " + max);


        for (int i = SIZE; i > 0; i--) {
            sortList.add(i);
        }
        Collections.sort(sortList);
        System.out.println("sort ready...");

        for (int i = 0; i < SIZE; i++) {
            lastRemoveList.add(i);
        }

        while (lastRemoveList.size() != 0) {
            lastRemoveList.remove(lastRemoveList.size() - 1);
        }
        System.out.println("clear ready...");


        long time_stop = System.currentTimeMillis();
        System.out.println("time: " + (time_stop - time_start));
    }


}
