package com.sp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;

@Service
public class CardDao {
	private List<Card> myCardList;
	
	public CardDao() {
		myCardList = new ArrayList<>();
		createCardList();
	}
	
	private void createCardList() {
		  
		Card p1=new Card("Mickael", "Dev react", "Top", "affi", 1, 2, 2, 23, 3);
		Card p2=new Card("Theo", "Dev java", "tok", "affity", 1, 20, 2, 2, 3);
		Card p3=new Card("Mick", "Dev", "kad", "afnity", 1, 2, 24, 20, 3);

		myCardList.add(p1);
		myCardList.add(p2);
		myCardList.add(p3);
	}
	
	public List<Card> getCardList() {
		return this.myCardList;
	}
	
	public Card addCard(String name, String description, String family, String affinity, Integer energy, Integer hp, Integer defence, Integer attack, Integer price) {
		Card card = new Card(name, description, family, affinity, energy, hp, defence, attack, price);
		this.myCardList.add(card);
		return card;
	}


}
