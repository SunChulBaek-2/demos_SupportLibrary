package kr.pe.ssun.supportlibrary221demos.fragment.appcompat;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-04-28.
 */
public class AppCompatPaletteFragment extends Fragment implements TabLayout.OnTabSelectedListener {
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

	private TabLayout tabLayout;
	private ViewPager pager;
	private PagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_appcompat_palette, container, false);

		tabLayout = (TabLayout) rootView.findViewById(R.id.tabHost);
		pager = (ViewPager)rootView.findViewById(R.id.vpPager);

		adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				AppCompatPaletteSubFragment fragment = new AppCompatPaletteSubFragment();
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
		};

		tabLayout.setBackgroundColor(Color.rgb(138, 0, 0));
		tabLayout.setOnTabSelectedListener(this);
		tabLayout.setTabsFromPagerAdapter(adapter);

		pager.setAdapter(adapter);
		pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout) {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				tabLayout.getTabAt(position).select();

				List<Fragment> fragments = getChildFragmentManager().getFragments();
				AppCompatPaletteSubFragment fragment = (AppCompatPaletteSubFragment) fragments.get(position);

				tabLayout.setBackgroundColor(fragment.getRGB());
				tabLayout.setTabTextColors(fragment.getBodyTextColor(), fragment.getTitleTextColor());
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

		return rootView;
	}

	@Override
	public void onTabSelected(TabLayout.Tab tab) {
		pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(TabLayout.Tab tab) {

	}

	@Override
	public void onTabReselected(TabLayout.Tab tab) {

	}
}
