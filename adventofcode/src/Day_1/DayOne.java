package Day_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class DayOne {

    public static void main(String[] args) {
    String path = "C:\\Users\\SinanYagsagan\\Desktop\\AdventOfCode\\adventofcode\\src\\Day_1\\puzzle.txt";
    Path pathWay = Paths.get(path);
    try {
        List<String> lines =  Files.readAllLines(pathWay);
        int totalSum = 0;
        for (String line: lines){
            if(existNumber(line)){
                totalSum += calibrationValue(line);
            }
        }
        System.out.println("Total Calibration value is : "+ totalSum);

    } catch(IOException exception){
        exception.printStackTrace();
    }
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
        return Integer.parseInt(calibrationNumber);
    }
    private static boolean existNumber(String line) {
        for (char character : line.toCharArray()){
            if (Character.isDigit(character)){
                return true;
            }
        }
        return false;
    }
}