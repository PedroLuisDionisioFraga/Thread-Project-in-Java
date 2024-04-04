package Models;

import java.util.Collections;

import Models.Abstract.Competitor;

public class Displays extends Speedway implements Runnable {

  @Override
  public void run() {
    Displays.printStartCompetition();
    do {
      Speedway.lapNumber++;

      showPositions();

      try {
        Thread.sleep(DELAY_MS_BETWEEN_POSITIONS_UPDATE);
      } catch (InterruptedException e) {
        System.out.println("Thread to show positions interrupted");
        break;
      }
    } while (winners.size() < competitors.size());

    showWinners();
    Displays.printEndCompetition();
  }

  /**
   * Displays the list of winners.
   */
  private static void showWinners() {
    System.out.println("\r\n========== WINNERS ==========");
    Collections.sort(winners);
    for (Competitor winner : winners) {
      System.out.println("The " + winner.name + " win in position " + winner.getPosition());
    }
    System.out.println("========== END WINNERS ==========");
  }

  private static void showPositions() {
    System.out.println("\r\n========== POSITIONS ==========");
    for (Competitor competitor : competitors) {
      System.out.println(competitor.name + " is at position " + competitor.getPosition());
    }
    System.out.println("========== END POSITIONS ==========");
  }

  private static void printStartCompetition() {
    System.out.println("========== START RACER ==========");
  }

  private static void printEndCompetition() {
    System.out.println("\r\n========== END RACER ==========");

  }
}
