package kr.pe.ssun.supportlibrary221demos.fragment.design;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-05-29.
 */
public class DesignAppBarLayoutFragment extends Fragment {
	private Toolbar toolbar;
	TabLayout tabLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_design_appbar_layout, container, false);

		toolbar = (Toolbar)rootView.findViewById(R.id.toolbar);
		tabLayout = (TabLayout)rootView.findViewById(R.id.tabLayout);

		toolbar.setTitle("Toolbar");

		tabLayout.addTab(tabLayout.newTab().setText("Enter Always"));
		tabLayout.addTab(tabLayout.newTab().setText("Enter Always Collapsed"));
		tabLayout.addTab(tabLayout.newTab().setText("Exit Until Collapsed"));

		tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				AppBarLayout.LayoutParams params1 = (AppBarLayout.LayoutParams)toolbar.getLayoutParams();
				AppBarLayout.LayoutParams params2 = (AppBarLayout.LayoutParams)tabLayout.getLayoutParams();

				if (tab.getPosition() == 0) {
					params1.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
					params2.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
					toolbar.setLayoutParams(params1);
					tabLayout.setLayoutParams(params2);
				} else if (tab.getPosition() == 1) {
					params1.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
					params2.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
					toolbar.setLayoutParams(params1);
					tabLayout.setLayoutParams(params2);
				} else if (tab.getPosition() == 2) {
					params1.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
					params2.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
					toolbar.setLayoutParams(params1);
					tabLayout.setLayoutParams(params2);
				}
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});

		return rootView;
	}
}
