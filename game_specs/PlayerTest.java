import static org.junit.Assert.*;
import org.junit.*;
import game.*;
import java.util.ArrayList;


public class PlayerTest {

  Deck deck;
  Card card;

  @Before 
  public void before() {
    card = new Card(Suit.HEARTS, Value.ACE);
  }
}