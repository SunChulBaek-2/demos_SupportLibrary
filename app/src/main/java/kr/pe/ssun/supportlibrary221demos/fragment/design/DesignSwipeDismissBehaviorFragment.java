package kr.pe.ssun.supportlibrary221demos.fragment.design;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-05-29.
 */
public class DesignSwipeDismissBehaviorFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_design_swipe_dismiss_behavior, container, false);

		Button button = (Button)rootView.findViewById(R.id.btnShowSnackBar);

		SwipeDismissBehavior behavior = new SwipeDismissBehavior();

		CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams)button.getLayoutParams();
		params.setBehavior(behavior);

		button.setLayoutParams(params);

		return rootView;
	}
}
