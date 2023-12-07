package Day_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DayTwo {

    public static void main(String[] args) {
        String path = "C:\\Users\\SinanYagsagan\\Desktop\\AdventOfCode\\adventofcode\\src\\Day_2\\puzzle_day_two.txt";
        Path pathWay = Paths.get(path);
        int sumOfIDs = 0;
        try {
            List<String> lines = Files.readAllLines(pathWay);
            for (String line : lines) {

                String[] gameIds = line.split(":");
                String gameId = gameIds[0];
                String[] number = gameId.trim().split(" ");

                if (gameStart(line)){
                    sumOfIDs += Integer.parseInt(number[1]);
                }
            }
            System.out.println("Sum of Game Index : " + sumOfIDs);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static boolean gameStart(String line) {

        String[] gameIds = line.split(":");
        String[] games = gameIds[1].split(";");

        for (String game : games) {
            String[] tours = game.trim().split(", ");
            for (String tour : tours) {
                String[] parts = tour.split(" ");
                int quantity = Integer.parseInt(parts[0]);
                String colorName = parts[1];

                switch (colorName) {
                    case "blue" -> {
                        if (quantity > 14) {
                            return false;
                        }
                    }
                    case "green" -> {
                        if (quantity > 13) {
                            return false;
                        }
                    }
                    case "red" -> {
                        if (quantity > 12) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}