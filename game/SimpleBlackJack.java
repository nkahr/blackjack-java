package game;
import java.util.*;

public class SimpleBlackJack extends Game {

  Deck deck = new Deck();
  ArrayList<Player> players;
  HashMap<Value, Integer> scores = new HashMap<Value, Integer>();

  public SimpleBlackJack(ArrayList<Player> players) {
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

  public void makeScores() {
    scores.put(Value.ACE, 11);
    scores.put(Value.TWO, 2);
    scores.put(Value.THREE, 3);
    scores.put(Value.FOUR, 4);
    scores.put(Value.FIVE, 5);
    scores.put(Value.SIX, 6);
    scores.put(Value.SEVEN, 7);
    scores.put(Value.EIGHT, 8);
    scores.put(Value.NINE, 9);
    scores.put(Value.TEN, 10);
    scores.put(Value.JACK, 10);
    scores.put(Value.QUEEN, 10);
    scores.put(Value.KING, 10);
  }


}