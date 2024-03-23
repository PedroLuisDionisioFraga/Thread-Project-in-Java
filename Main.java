import Models.Car;
import Models.Speedway;
import Models.Abstract.Competitor;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    System.out.println("========== START RACER ==========\r\n");

    // Create competitors
    ArrayList<Competitor> competitors = new ArrayList<>(Arrays.asList(
        new Car("Golf GTR 2.0 Turbo", "Volkswagen", 2024),
        new Car("Lancer Evolution 2.0", "Mitsubishi", 2023),
        new Car("Civic Type R 2.0 Turbo", "Honda", 2022),
        new Car("Corolla 2.0 Turbo", "Toyota", 2021),
        new Car("Cruze 2.0 Turbo", "Chevrolet", 2020),
        new Car("Focus 2.0 Turbo", "Ford", 2019),
        new Car("Camaro 2.0 Turbo", "Chevrolet", 2018)
    ));

    // Create speedway
    Speedway speedway = new Models.Speedway(10, competitors);

    // Start
    speedway.startRace();

    System.out.println("========== END RACER ==========\r\n");

    // Print winners
    Speedway.showWinners();
  }
}
