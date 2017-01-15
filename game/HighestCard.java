package game;
import java.util.*;

public class HighestCard extends Game {

  private Deck deck = Game.make52Deck();
  private ArrayList<Player> players;
  private HashMap<Value, Integer> pointsMap = new HashMap<Value, Integer>();
  ArrayList<Player> winners;

  public HighestCard(ArrayList<Player> players) {
    this.players = players;    
    winners = new ArrayList<Player>();
  }

  public ArrayList<Player> getWinners() {
    return this.winners;
  }

  public void assignPoints() {
    pointsMap.put(Value.TWO, 1);
    pointsMap.put(Value.THREE, 2);
    pointsMap.put(Value.FOUR, 3);
    pointsMap.put(Value.FIVE, 4);
    pointsMap.put(Value.SIX, 5);
    pointsMap.put(Value.SEVEN, 6);
    pointsMap.put(Value.EIGHT, 7);
    pointsMap.put(Value.NINE, 8);
    pointsMap.put(Value.TEN, 9);
    pointsMap.put(Value.JACK, 10);
    pointsMap.put(Value.QUEEN, 11);
    pointsMap.put(Value.KING, 12);
    pointsMap.put(Value.ACE, 13);
  }

  public String play() {
    //setup
    assignPoints();
    deck.dealCardsToPlayers(players, 1);
    Game.addPointsToPlayerScore(players, pointsMap);
    winners = Game.getPlayersWithMaxScore(players);
    if (winners.size() == 1) {
      return winners.get(0).getName() + " wins with " + winners.get(0).getPlayerScore() + " points!";
    } else {
      return "multiple players win";
    }
  }
}