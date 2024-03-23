package Models.Abstract;

import Models.Speedway;

/**
 * Abstract class Competitor implements Runnable interface.
 * This class represents a competitor in the race.
 */
abstract public class Competitor extends Speedway implements Runnable, Comparable<Competitor> {
  // Attributes
  public String name; // Name of the competitor
  protected int position; // Current position of the competitor in the race
  public boolean finished;
  /**
   * Constructor for Competitor class.
   *
   * @param name Name of the competitor.
   */
  public Competitor(String name) {
    this.name = name;
    position = 1; // Initialize position to 0 at the start of the race
    finished = false;
  }

  /**
   * Method to simulate the competitor running in the race.
   * This method is implemented in child classes.
   */
  @Override
  public void run() {
    // Implemented in child classes
  }

  /**
   * Abstract method to update the position of the competitor.
   * This method is implemented in child classes.
   */
  abstract protected void updatePosition();

  /**
   * Getter for the position of the competitor.
   *
   * @return The current position of the competitor.
   */
  public int getPosition() {
    return position;
  }
}