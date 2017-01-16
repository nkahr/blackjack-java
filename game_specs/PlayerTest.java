import static org.junit.Assert.*;
import org.junit.*;
import game.*;
import java.util.*;


public class PlayerTest {

  Card card;
  Deck deck;
  Player player;

  @Before 
  public void before() {
    card = new Card(Suit.HEARTS, Value.ACE);
    deck = Game.make52Deck();
    player = new Player("Nina");
  }

  @Test 
  public void canGetPlayerName() {
    assertEquals("Nina", player.getName());
  }

  @Test 
  public void canGetPlayerHand() {
    deck.dealCardToPlayer(player);
    deck.dealCardToPlayer(player);
    assertEquals(2, player.getHand().numberOfCards());
  }

  @Test 
  public void playerHasAce() {
    player.getHand().addCard(card);
    assertEquals(true, player.hasAce());
  }

  @Test 
  public void playerDoesntHaveAce() {
    Card nonAceCard = new Card(Suit.CLUBS, Value.THREE);
    player.getHand().addCard(nonAceCard);
    assertEquals(false, player.hasAce());
  }

  // @Test 
  // public void cardsInHandArePrivate() {
  //   CardHabitat hand = player.getHand();
  //   assertEquals(Visibility.PRIVATE, hand.getVisibility());
  // }

}