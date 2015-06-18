package kr.pe.ssun.supportlibrary221demos.fragment.card;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-06-17.
 */
public class CardViewFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_card_view, container, false);

		CardView card1 = (CardView)rootView.findViewById(R.id.card1);
		CardView card2 = (CardView)rootView.findViewById(R.id.card2);
		CardView card3 = (CardView)rootView.findViewById(R.id.card3);
		CardView card4 = (CardView)rootView.findViewById(R.id.card4);
		CardView card5 = (CardView)rootView.findViewById(R.id.card5);

		// card 1
		card1.setCardElevation(10f);
		card1.setRadius(10f);
		card1.setCardBackgroundColor(getResources().getColor(R.color.pink100));

		// card 2
		card2.setCardElevation(20f);
		card2.setRadius(20f);

		// card 3
		card3.setCardElevation(30f);
		card3.setRadius(30f);

		// card 4
		card4.setCardElevation(30f);
		card4.setRadius(30f);
		card4.setUseCompatPadding(true);

		// card 5
		card5.setCardElevation(30f);
		card5.setRadius(30f);
		card5.setPreventCornerOverlap(true);

		setCardViewTitle(card1, "Card 1");
		setCardViewTitle(card2, "Card 2");
		setCardViewTitle(card3, "Card 3");
		setCardViewTitle(card4, "Card 3-2");
		setCardViewTitle(card5, "Card 3-3");

		setCardViewDescription(card1, "elevation=10\nradius=10\nbackgroundColor=pink100");
		setCardViewDescription(card2, "elevation=20\nradius=20");
		setCardViewDescription(card3, "elevation=30\nradius=30");
		setCardViewDescription(card4, "elevation=30\nradius=30\nsetUseCompatPadding=true");
		setCardViewDescription(card5, "elevation=30\nradius=30\nsetPreventCornerOverlap=true");

		return rootView;
	}

	private void setCardViewTitle(CardView card, String title) {
		TextView tvTitle = (TextView)card.findViewById(R.id.tvPrimaryText);
		tvTitle.setText(title);
	}

	private void setCardViewSubTitle(CardView card, String title) {
		TextView tvTitle = (TextView)card.findViewById(R.id.tvSubText);
		tvTitle.setText(title);
	}

	private void setCardViewDescription(CardView card, String desc) {
		TextView tvTitle = (TextView)card.findViewById(R.id.tvSupportingText);
		tvTitle.setText(desc);
	}
}
