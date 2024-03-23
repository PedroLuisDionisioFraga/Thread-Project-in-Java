package Models;

import java.util.ArrayList;

import Models.Abstract.Competitor;

/**
 * The Speedway class represents the race track where the competitors race.
 */
public class Speedway {
  // Constants
  public static final int DELAY_MS_BETWEEN_POSITIONS_UPDATE = 1000; // Delay between position updates

  // Attributes
  protected static ArrayList<Competitor> competitors; // List of competitors in the race
  protected static ArrayList<Thread> threads; // Threads for each competitor
  private static Thread showPositionsOfRunnersThread; // Thread to show positions
  protected static boolean raceFinished;

  protected static int length; // Length of the speedway

  public static float distanceBetweenIntervals;

  /**
   * Constructor for Speedway class.
   *
   * @param length      Length of the speedway.
   * @param competitors List of competitors in the race.
   */
  public Speedway(int length, ArrayList<Competitor> competitors) {
    Speedway.length = length;
    Speedway.competitors = competitors;
    winners = new ArrayList<Competitor>();

    createThreads(); // Create a new thread for each competitor
  }

  /**
   * Starts the race by starting all threads and waits for them to finish.
   */
  public void startRace() {
    // Start all threads
    for (Thread thread : threads) {
      try {
        thread.start();
      } catch (IllegalThreadStateException e) {
        e.printStackTrace();
        System.out.println("Error in getting value of name attribute in thread");
      }
    }
    // Wait for all threads to finish
    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("\r\n========== END RACER ==========");
  }

  /**
   * Creates a new thread for each competitor.
   */
  private void createThreads() {
    threads = new ArrayList<Thread>();
    for (Competitor competitor : competitors) {
      threads.add(new Thread(competitor));
    }
  }

  // Getters and Setters
  public static int getLength() {
    return length;
  }

  public static ArrayList<Competitor> getCompetitors() {
    return competitors;
  }
}