import static org.junit.Assert.*;
import org.junit.*;
import game.*;
import java.util.ArrayList;


public class GameTest {

  Card card;
  Deck deck;
  Player player;

  @Before 
  public void before() {
    card = new Card(Suit.HEARTS, Value.ACE);
    deck = new Deck();
    player = new Player("Nina");
  }

  @Test
  public void cardHasValue() {
    assertEquals(Value.ACE, card.getValue());
  }

  @Test
  public void cardHasSuit() {
    assertEquals(Suit.HEARTS, card.getSuit());
  }

  @Test 
  public void canAddCardToDeck() {
    deck.addCard(card);
    assertEquals(1, deck.numberOfCards());
  }

  @Test 
  public void canAdd52Cards() {
    Card card;
    for (Value value : Value.values()) {
      for (Suit suit : Suit.values()) {
        card = new Card(suit, value);
        deck.addCard(card);
      }
    }
    assertEquals(52, deck.numberOfCards());
  }

  @Test 
  public void canGetPlayerName() {
    assertEquals(0, deck.numberOfCards());
    assertEquals("Nina", player.getName());
  }

  @Test 
  public void canDealCardToPlayer() {
    deck.addCard(card);
    deck.dealCardToPlayer(player);
    CardHabitat hand = player.getHand();
    assertEquals(1, hand.numberOfCards());
  }

  @Test 
  public void cardsInDeckAreFaceDown() {
    assertEquals(Visibility.DOWN, deck.getVisibility());
  }

  @Test 
  public void cardsInHandArePrivate() {
    CardHabitat hand = player.getHand();
    assertEquals(Visibility.PRIVATE, hand.getVisibility());
  }

  @Test 
  public void canMakeHighestCardGame() {
    Player player1 = new Player("Nina");
    Player player2 = new Player("Paul");
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);
    Game highestCard = new HighestCard(players);
  }

  @Test 
  public void playerWinsOnePlayerGame() {
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player);
    HighestCard highestCard = new HighestCard(players);
    ArrayList<Player> winnerArray = highestCard.gameLoop();
    Player winner = winnerArray.remove(0);
    assertEquals(player, winner);
  }

}