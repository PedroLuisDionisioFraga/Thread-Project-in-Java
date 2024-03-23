package Models;

import java.io.IOException;

public class Terminal {
  public static void clean() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}
