package kr.pe.ssun.supportlibrary221demos;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by x1210x on 2015-04-24.
 */
public class SupportV4DrawableCompatFragment extends Fragment {
	public static final String TAG = SupportV4DrawableCompatFragment.class.toString();

	private enum Tint {
		Normal("Normal"),
		SetTint("SetTint(drawable, Color.argb(0x55, 0x55, 0, 0))"),
		SetTintList("SetTintList(drawable, new ColorStateList(states, colors))"),
		SetTintMode("Sorry, I don't understand");

		private String mDesc;

		Tint(String desc) {
			this.mDesc = desc;
		}

		public String getDescription() {
			return this.mDesc;
		}
	}

	public SupportV4DrawableCompatFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_support_v4, container, false);
		ListView lvTint = (ListView)rootView.findViewById(R.id.lvTint);
		lvTint.setAdapter(new ArrayAdapter<Tint>(getActivity(),
				R.layout.list_item_tint, Tint.values()){
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view;
				if(convertView != null) {
					view = convertView;
				} else {
					view = getLayoutInflater(savedInstanceState).inflate(
							R.layout.list_item_tint, null);
				}

				ImageView ibImage = (ImageView) view.findViewById(R.id.ivImage);
				ibImage.setImageResource(R.drawable.ic_launcher);
				Drawable drawable = ibImage.getDrawable();
				if(getItem(position).name().equals(Tint.Normal.name())) {
					// nothing to do
				} else if(getItem(position).name().equals(Tint.SetTint.name())) {
					DrawableCompat.setTint(drawable, Color.argb(0x55, 0x55, 0, 0));
				} else if(getItem(position).name().equals(Tint.SetTintList.name())) {
					int[][] states = new int[][] {
							new int[] {  android.R.attr.state_enabled }, // enabled
							new int[] { -android.R.attr.state_enabled }, // disabled
							new int[] { -android.R.attr.state_checked }, // unchecked
							new int[] {  android.R.attr.state_pressed }, // pressed
					};

					int[] colors = new int[] {
							Color.BLACK,
							Color.RED,
							Color.GREEN,
							Color.BLUE,
					};
					DrawableCompat.setTintList(drawable, new ColorStateList(states, colors));
				} else if(getItem(position).name().equals(Tint.SetTintMode.name())) {
					//DrawableCompat.setTintMode(drawable)
				}

				TextView tvDesc = (TextView)view.findViewById(R.id.tvDesc);
				tvDesc.setText(getItem(position).getDescription());

				return view;
			}
		});

		return rootView;
	}
}
