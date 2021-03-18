import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


        Thread thread1 = new Thread(() -> {

        });

        StockAccount stockAccount = new StockAccount();
        stockAccount.run();

        int myMoney = 0;
        Scanner scan = new Scanner(System.in);
        String command = "";
        System.out.println("start");

        while (!command.equals("stop")) {
            command = scan.nextLine();
            switch (command) {
                case "check" -> System.out.println("Курс: " + stockAccount.money);
                case "fix" -> {
                    myMoney += stockAccount.money - 1000;
                    System.out.println("На моем счету: " + myMoney);
                    stockAccount.money = 1000;
                }
            }
        }


    }
}
