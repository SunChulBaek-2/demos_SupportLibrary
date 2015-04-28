package kr.pe.ssun.supportlibrary221demos.fragment.palette;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-04-28.
 */
public class PaletteSubFragment extends Fragment {
	private int resId;

	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle = getArguments();
		if (bundle != null) {
			int resId = bundle.getInt("resId");
			if(resId > 0) {
				this.resId = resId;
			}
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_sub_palette, container, false);
		ImageView ivImage = (ImageView)rootView.findViewById(R.id.ivImage);

		if (this.resId > 0)
			ivImage.setImageResource(this.resId);

		return rootView;
	}
}
