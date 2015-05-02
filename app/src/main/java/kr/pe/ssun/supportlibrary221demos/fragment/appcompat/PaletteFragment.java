package kr.pe.ssun.supportlibrary221demos.fragment.appcompat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-04-28.
 */
public class PaletteFragment extends Fragment implements MaterialTabListener {
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

	private MaterialTabHost tabHost;
	private ViewPager pager;
	private PagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_palette, container, false);

		tabHost = (MaterialTabHost) rootView.findViewById(R.id.tabHost);
		pager = (ViewPager)rootView.findViewById(R.id.vpPager);

		adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
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
		};
		pager.setAdapter(adapter);

		pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				tabHost.setSelectedNavigationItem(position);

				List<Fragment> fragments = getChildFragmentManager().getFragments();
				PaletteSubFragment fragment = (PaletteSubFragment) fragments.get(position);

				tabHost.setPrimaryColor(fragment.getRGB());
				tabHost.setTextColor(fragment.getTitleTextColor());
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

		// insert all tabs from pagerAdapter data
		for (int i = 0; i < adapter.getCount(); i++) {
			tabHost.addTab(
					tabHost.newTab()
							.setText(adapter.getPageTitle(i))
							.setTabListener(this)
			);

		}

		return rootView;
	}

	@Override
	public void onTabSelected(MaterialTab materialTab) {
		pager.setCurrentItem(materialTab.getPosition());
	}

	@Override
	public void onTabReselected(MaterialTab materialTab) {

	}

	@Override
	public void onTabUnselected(MaterialTab materialTab) {

	}
}
