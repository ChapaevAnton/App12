package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class A {

    public static void main(String[] args) {


        try (FileReader fileReader = new FileReader("c:\\TEMP\\input.txt");
             FileWriter fileWriter = new FileWriter("c:\\TEMP\\output.txt", false)) {

            Scanner in = new Scanner(new BufferedReader(fileReader));

            ArrayList<String> arrayList = new ArrayList<>();


            while (in.hasNextLine()) {
                String str = in.nextLine();
                arrayList.add(str);

            }

            TreeMap<Integer, String> treeMap = new TreeMap<>();

            for (String str : arrayList) {

                for (int i = 0; i < str.length(); i++) {
                    if (Character.isDigit(str.charAt(i))) {

                        int count = Integer.parseInt(String.valueOf(str.charAt(i)));

                        str = str.replaceAll(Character.toString(str.charAt(i)), "");

                        treeMap.put(count, str);
                    }

                }

            }

            int mapSize = treeMap.size() - 1;

            arrayList = new ArrayList<>(treeMap.values());

            for (int i = 0; i < arrayList.size(); i++) {

                fileWriter.write(arrayList.get(i));
                if (i < mapSize) {
                    fileWriter.append('\n');
                }
            }


            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
