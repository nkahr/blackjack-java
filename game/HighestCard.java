package game;
import java.util.ArrayList;

public class HighestCard extends Game {

  Deck deck = new Deck();
  ArrayList<Player> players;
  ArrayList<Integer> scores = new ArrayList<Integer>();

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
  }

  public void makeScores() {
    for (Integer i = 1; i < 14; i++) {
      scores.add(i);
    }
  }

  public void gameLoop() {
    makeDeck();
    makeScores();
    for (Player player : players) {
      deck.dealCardToPlayer(player);
    }
    numberOfPlayers = players.size();
    for (int i = 0; i < numberOfPlayers; i++) {
      
    }
  }
}