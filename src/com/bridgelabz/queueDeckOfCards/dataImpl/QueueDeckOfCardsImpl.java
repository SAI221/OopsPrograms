package com.bridgelabz.queueDeckOfCards.dataImpl;

import com.bridgelabz.queueDeckOfCards.data.QueueDeckOfCardsManagement;
import com.bridgelabz.util.QueueLinkedList;

public class QueueDeckOfCardsImpl implements QueueDeckOfCardsManagement {

	String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	int n = suits.length * ranks.length;
	String[] deck = new String[n];
	QueueLinkedList<QueueLinkedList<String>> mainQueue = new QueueLinkedList<QueueLinkedList<String>>();
	QueueLinkedList<String> Queue = new QueueLinkedList<String>();

	@Override
	public void intializeCard() {
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				deck[suits.length * i + j] = ranks[i] + " " + suits[j];
			}
		}

	}

	@Override
	public void shuffleCard() {
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}

	}

	@Override
	public void deckQueueStore() {
		System.out.println("Total number of deck of cards are " + deck.length);
		for (int i = 0; i < 4; i++) {
			String[] demo = new String[9];
			for (int j = 0; j < 9; j++) {
				demo[j] = deck[i + j * 4];
				Queue.insert(demo[j]);
			}

			mainQueue.insert(Queue);
			Queue = new QueueLinkedList<String>();
			continue;
		}

	}

	@Override
	public void displayDeck() {
		for (int i = 0; i < mainQueue.getSize(); i++) {
			QueueLinkedList<String> queue2 = mainQueue.remove();
			System.out.println(" Person " + (i + 1));
			for (int j = 0; j < queue2.getSize(); j++) {
				System.out.print(queue2.remove() + "  ");
			}
			System.out.println();
		}
	}

}
