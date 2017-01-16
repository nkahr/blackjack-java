package game;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Player player = new Player("Nina");

    BlackJack gameTest = new BlackJack();
    gameTest.play();
  }
}