package Models.Abstract;

import java.util.Random;

/**
 * The Trap class represents a trap in a game or simulation.
 * It has a method to determine if a trap has been activated and to simulate the
 * delay caused by the trap.
 */
public class Trap {
  // The factor used to determine the chance of the trap being activated.
  private static final int CHANCE_FACTOR = 10;

  // The duration in milliseconds that a thread will sleep if it falls into the
  // trap.
  public static final int TRAP_DURATION_MS = 1500;

  /**
   * Determines if a trap has been activated.
   * There is a 10% chance that the trap will be activated.
   * If the trap is activated, the thread sleeps for a specified duration to
   * simulate the delay caused by the trap.
   *
   * @return true if the trap was activated, false otherwise.
   */
  public static boolean fellIntoTheTrap() {
    // Create a new Random object
    Random random = new Random();

    // Generate a random integer between 0 (inclusive) and CHANCE_FACTOR
    // (exclusive).
    // If the random integer is 0, the trap is activated (10% chance).
    boolean trapActioned = random.nextInt(CHANCE_FACTOR) == 0;

    // Return whether the trap was activated or not
    return trapActioned;
  }
}