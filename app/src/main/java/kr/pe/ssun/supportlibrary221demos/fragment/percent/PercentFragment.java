package kr.pe.ssun.supportlibrary221demos.fragment.percent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015. 8. 30..
 */
public class PercentFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_percent_relative_layout, container, false);

		return rootView;
	}
}
