package kr.pe.ssun.supportlibrary221demos.fragment.support;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-06-17.
 */
public class SupportFragmentTransitionFragmentB extends Fragment {
	public static final String TAG = SupportFragmentTransitionFragmentB.class.getCanonicalName();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_support_fragment_transition_b, container, false);

		Button btnExitB = (Button)rootView.findViewById(R.id.exitB);
		final TextView textView = (TextView)rootView.findViewById(R.id.textView);

		btnExitB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Fragment fragment = new SupportFragmentTransitionFragment();
				FragmentTransaction ft = getFragmentManager().beginTransaction()
						.replace(R.id.container, fragment, TAG);

				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					setSharedElementReturnTransition(new ChangeImageTransform());
					setExitTransition(new Explode());

					fragment.setSharedElementEnterTransition(new ChangeImageTransform());
					fragment.setEnterTransition(new Explode());

					ft.addSharedElement(textView, "sharedElement");
				}
				ft.commit();
			}
		});

		return rootView;
	}
}
