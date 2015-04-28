package kr.pe.ssun.supportlibrary221demos.fragment.palette;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.AppCompatTextView;
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
	private Palette palette;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle = getArguments();
		if (bundle != null) {
			int resId = bundle.getInt("resId");
			if (resId > 0) {
				this.resId = resId;
			}
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_sub_palette, container, false);

		AppCompatTextView actvVibrantTitle = (AppCompatTextView) rootView.findViewById(R.id.actvVibrantTitle);
		AppCompatTextView actvVibrantBody = (AppCompatTextView) rootView.findViewById(R.id.actvVibrantBody);
		AppCompatTextView actvVibrantDarkTitle = (AppCompatTextView) rootView.findViewById(R.id.actvVibrantDarkTitle);
		AppCompatTextView actvVibrantDarkBody = (AppCompatTextView) rootView.findViewById(R.id.actvVibrantDarkBody);
		AppCompatTextView actvVibrantLightTitle = (AppCompatTextView) rootView.findViewById(R.id.actvVibrantLightTitle);
		AppCompatTextView actvVibrantLightBody = (AppCompatTextView) rootView.findViewById(R.id.actvVibrantLightBody);
		AppCompatTextView actvMutedTitle = (AppCompatTextView) rootView.findViewById(R.id.actvMutedTitle);
		AppCompatTextView actvMutedBody = (AppCompatTextView) rootView.findViewById(R.id.actvMutedBody);
		AppCompatTextView actvMutedDarkTitle = (AppCompatTextView) rootView.findViewById(R.id.actvMutedDarkTitle);
		AppCompatTextView actvMutedDarkBody = (AppCompatTextView) rootView.findViewById(R.id.actvMutedDarkBody);
		AppCompatTextView actvMutedLightTitle = (AppCompatTextView) rootView.findViewById(R.id.actvMutedLightTitle);
		AppCompatTextView actvMutedLightBody = (AppCompatTextView) rootView.findViewById(R.id.actvMutedLightBody);

		ImageView ivImage = (ImageView) rootView.findViewById(R.id.ivImage);

		if (this.resId > 0) {
			ivImage.setImageResource(this.resId);

			palette = new Palette.Builder(((BitmapDrawable) ivImage.getDrawable()).getBitmap()).generate();

			if (palette.getVibrantSwatch() != null) {
				actvVibrantTitle.setBackgroundColor(palette.getVibrantSwatch().getRgb());
				actvVibrantTitle.setTextColor(palette.getVibrantSwatch().getTitleTextColor());
				actvVibrantBody.setBackgroundColor(palette.getVibrantSwatch().getRgb());
				actvVibrantBody.setTextColor(palette.getVibrantSwatch().getBodyTextColor());
			}

			if (palette.getDarkVibrantSwatch() != null) {
				actvVibrantDarkTitle.setBackgroundColor(palette.getDarkVibrantSwatch().getRgb());
				actvVibrantDarkTitle.setTextColor(palette.getDarkVibrantSwatch().getTitleTextColor());
				actvVibrantDarkBody.setBackgroundColor(palette.getDarkVibrantSwatch().getRgb());
				actvVibrantDarkBody.setTextColor(palette.getDarkVibrantSwatch().getBodyTextColor());
			}

			if (palette.getLightVibrantSwatch() != null) {
				actvVibrantLightTitle.setBackgroundColor(palette.getLightVibrantSwatch().getRgb());
				actvVibrantLightTitle.setTextColor(palette.getLightVibrantSwatch().getTitleTextColor());
				actvVibrantLightBody.setBackgroundColor(palette.getLightVibrantSwatch().getRgb());
				actvVibrantLightBody.setTextColor(palette.getLightVibrantSwatch().getBodyTextColor());
			}

			if (palette.getMutedSwatch() != null) {
				actvMutedTitle.setBackgroundColor(palette.getMutedSwatch().getRgb());
				actvMutedTitle.setTextColor(palette.getMutedSwatch().getTitleTextColor());
				actvMutedBody.setBackgroundColor(palette.getMutedSwatch().getRgb());
				actvMutedBody.setTextColor(palette.getMutedSwatch().getBodyTextColor());
			}

			if (palette.getDarkMutedSwatch() != null) {
				actvMutedDarkTitle.setBackgroundColor(palette.getDarkMutedSwatch().getRgb());
				actvMutedDarkTitle.setTextColor(palette.getDarkMutedSwatch().getTitleTextColor());
				actvMutedDarkBody.setBackgroundColor(palette.getDarkMutedSwatch().getRgb());
				actvMutedDarkBody.setTextColor(palette.getDarkMutedSwatch().getBodyTextColor());
			}

			if (palette.getLightMutedSwatch() != null) {
				actvMutedLightTitle.setBackgroundColor(palette.getLightMutedSwatch().getRgb());
				actvMutedLightTitle.setTextColor(palette.getLightMutedSwatch().getTitleTextColor());
				actvMutedLightBody.setBackgroundColor(palette.getLightMutedSwatch().getRgb());
				actvMutedLightBody.setTextColor(palette.getLightMutedSwatch().getBodyTextColor());
			}
		}

		return rootView;
	}
}
