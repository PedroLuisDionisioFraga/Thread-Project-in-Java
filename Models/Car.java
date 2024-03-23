package Models;

import Models.Abstract.*;

/**
 * Car class extends Competitor class and represents a car in the race.
 */
public class Car extends Competitor {
  // Attributes
  public String brand; // Brand of the car
  public int year; // Year of manufacture of the car
  public int acceleration; // Acceleration of the car (not yet implemented)

  /**
   * Constructor for Car class.
   *
   * @param name  Name of the car.
   * @param brand Brand of the car.
   * @param year  Year of manufacture of the car.
   */
  public Car(String name, String brand, int year) {
    super(name); // Call to the superclass constructor

    this.brand = brand;
    this.year = year;
  }

  /**
   * Method to simulate the car running in the race.
   * The car continues to run until it reaches the end of the Speedway.
   * If the car falls into a trap, it waits for a certain duration before
   * continuing.
   */
  @Override
  public void run() {
    System.out.println(super.name + " is running...");
    while (super.position < Models.Speedway.getLength()) {
      updatePosition();

      try {
        Thread.sleep(Speedway.DELAY_MS_BETWEEN_POSITIONS_UPDATE);
      } catch (InterruptedException e) {
        e.printStackTrace();
        System.out.println("Error in thread sleep: " + e.getMessage());
      }
    }

    // Finish the race, adding to the winners list
    Speedway.addWinner(this);
  }

  /**
   * Synchronized method to update the position of the car.
   * If the car falls into a trap, it waits for a certain duration before updating
   * its position.
   */
  @Override
  protected synchronized void updatePosition() {
    boolean trapActioned = Trap.fellIntoTheTrap();

    if (trapActioned) {
      try {
        System.out.println(super.name + " fell into the trap!");
        Thread.sleep(Trap.TRAP_DURATION_MS);
      } catch (InterruptedException e) {
        e.printStackTrace();
        System.out.println("Error in thread sleep on TRAP: " + e.getMessage());
      }
    }
    position += 1;
    System.out.println("Position of " + super.name + " is " + super.position);
  }

  /**
   * Getter for the position of the car.
   *
   * @return The current position of the car.
   */
  public int getPosition() {
    return super.position;
  }
}