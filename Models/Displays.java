package Models;

import java.util.Collections;

import Models.Abstract.Competitor;

public class Displays extends Speedway implements Runnable {

  @Override
  public void run() {
    // Distance traveled by the competitors
    boolean lastCompetitorFinished = false;
    boolean actualCompetitorFinished;

    while (!raceFinished) {
      // TODO: This fucking logic is crap, `show Positions` is being called three times more than it should, but this logic is better than I can do so far
      for (Competitor competitor : competitors) {
        actualCompetitorFinished = competitor.finished;
        raceFinished = lastCompetitorFinished && actualCompetitorFinished;
        lastCompetitorFinished = actualCompetitorFinished;
      }

      showPositions();

      try {
        Thread.sleep(DELAY_MS_BETWEEN_POSITIONS_UPDATE);
      } catch (InterruptedException e) {
        System.out.println("Thread to show positions interrupted");
        break;
      }
    }

    showWinners();
  }

  /**
   * Displays the list of winners.
   */
  private static void showWinners() {
    System.out.println("\r\n========== WINNERS ==========");
    Collections.sort(competitors);
    for (Competitor winner : competitors) {
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

}
