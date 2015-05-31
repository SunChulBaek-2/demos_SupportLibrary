package kr.pe.ssun.supportlibrary221demos.fragment.design;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-05-29.
 */
public class DesignCollapsingToolbarLayoutFragment extends Fragment {
	private CollapsingToolbarLayout toolbarLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_design_collapsing_toolbar_layout, container, false);

		toolbarLayout = (CollapsingToolbarLayout)rootView.findViewById(R.id.toolbarLayout);

		toolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.lightTextPrimary));
		toolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.lightTextPrimary));
		toolbarLayout.setTitle("Toolbar");

		return rootView;
	}
}
