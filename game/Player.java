package game;
import java.util.ArrayList;

public class Player {

  private String name;
  private Hand hand;
  public Integer score;

  public Player(String name) {
    this.name = name;
    this.hand = new Hand();
    this.score = 0;
  }

  public String getName() {
    return this.name;
  }

  public Hand getHand() {
    return this.hand;
  }

  public Integer getPlayerScore() {
    return this.score;
  }

  public void addToScore(Integer dScore) {
    this.score += dScore;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public boolean hasAce() {
    boolean playerHasAce = false;
    for (Card card : hand.getCards()) {
      if (card.getValue().equals(Value.ACE)) {
        playerHasAce = true;
      }
    }
    return playerHasAce;
  }

}