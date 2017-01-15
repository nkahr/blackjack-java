package game;
import java.util.*;

public abstract class Game {

  Deck deck; 
  ArrayList<Player> players = new ArrayList<Player>();
  ArrayList<Player> winners = new ArrayList<Player>();


  // public Game(ArrayList<Player> players) {
  //   this.players = players;    
  //   this.winners = new ArrayList<Player>();
  // }

  // public ArrayList<Player> getWinners() {
  //   return this.winners;
  // }

  public String play() {
    return "";
  }

  public Deck getDeck() {
    return this.deck;
  }

  public ArrayList<Player> getPlayers() {
    return this.players;
  }

  public static Deck make52Deck() {
    Deck deck = new Deck();
    Card card;
    for (Value value : Value.values()) {
      for (Suit suit : Suit.values()) {
        card = new Card(suit, value);
        deck.addCard(card);
      }
    }
    deck.shuffleDeck();
    return deck;
  }


  public static ArrayList<Player> getPlayersWithMaxScore(ArrayList<Player> players) {
    // find max score 
    ArrayList<Player> winners = new ArrayList<Player>();
    Integer maxScore = 0;
    for (Player player : players) {
      if (maxScore == 0 || player.getPlayerScore() > maxScore) {
        winners = new ArrayList<Player>();
        winners.add(player);
        maxScore = player.getPlayerScore();
      } else if (player.getPlayerScore() == maxScore) {
        winners.add(player);
      }

    }
    return winners;
  }


  public static void addPointsToPlayerScore(ArrayList<Player> players, HashMap<Value, Integer> pointsMap) {
    for (Player player : players) {
      player.setScore(0); // in case score has already been added?
      for (Card card : player.getHand().getCards()) {
        Integer score = pointsMap.get(card.getValue());
        player.addToScore(score);
      }
    }
  }


}