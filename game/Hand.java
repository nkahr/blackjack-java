package game;
import java.util.ArrayList;

public class Hand implements CardHabitat {

  ArrayList<Card> cards = new ArrayList<Card>();
  Visibility visibility = Visibility.PRIVATE;

  public ArrayList<Card> getCards() {
    return this.cards;
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public int numberOfCards() {
    return cards.size();
  }

  public Visibility getVisibility() {
    return this.visibility;
  }
}