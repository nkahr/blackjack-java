import static org.junit.Assert.*;
import org.junit.*;
import game.*;
import java.util.*;
// import org.mockito.*;
// import static org.mockito.Mockito.*;


public class GameTest {

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
  public void canMakeHighestCardGame() {
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);
    Game game = new HighestCard(players);
  }

  @Test 
  public void playerWinsOnePlayerGameHighestScore() {
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    HighestCard game = new HighestCard(players);
    game.play();
    ArrayList<Player> winnerArray = game.getWinners();
    Player winner = winnerArray.get(0);
    assertEquals(player1, winner);
  }

  @Test
  public void canGetPlayerWithMaxScore() {
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);

    player1.addToScore(7);
    player2.addToScore(10);

    Player winner = Game.getPlayersWithMaxScore(players).get(0);
    assertEquals((Integer) 7, player1.getPlayerScore());
    assertEquals((Integer) 10, player2.getPlayerScore());
    assertEquals(player2, winner);

    player1.setScore(5);
    player2.setScore(4);

    winner = Game.getPlayersWithMaxScore(players).get(0);
    assertEquals((Integer) 5, player1.getPlayerScore());
    assertEquals((Integer) 4, player2.getPlayerScore());
    assertEquals(player1, winner);
  }

  public void singlePlayerSimpleBlackJack() {
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    SimpleBlackJack game = new SimpleBlackJack(players);
    assertEquals(player1, game.getWinners().get(0));
  }

}