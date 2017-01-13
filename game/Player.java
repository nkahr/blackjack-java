package game;
import java.util.ArrayList;

public class Player {

  String name;
  Hand hand;

  public Player(String name) {
    this.name = name;
    this.hand = new Hand();
  }

  public String getName() {
    return this.name;
  }

  public Hand getHand() {
    return this.hand;
  }
}