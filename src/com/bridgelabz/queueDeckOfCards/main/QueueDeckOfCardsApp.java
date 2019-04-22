package com.bridgelabz.queueDeckOfCards.main;

import com.bridgelabz.queueDeckOfCards.data.QueueDeckOfCardsManagement;
import com.bridgelabz.queueDeckOfCards.dataImpl.QueueDeckOfCardsImpl;

public class QueueDeckOfCardsApp {

	public static void main(String[] args) {
		QueueDeckOfCardsManagement deck = new QueueDeckOfCardsImpl();
		deck.intializeCard();
		deck.shuffleCard();
		deck.deckQueueStore();
		deck.displayDeck();
	}

}
