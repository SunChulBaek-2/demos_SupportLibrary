package kr.pe.ssun.supportlibrary221demos.fragment.palette;

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
public class PalettePaletteSubFragment extends Fragment {
	private int resId;
	private Palette palette;
	private Palette.Swatch swatch = new Palette.Swatch(0, 0);

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
		View rootView = inflater.inflate(R.layout.fragment_appcompat_palette_sub, container, false);

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

			Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
			Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
			Palette.Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
			Palette.Swatch mutedSwatch = palette.getMutedSwatch();
			Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
			Palette.Swatch lightMutedSwatch = palette.getLightMutedSwatch();

			if (vibrantSwatch != null) {
				actvVibrantTitle.setBackgroundColor(vibrantSwatch.getRgb());
				actvVibrantTitle.setTextColor(vibrantSwatch.getTitleTextColor());
				actvVibrantBody.setBackgroundColor(vibrantSwatch.getRgb());
				actvVibrantBody.setTextColor(vibrantSwatch.getBodyTextColor());
				if (vibrantSwatch.getPopulation() >= swatch.getPopulation()) {
					swatch = vibrantSwatch;
				}
			}

			if (darkVibrantSwatch != null) {
				actvVibrantDarkTitle.setBackgroundColor(darkVibrantSwatch.getRgb());
				actvVibrantDarkTitle.setTextColor(darkVibrantSwatch.getTitleTextColor());
				actvVibrantDarkBody.setBackgroundColor(darkVibrantSwatch.getRgb());
				actvVibrantDarkBody.setTextColor(darkVibrantSwatch.getBodyTextColor());
				if(darkVibrantSwatch.getPopulation() >= swatch.getPopulation()) {
					swatch = darkVibrantSwatch;
				}
			}

			if (lightVibrantSwatch != null) {
				actvVibrantLightTitle.setBackgroundColor(lightVibrantSwatch.getRgb());
				actvVibrantLightTitle.setTextColor(lightVibrantSwatch.getTitleTextColor());
				actvVibrantLightBody.setBackgroundColor(lightVibrantSwatch.getRgb());
				actvVibrantLightBody.setTextColor(lightVibrantSwatch.getBodyTextColor());
				if (lightVibrantSwatch.getPopulation() >= swatch.getPopulation()) {
					swatch = lightVibrantSwatch;
				}
			}

			if (mutedSwatch != null) {
				actvMutedTitle.setBackgroundColor(mutedSwatch.getRgb());
				actvMutedTitle.setTextColor(mutedSwatch.getTitleTextColor());
				actvMutedBody.setBackgroundColor(mutedSwatch.getRgb());
				actvMutedBody.setTextColor(mutedSwatch.getBodyTextColor());
				if (mutedSwatch.getPopulation() >= swatch.getPopulation()) {
					swatch = mutedSwatch;
				}
			}

			if (darkMutedSwatch != null) {
				actvMutedDarkTitle.setBackgroundColor(darkMutedSwatch.getRgb());
				actvMutedDarkTitle.setTextColor(darkMutedSwatch.getTitleTextColor());
				actvMutedDarkBody.setBackgroundColor(darkMutedSwatch.getRgb());
				actvMutedDarkBody.setTextColor(darkMutedSwatch.getBodyTextColor());
				if (darkMutedSwatch.getPopulation() >= swatch.getPopulation()) {
					swatch = darkMutedSwatch;
				}
			}

			if (lightMutedSwatch != null) {
				actvMutedLightTitle.setBackgroundColor(lightMutedSwatch.getRgb());
				actvMutedLightTitle.setTextColor(lightMutedSwatch.getTitleTextColor());
				actvMutedLightBody.setBackgroundColor(lightMutedSwatch.getRgb());
				actvMutedLightBody.setTextColor(lightMutedSwatch.getBodyTextColor());
				if (lightMutedSwatch.getPopulation() >= swatch.getPopulation()) {
					swatch = lightMutedSwatch;
				}
			}
		}

		return rootView;
	}

	public int getRGB() {
		return swatch.getRgb();
	}

	public int getBodyTextColor() {
		return swatch.getBodyTextColor();
	}

	public int getTitleTextColor() {
		return swatch.getTitleTextColor();
	}
}
