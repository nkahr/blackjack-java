package game;
import java.util.*;

public class Deck implements CardHabitat {

  ArrayList<Card> cards = new ArrayList<Card>();
  Visibility visibility = Visibility.DOWN;

  public void addCard(Card card) {
    cards.add(card);
  }

  public void shuffleDeck() {
    Collections.shuffle(cards);
  }

  public int numberOfCards() {
    return cards.size();
  }

  public void dealCardToPlayer(Player player) {
    Card card = cards.remove(0);
    player.getHand().addCard(card);
  }

  public void dealCardsToPlayers(ArrayList<Player> players, int numberOfCards) {
    for (int i = 0; i < numberOfCards; i++) {
      for (Player player : players) {
        Card card = cards.remove(0);
        player.getHand().addCard(card);
      }
    }
  }

  public Visibility getVisibility() {
    return this.visibility;
  }

}