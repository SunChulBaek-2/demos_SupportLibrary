package kr.pe.ssun.supportlibrary221demos.fragment.appcompat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-04-27.
 */
public class AppCompatWidgetFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_appcompat_widget, container, false);

		return rootView;
	}
}
