package game;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements CardHabitat {

  ArrayList<Card> cards = new ArrayList<Card>();
  Visibility visibility = Visibility.DOWN;

  public void addCard(Card card) {
    cards.add(card);
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public int numberOfCards() {
    return cards.size();
  }

  public void dealCardToPlayer(Player player) {
    Card card = cards.remove(0);
    player.hand.addCard(card);
  }

  public Visibility getVisibility() {
    return this.visibility;
  }

}