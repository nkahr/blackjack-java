package game;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Player player1 = new Player("Nina");
    Player player2 = new Player("Paul");
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);
    Game gameTest = new HighestCard(players);
  }
}