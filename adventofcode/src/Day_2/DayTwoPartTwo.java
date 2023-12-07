package Day_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DayTwoPartTwo {

    public static void main(String[] args) {
        String path = "C:\\Users\\SinanYagsagan\\Desktop\\AdventOfCode\\adventofcode\\src\\Day_2\\puzzle_day_two.txt";
        Path pathWay = Paths.get(path);

        int powerOfSets = 0;
        try {
            List<String> lines = Files.readAllLines(pathWay);
            for (String line : lines) {
                powerOfSets += gameStart(line);
            }
            System.out.println("Power of Sets : " + powerOfSets);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static int gameStart(String line) {

        String[] gameIds = line.split(":");
        String[] games = gameIds[1].split(";");

        int result = 0;
        int quantityHighForBlue = 0;
        int quantityHighForGreen = 0;
        int quantityHighForRed = 0;

        for (String game : games) {
            String[] tours = game.trim().split(", ");
            for (String tour : tours) {
                String[] parts = tour.split(" ");
                int quantity = Integer.parseInt(parts[0]);
                String colorName = parts[1];

                switch (colorName){
                    case "blue" ->{
                        if (quantityHighForBlue < quantity)
                            quantityHighForBlue = quantity;
                    }
                    case "green" ->{
                        if (quantityHighForGreen < quantity)
                            quantityHighForGreen = quantity;
                    }
                    case "red" ->{
                        if (quantityHighForRed < quantity)
                            quantityHighForRed = quantity;
                    }
                }
                result = quantityHighForBlue * quantityHighForGreen * quantityHighForRed;
            }
        }
        return result;
    }
}
