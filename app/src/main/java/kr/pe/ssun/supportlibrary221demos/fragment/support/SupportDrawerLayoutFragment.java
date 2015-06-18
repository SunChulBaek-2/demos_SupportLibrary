package kr.pe.ssun.supportlibrary221demos.fragment.support;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-06-18.
 */
public class SupportDrawerLayoutFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_support_drawer_layout, container, false);

		final DrawerLayout drawer = (DrawerLayout)rootView.findViewById(R.id.drawer);
		final View rlDrawer = rootView.findViewById(R.id.rlDrawer);
		Button btnOpenDrawer = (Button) rootView.findViewById(R.id.btnOpenDrawer);

		btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				drawer.openDrawer(rlDrawer);
			}
		});

		return rootView;
	}
}
