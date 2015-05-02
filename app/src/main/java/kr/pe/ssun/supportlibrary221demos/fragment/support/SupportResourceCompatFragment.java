package kr.pe.ssun.supportlibrary221demos.fragment.support;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 15. 5. 2..
 */
public class SupportResourceCompatFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_support_resource_compat, container, false);
		ImageView ivImage = (ImageView) rootView.findViewById(R.id.ivImage);

		Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_launcher, getActivity().getTheme());
		ivImage.setImageDrawable(drawable);

		return rootView;
	}
}
