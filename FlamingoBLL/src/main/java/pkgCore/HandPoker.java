package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	@Override
	public HandScore ScoreHand() {
		// TODO : Implement this method... call each of the 'is' methods (isRoyalFlush,
		// etc) until
		// one of the hands is true, then score the hand
		Collections.sort(super.getCards());
		if (isRoyalFlush()) {
			
		} else if (isStraightFlush()) {

		}

		return null;
	}

	public boolean isRoyalFlush() {
		boolean bIsRoyalFlush = false;
		// TODO : Implement this method
		return bIsRoyalFlush;
	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;
		// TODO : Implement this method 
		if (isFlush()==true && isStraight()==true) {
			bisStraightFlush = true;
		}else {
			bisStraightFlush = false;
		}
		return bisStraightFlush;
	}

	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FOURTH.getiCardNo()).geteRank()) {

			HS.seteHandStrength(eHandStrength.FourOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisFourOfAKind = true;

		} else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.FourOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setKickers(kickers);
			bisFourOfAKind = true;
		}

		return bisFourOfAKind;
	}

	public boolean isFullHouse() {
		boolean bisFullHouse = false;
		// TODO : Implement this method
		if(isPair()==true && isThreeOfAKind()==true) {
			
		}
		return bisFullHouse;
	}

	public boolean isFlush() {
		boolean bisFlush = false;

		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt == iCardCnt)
			bisFlush = true;
		else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = false;
		// TODO : Implement this method
		int idiff = 0;

		for (int i = 0; i < this.getCards().size() - 1; i++) {
			idiff = (this.getCards().get(i).geteRank().getiRankNbr()
					- this.getCards().get(i + 1).geteRank().getiRankNbr());
			if (idiff != 1) {
				bisStraight = false;
			} else {
				bisStraight = true;
			}
		}
		return bisStraight;

	}

	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;
		// TODO : Implement this method
		if(super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank()==super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()) {
			
		}else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()==super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()) {
			
		}else if(super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()==super.getCards().get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			
		}
		return bisThreeOfAKind;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		// TODO : Implement this method
		if(super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank()==super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()
				&& super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()==super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()) {
			
		}else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()==super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()
				&& super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()==super.getCards().get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			
		}else if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank()==super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()
				&& super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()==super.getCards().get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			
		}
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
		// TODO : Implement this method
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = false;
		// TODO : Implement this method
		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank()!=super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()
				&& super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()!=super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()
				&&super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()!=super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()
				&& super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()!=super.getCards().get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			
		}
		return bisHighCard;
	}

}
