package action;

import card.Poker;
import card.Shuffle;

public class Actions {
	static int PokerIndex = 0;
	Shuffle shu;
	
	public Actions() {
		shu = new Shuffle();
		shu.createPoker();
		shu.ruffleCard();
		shu.display();
	}
	
	public Poker nextCard() {
		if (PokerIndex == 52) {
			shu.ruffleCard();
			PokerIndex = 0;
		} 
		System.out.println(PokerIndex);
		return shu.getPoker(++PokerIndex);
	}
	
	public Poker getCardCN() {
		return shu.getPoker(PokerIndex);
	}
}
