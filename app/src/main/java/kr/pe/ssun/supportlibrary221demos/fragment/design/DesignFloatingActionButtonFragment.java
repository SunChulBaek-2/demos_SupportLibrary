package kr.pe.ssun.supportlibrary221demos.fragment.design;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-05-29.
 */
public class DesignFloatingActionButtonFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_design_floating_action_button, container, false);

		Button btnShowSnackBar = (Button)rootView.findViewById(R.id.btnShowSnackBar);
		FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);

		CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams)fab.getLayoutParams();
		params.setBehavior(new FloatingActionButton.Behavior());
		fab.setLayoutParams(params);

		btnShowSnackBar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Snackbar.make(rootView, "FloatingActionButton.Behavior lift up the FAB.", Snackbar.LENGTH_SHORT).show();
			}
		});

		return rootView;
	}
}
