package game;
import java.util.*;

public class SimpleBlackJack extends Game {

  private Deck deck = Game.make52Deck();
  private ArrayList<Player> players;
  private HashMap<Value, Integer> pointsMap = new HashMap<Value, Integer>();
  ArrayList<Player> winners = new ArrayList<Player>();

  public SimpleBlackJack(ArrayList<Player> players) {
    this.players = players;    
  }

  public ArrayList<Player> getWinners() {
    return this.winners;
  }

  public void assignPoints() {
    pointsMap.put(Value.ACE, 11);
    pointsMap.put(Value.TWO, 2);
    pointsMap.put(Value.THREE, 3);
    pointsMap.put(Value.FOUR, 4);
    pointsMap.put(Value.FIVE, 5);
    pointsMap.put(Value.SIX, 6);
    pointsMap.put(Value.SEVEN, 7);
    pointsMap.put(Value.EIGHT, 8);
    pointsMap.put(Value.NINE, 9);
    pointsMap.put(Value.TEN, 10);
    pointsMap.put(Value.JACK, 10);
    pointsMap.put(Value.QUEEN, 10);
    pointsMap.put(Value.KING, 10);
  }

  public String play() {
    assignPoints(); 
    deck.dealCardsToPlayers(players, 2);
    Game.addPointsToPlayerScore(players, pointsMap);
    winners = Game.getPlayersWithMaxScore(players);
    return "hi";
  }




}