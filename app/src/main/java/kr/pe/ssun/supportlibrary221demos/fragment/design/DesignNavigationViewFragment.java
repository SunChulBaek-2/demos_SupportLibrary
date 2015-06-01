package kr.pe.ssun.supportlibrary221demos.fragment.design;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-06-01.
 */
public class DesignNavigationViewFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_design_navigation_view, container, false);

		NavigationView navigation = (NavigationView)rootView.findViewById(R.id.navigation);
		navigation.inflateHeaderView(R.layout.header_navigation_view);

		return rootView;
	}
}
