# Speedway Race Simulation Using Threads
This project simulates a race using threads in Java to demonstrate the lifecycle of threads, synchronization, and thread management.

## Table of Contents
- [Introduction](#Introduction)

# Introduction
The application simulates a race in a straight line with multiple cars with same and constant speed, each car is represented by a separate thread.

The competitors are monitored by a `Displays` class, also is a thread, that shows the progress of the race.

When a car finishes the race, it calls the finish method, which is synchronized to prevent race conditions. The Speedway class keeps track of the cars that have finished the race.

The `Displays` class provides a visual representation of the race. It updates the display as the race progresses.

The `Trap` class represents a trap that can affect a car during the race. When a car encounters a trap, it triggers the trap's trigger method.


## Purpose
The purpose of this project is to demonstrate the use of threads in Java. It shows how to create and manage threads, how to synchronize methods to prevent race conditions, and how to use threads to manage multiple entities operating concurrently.