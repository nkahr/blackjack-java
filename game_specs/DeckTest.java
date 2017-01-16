import static org.junit.Assert.*;
import org.junit.*;
import game.*;
import java.util.*;


public class DeckTest {

  Card card;
  Deck deck;
  Player player1;
  Player player2;

  @Before 
  public void before() {
    card = new Card(Suit.HEARTS, Value.ACE);
    deck = new Deck();
    player1 = new Player("Nina");
    player2 = new Player("Paul");
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
  public void canMake52DeckStaticMethod() {
    deck = Game.make52Deck();
    assertEquals(52, deck.numberOfCards());
  }

  @Test 
  public void canDealCardToPlayer() {
    deck = Game.make52Deck();
    deck.dealCardToPlayer(player1);
    CardHabitat hand = player1.getHand();
    assertEquals(1, hand.numberOfCards());
    assertEquals(51, deck.numberOfCards());
  }

  @Test 
  public void deal2CardsToPlayers() {
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);
    deck = Game.make52Deck();
    deck.dealCardsToPlayers(players, 2);
    assertEquals(2, player1.getHand().numberOfCards());
    assertEquals(2, player2.getHand().numberOfCards());
    assertEquals(48, deck.numberOfCards());
  }

  // @Test 
  // public void cardsInDeckAreFaceDown() {
  //   assertEquals(Visibility.DOWN, deck.getVisibility());
  // }


}