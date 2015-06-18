package kr.pe.ssun.supportlibrary221demos.fragment.support;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-06-18.
 */
public class SupportSlidingPaneLayoutFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_support_sliding_pane_layout, container, false);

		final SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout)rootView.findViewById(R.id.slidingpane);
		final Button btnOpenLeftPane = (Button)rootView.findViewById(R.id.btnOpenLeftPane);

		slidingPaneLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
			@Override
			public void onPanelSlide(View panel, float slideOffset) {

			}

			@Override
			public void onPanelOpened(View panel) {
				btnOpenLeftPane.setText("CLOSE LEFT PANE");
				btnOpenLeftPane.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						slidingPaneLayout.closePane();
					}
				});
			}

			@Override
			public void onPanelClosed(View panel) {
				btnOpenLeftPane.setText("OPEN LEFT PANE");
				btnOpenLeftPane.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						slidingPaneLayout.openPane();
					}
				});
			}
		});

		btnOpenLeftPane.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				slidingPaneLayout.openPane();
			}
		});

		return rootView;
	}
}
