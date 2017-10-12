package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	

	public HandPoker() {
		this.setHS(new HandScorePoker());

	}

	@Override
	public HandScore ScoreHand() {

		Collections.sort(super.getCards());
		if (isRoyalFlush()) {
			
		} else if (isStraightFlush()) {
			
		} else if (isFourOfAKind()) {
			
		} else if (isFullHouse()) {
			
		} else if (isFlush()) {
			
		} else if (isThreeOfAKind()) {
			
		} else if (isTwoPair()) {
			
		} else if (isPair()) {
			
		} else {
			
		}

		return null;
	}

	public boolean isRoyalFlush() {
		boolean bIsRoyalFlush = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();
		
		if (this.isStraightFlush() && super.getCards().get(eCardNo.FIFTH.getiCardNo()).geteRank() == eRank.ACE) {
			bIsRoyalFlush = true;
			HS.seteHandStrength(eHandStrength.RoyalFlush);
			this.setHS(HS);
		}
		return bIsRoyalFlush;
	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (this.isFlush() && this.isStraight()) {
			
			HS.seteHandStrength(eHandStrength.StraightFlush);
			bisStraightFlush = true;
			this.setHS(HS);
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
		HandScorePoker HS = (HandScorePoker) super.getHS();
		if (this.isTwoPair() && this.isThreeOfAKind()) {
			HS.seteHandStrength(eHandStrength.FullHouse);
			bisFullHouse = true;
			this.setHS(HS);
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

		if (iSuitCnt == iCardCnt) {
			bisFlush = true;

		} else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = false;
		int idiff = 0;
		int i = 0;
		HandScorePoker HS = (HandScorePoker) super.getHS();
		if (this.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank()== eRank.ACE
				|| super.getCards().get(eCardNo.FIFTH.getiCardNo()).geteRank()== eRank.ACE) {
			i=1;
		}
			for (; i < this.getCards().size() - 1; i++) {
				idiff = (this.getCards().get(i).geteRank().getiRankNbr()
						- this.getCards().get(i + 1).geteRank().getiRankNbr());
				if (idiff == -1) {
					bisStraight = true;
					HS.seteHandStrength(eHandStrength.Straight);
					this.setHS(HS);
				}
			}
		return bisStraight;
}

	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();
		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank().getiRankNbr() == super.getCards()
				.get(eCardNo.THIRD.getiCardNo()).geteRank().getiRankNbr()) {
			
			bisThreeOfAKind = true;
			HS.seteHandStrength(eHandStrength.ThreeOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			
		} else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank().getiRankNbr() == super.getCards()
				.get(eCardNo.FOURTH.getiCardNo()).geteRank().getiRankNbr()) {
			
			HS.seteHandStrength(eHandStrength.ThreeOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setKickers(kickers);

		} else if (super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank().getiRankNbr() == super.getCards()
				.get(eCardNo.FIFTH.getiCardNo()).geteRank().getiRankNbr()) {
			
			HS.seteHandStrength(eHandStrength.ThreeOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setKickers(kickers);

		}
		this.setHS(HS);
		return bisThreeOfAKind;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank().getiRankNbr() == super.getCards()
				.get(eCardNo.SECOND.getiCardNo()).geteRank().getiRankNbr()
				&& super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank().getiRankNbr() == super.getCards()
						.get(eCardNo.FOURTH.getiCardNo()).geteRank().getiRankNbr()) {
			
			bisTwoPair = true;
			HS.seteHandStrength(eHandStrength.TwoPair);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);

		} else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank().getiRankNbr() == super.getCards()
				.get(eCardNo.THIRD.getiCardNo()).geteRank().getiRankNbr()
				&& super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank().getiRankNbr() == super.getCards()
						.get(eCardNo.FIFTH.getiCardNo()).geteRank().getiRankNbr()) {
			
			bisTwoPair = true;
			HS.seteHandStrength(eHandStrength.TwoPair);
			HS.setHiCard(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			HS.setLoCard(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setKickers(kickers);

		} else if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank().getiRankNbr() == super.getCards()
				.get(eCardNo.SECOND.getiCardNo()).geteRank().getiRankNbr()
				&& super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank().getiRankNbr() == super.getCards()
						.get(eCardNo.FIFTH.getiCardNo()).geteRank().getiRankNbr()) {
			
			bisTwoPair = true;
			HS.seteHandStrength(eHandStrength.TwoPair);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			HS.setKickers(kickers);

		}
		this.setHS(HS);
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();
		
		Card first = super.getCards().get(eCardNo.FIRST.getiCardNo());
		Card second = super.getCards().get(eCardNo.SECOND.getiCardNo());
		Card third = super.getCards().get(eCardNo.THIRD.getiCardNo());
		Card fourth = super.getCards().get(eCardNo.FOURTH.getiCardNo());
		Card fifth = super.getCards().get(eCardNo.FIFTH.getiCardNo());
		
		if (first.geteRank().getiRankNbr() == second.geteRank().getiRankNbr()) {
			bisPair = true;
			HS.seteHandStrength(eHandStrength.Pair);
			HS.setHiCard(first);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(third);
			HS.setKickers(kickers);
		}else if (second.geteRank().getiRankNbr() == third.geteRank().getiRankNbr()) {
			bisPair = true;
			HS.seteHandStrength(eHandStrength.Pair);
			HS.setHiCard(second);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(first);
			HS.setKickers(kickers);
		}else if (third.geteRank().getiRankNbr() == fourth.geteRank().getiRankNbr()) {
			bisPair = true;
			HS.seteHandStrength(eHandStrength.Pair);
			HS.setHiCard(third);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(first);
			HS.setKickers(kickers);
		}else if (fourth.geteRank().getiRankNbr() == fifth.geteRank().getiRankNbr()){
			bisPair = true;
			HS.seteHandStrength(eHandStrength.Pair);
			HS.setHiCard(fourth);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(first);
			HS.setKickers(kickers);
		}
		this.setHS(HS);
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();
		
		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank().getiRankNbr() != super.getCards()
				.get(eCardNo.SECOND.getiCardNo()).geteRank().getiRankNbr()
				&& super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank().getiRankNbr() != super.getCards()
						.get(eCardNo.THIRD.getiCardNo()).geteRank().getiRankNbr()
				&& super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank().getiRankNbr() != super.getCards()
						.get(eCardNo.FOURTH.getiCardNo()).geteRank().getiRankNbr()
				&& super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank().getiRankNbr() != super.getCards()
						.get(eCardNo.FIFTH.getiCardNo()).geteRank().getiRankNbr()) {
			HS.seteHandStrength(eHandStrength.HighCard);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			bisHighCard = true;
			this.setHS(HS);
		}
		return bisHighCard;
	}

}
