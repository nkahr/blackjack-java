package game;
import java.util.*;

public class BlackJack {

  private Deck deck = Game.make52Deck();
  private HashMap<Value, Integer> pointsMap = new HashMap<Value, Integer>();
  Player dealer = new Player("Dealer");
  Player gambler;
  private ArrayList<Player> players = new ArrayList<Player>();
  private ArrayList<Player> winners = new ArrayList<Player>();
  Player winner;
  Scanner scanner = new Scanner(System.in);

  // public BlackJack(Player gambler) {
  //   this.gambler = gambler;    
  // }

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

  public void hit(Player player) {
    deck.dealCardToPlayer(player);
  }


  public void setup() {
    assignPoints();
    Card card1;
    Card card2;
    Card card3;

    System.out.println("Welcome to Nina's semi-functional Casino");
    System.out.println("Name: ");

    String input = scanner.nextLine();

    gambler = new Player(input);
    players.add(dealer);
    players.add(gambler);

    deck.dealCardsToPlayers(players, 2); //deal

    Game.addPointsToPlayerScore(players, pointsMap); //update player scores

    card1 = gambler.getHand().getCards().get(0);
    card2 = gambler.getHand().getCards().get(1);
    card3 = dealer.getHand().getCards().get(0);

    System.out.println( gambler.getName() + ", you were dealt the " + card1.getValue() + " of " + card1.getSuit() + " and the " + card2.getValue() + " of " + card2.getSuit() + ". The dealer's visible card is a " + card1.getValue() + " of " + card1.getSuit() + ".");

    if (dealer.getPlayerScore() == 21) {
      if (gambler.getPlayerScore() == 21) {
        System.out.println("You both score 21. I don't know how blackjack works... Everybody wins?");
        winner = new Player("Everybody");
      } else {
        System.out.println("The dealer reveals his other card and scores 21, you lose!");
        winner = dealer;
      }
    }
  }


  public String play() {
    setup();
    while (winner == null) {
      System.out.println("Do you want to hit or stay?");
      String input = scanner.nextLine();
      if (input == "hit") {
        hit(gambler);
      } else if (input == "stay") {
        System.out.println("I don't know?");
      } else {
        System.out.println("Please give a valid input. Note to self: make the program repeat question");
      }
      winner = gambler;
    }
    return "";
  }

}