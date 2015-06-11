package kr.pe.ssun.supportlibrary221demos.fragment.appcompat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-06-11.
 */
public class AppCompatToolbarFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_appcompat_toolbar, container, false);

		Toolbar toolbar = (Toolbar)rootView.findViewById(R.id.toolbar);
		toolbar.setNavigationIcon(R.drawable.ic_action_navigation_menu);
		toolbar.setLogo(R.drawable.ic_launcher);
		toolbar.setTitleTextColor(R.color.darkTextPrimary);
		toolbar.setTitle("Title");
		toolbar.setSubtitleTextColor(R.color.darkTextSecondary);
		toolbar.setSubtitle("SubTitle");
		toolbar.inflateMenu(R.menu.menu_appbar_layout);

		return rootView;
	}
}
