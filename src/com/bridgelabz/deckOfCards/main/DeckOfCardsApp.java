package com.bridgelabz.deckOfCards.main;

import com.bridgelabz.deckOfCards.data.DeckOfCardsManagement;
import com.bridgelabz.deckOfCards.dataImpl.DeckOfCardsImpl;

public class DeckOfCardsApp {
	public static void main(String[] args) {

		DeckOfCardsManagement deckImpl = new DeckOfCardsImpl();
		deckImpl.intializeCard();
		deckImpl.shuffleCard();
		deckImpl.displayCard();
	}
}
