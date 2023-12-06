package Day_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DayOnePartTwo {

    public static void main(String[] args) {
        String path = "C:\\Users\\SinanYagsagan\\Desktop\\AdventOfCode\\adventofcode\\src\\Day_1\\puzzle.txt";
        Path pathWay = Paths.get(path);

        int totalSum = 0;
        try {
            List<String> lines =  Files.readAllLines(pathWay);
            for (String line: lines){
                totalSum += calibrationValue(replaceAllTextWithNumber(line));
            }
            System.out.println("Total Calibration value is : "+ totalSum);

        } catch(IOException exception){
            exception.printStackTrace();
        }
    }
    private static String replaceAllTextWithNumber(String line){

        Map<String, String> map = new LinkedHashMap<>();
        map.put("one","1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        for (Map.Entry<String, String> entry: map.entrySet()){
            String word = entry.getKey();
            String number = entry.getValue();

            line = line.replace(word,
                    word.substring(0,1)
                            + number +
                            word.substring(word.length()-1));
        }
        return line;
    }
    private static int calibrationValue(String line) {
        List<Integer> list = new LinkedList<>();
        String calibrationNumber = "";
        Integer firstdigit = null;
        Integer lastdigit = null;

        for (char character : line.toCharArray()){
            if (Character.isDigit(character)){
                list.add(Integer.parseInt(String.valueOf(character)));
                firstdigit = list.stream().findFirst().get();
                lastdigit = list.get(list.size()-1);
                calibrationNumber = String.valueOf(firstdigit) + String.valueOf(lastdigit);
            }
        }
        System.out.println(line + "  " + calibrationNumber);

        if (calibrationNumber.equals("")){
            return 0;
        }

        return Integer.parseInt(calibrationNumber);
    }
}