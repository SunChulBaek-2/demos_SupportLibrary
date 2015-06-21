package kr.pe.ssun.supportlibrary221demos.fragment.support;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;
import kr.pe.ssun.supportlibrary221demos.fragment.dummy.DummyTextFragment;

/**
 * Created by x1210x on 15. 6. 21..
 */
public class SupportPagerTabStripFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_support_pager_tab_strip, container, false);

		ViewPager viewPager = (ViewPager)rootView.findViewById(R.id.viewPager);
		viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				return new DummyTextFragment();
			}

			@Override
			public int getCount() {
				return 5;
			}

			@Override
			public CharSequence getPageTitle (int position) {
				return "Page "+position;
			}
		});

		return rootView;
	}
}
