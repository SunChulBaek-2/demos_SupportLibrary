package kr.pe.ssun.supportlibrary221demos.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.data.DemoCategories;
import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-04-24.
 */
public class MainFragment extends Fragment {
	public static final String TAG = MainFragment.class.toString();

	public interface MainFragmentListener {
		public boolean onItemClick(MenuItem menuItem);
	}

	private NavigationView nav;

	private MainFragmentListener listener;

	public MainFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

		nav = (NavigationView)rootView.findViewById(R.id.navigation);
		nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {
				setNavItemChecked(menuItem.getItemId());

				if (listener != null && menuItem.isEnabled() && menuItem.isCheckable()) {
					return listener.onItemClick(menuItem);
				}
				return false;
			}
		});
		setNavItemChecked(DemoCategories.getSelected());

		return rootView;
	}

	private void setNavItemChecked(int id) {
		for (int i=0; i<nav.getMenu().size(); i++) {
			MenuItem item = nav.getMenu().getItem(i);
			if (item.isEnabled() && item.isCheckable()) {
				item.setChecked(item.getItemId() == id);
			}
		}
	}

	@Override
	public void onAttach (Activity activity) {
		super.onAttach(activity);

		listener = (MainFragmentListener)activity;
	}
}
