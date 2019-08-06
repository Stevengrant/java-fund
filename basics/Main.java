import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
  public static void main(String[] args) {
    int dogCount = 1;
    System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

    int catCount = 2;
    System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

    int turtleCount = 0;
    System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");
    System.out.println(flipNHeads(1));
    System.out.println(flipNHeads(2));
    clock();
  }

  // Write a function called pluralize that accepts a word and a number and
  // returns a string with the word pluralized with an “s” if the number is zero,
  // or greater than one.
  public static String pluralize(String word, int numberOf) {
    String pural = new String("");
    if (numberOf == 0 || numberOf > 1) {
      pural = "s";
    }
    return "" + word + pural;
  }

  public static String flipNHeads(int targetHeadsCount) {
    int headCount = 0;
    int totalFlips = 0;
    do {
      totalFlips++;
      double random = Math.random();
      int flipRes = 0;
      if (random > 0.5) {
        flipRes = 1;
        System.out.println("heads");
        headCount++;
      } else {
        headCount = 0;
        System.out.println("tails");
      }
    } while (headCount < targetHeadsCount);

    return "It took " + totalFlips + " flips to flip " + headCount + " heads in a row.";
  }

  public static void printTime() {
    LocalDateTime now = LocalDateTime.now();
    int hour = now.getHour();
    int minute = now.getMinute();
    int second = now.getSecond();
    System.out.println("" + hour + ":" + minute + ":" + second);
  }

  // https://www.codota.com/code/java/methods/java.util.Timer/schedule
  public static void clock() {
    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        printTime();
      }
    }, 1111, 1000);
  }
}