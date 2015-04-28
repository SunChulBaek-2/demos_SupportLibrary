package kr.pe.ssun.supportlibrary221demos.fragment.palette;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-04-28.
 */
public class PaletteFragment extends Fragment {
	private static final int SIZE = 3;
	private static SparseIntArray RESOURCES = new SparseIntArray();

	static {
		RESOURCES.put(0, R.drawable.chrysanthemum);
		RESOURCES.put(1, R.drawable.desert);
		RESOURCES.put(2, R.drawable.tulips);
	}

	private final String[] TITLES = {
			"chrysanthemum",
			"desert",
			"tulip"
	};

	private PagerSlidingTabStrip tabs;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_palette, container, false);

		tabs = (PagerSlidingTabStrip)rootView.findViewById(R.id.tabs);
		ViewPager pager = (ViewPager)rootView.findViewById(R.id.vpPager);

		tabs.setBackgroundResource(android.R.color.holo_blue_dark);
		tabs.setIndicatorColor(Color.WHITE);

		pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				PaletteSubFragment fragment = new PaletteSubFragment();
				Bundle bundle = new Bundle();
				bundle.putInt("resId", RESOURCES.get(position));
				fragment.setArguments(bundle);

				return fragment;
			}

			@Override
			public CharSequence getPageTitle(int position) {
				return TITLES[position];
			}

			@Override
			public int getCount() {
				return SIZE;
			}
		});
		tabs.setViewPager(pager);

		return rootView;
	}
}
