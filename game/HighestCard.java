package game;
import java.util.*;

public class HighestCard extends Game {

  Deck deck = new Deck();
  ArrayList<Player> players;
  HashMap<Value, Integer> scores = new HashMap<Value, Integer>();

  public HighestCard(ArrayList<Player> players) {
    this.players = players;    
  }

  public void makeDeck() {
    Card card;
    for (Value value : Value.values()) {
      for (Suit suit : Suit.values()) {
        card = new Card(suit, value);
        deck.addCard(card);
      }
    }
    deck.shuffle();
  }

  public void assignScores() {
    scores.put(Value.ACE, 14);
    scores.put(Value.TWO, 2);
    scores.put(Value.THREE, 3);
    scores.put(Value.FOUR, 4);
    scores.put(Value.FIVE, 5);
    scores.put(Value.SIX, 6);
    scores.put(Value.SEVEN, 7);
    scores.put(Value.EIGHT, 8);
    scores.put(Value.NINE, 9);
    scores.put(Value.TEN, 10);
    scores.put(Value.JACK, 11);
    scores.put(Value.QUEEN, 12);
    scores.put(Value.KING, 13);
  }

  public ArrayList<Player> gameLoop() {
    makeDeck();
    assignScores();
    Integer highestValue = 0;
    ArrayList<Player> winners = new ArrayList<Player>();
    for (Player player : players) {
      deck.dealCardToPlayer(player);
      Hand hand = player.getHand();
      Card card = hand.getCards().remove(0);
      Value value = card.getValue();
      Integer valueInt = scores.get(value);
      if (valueInt > highestValue) {
        winners = new ArrayList<Player>();
        winners.add(player);
      } else if (valueInt == highestValue) {
        winners.add(player);
      }
    }
    return winners;
  }

}