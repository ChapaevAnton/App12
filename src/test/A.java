package test;

import java.io.*;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {

        int result = 0;

        try (FileReader fileReader = new FileReader("c:\\TEMP\\input.txt");
             FileWriter fileWriter = new FileWriter("c:\\TEMP\\output.txt", false)) {

            Scanner in = new Scanner(new BufferedReader(fileReader));

            String[] array = in.nextLine().split(" ");

            for (int i = 0; i < array.length; i++) {
                result += Integer.parseInt(array[i]);
            }

            fileWriter.write(Integer.toString(result));

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
