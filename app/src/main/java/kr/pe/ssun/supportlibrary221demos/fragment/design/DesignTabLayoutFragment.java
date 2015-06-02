package kr.pe.ssun.supportlibrary221demos.fragment.design;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;
import kr.pe.ssun.supportlibrary221demos.fragment.dummy.DummyCustomViewFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.dummy.DummyIconFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.dummy.DummyTextFragment;

/**
 * Created by x1210x on 2015-06-02.
 */
public class DesignTabLayoutFragment extends Fragment {
	private final int TAB_COUNT=20;

	private TabLayout tabLayout;
	private ViewPager viewPager;
	private TabLayout tabLayout2;
	private ViewPager viewPager2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_design_tab_layout, container, false);

		tabLayout = (TabLayout)rootView.findViewById(R.id.tabLayout);
		viewPager = (ViewPager)rootView.findViewById(R.id.vpPager);
		tabLayout2 = (TabLayout)rootView.findViewById(R.id.tabLayout2);
		viewPager2 = (ViewPager)rootView.findViewById(R.id.vpPager2);

		// fixed mode
		tabLayout.addTab(tabLayout.newTab().setText("TEXT"));
		tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_content_add));
		tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_custom));
		for (int i=0; i<TAB_COUNT; i++) {
			tabLayout.addTab(tabLayout.newTab().setText("TEXT"+i));
		}

		tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				viewPager.setCurrentItem(tab.getPosition(), true);
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) { }

			@Override
			public void onTabReselected(TabLayout.Tab tab) { }
		});

		viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				if (position == 0) {
					return new DummyTextFragment();
				} else if (position == 1) {
					return new DummyIconFragment();
				} else if (position == 2) {
					return new DummyCustomViewFragment();
				}
				return new DummyTextFragment();
			}

			@Override
			public int getCount() {
				return 3+TAB_COUNT;
			}
		});
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				tabLayout.getTabAt(position).select();
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});


		// scrollable mode
		tabLayout2.setTabMode(TabLayout.MODE_SCROLLABLE);

		tabLayout2.addTab(tabLayout2.newTab().setText("TEXT"));
		tabLayout2.addTab(tabLayout2.newTab().setIcon(R.drawable.ic_action_content_add));
		tabLayout2.addTab(tabLayout2.newTab().setCustomView(R.layout.tab_custom));
		for (int i=0; i<TAB_COUNT; i++) {
			tabLayout2.addTab(tabLayout2.newTab().setText("TEXT"+i));
		}

		tabLayout2.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				viewPager2.setCurrentItem(tab.getPosition(), true);
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) { }

			@Override
			public void onTabReselected(TabLayout.Tab tab) { }
		});

		viewPager2.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				if (position == 0) {
					return new DummyTextFragment();
				} else if (position == 1) {
					return new DummyIconFragment();
				} else if (position == 2) {
					return new DummyCustomViewFragment();
				}
				return new DummyTextFragment();
			}

			@Override
			public int getCount() {
				return 3+TAB_COUNT;
			}
		});
		viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				tabLayout2.getTabAt(position).select();
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

		return rootView;
	}
}
