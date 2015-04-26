package kr.pe.ssun.supportlibrary221demos.supportv4;

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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import kr.pe.ssun.supportlibrary221demos.R;

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
		final View rootView = inflater.inflate(R.layout.fragment_support_v4_drawable_compat, container, false);
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

                          final ImageButton ibImage = (ImageButton) view.findViewById(R.id.ivImage);
                          Button btnEnable = (Button)view.findViewById(R.id.btnToggle);

                          btnEnable.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                              ibImage.setEnabled(!ibImage.isEnabled());
                            }
                          });

				if(getItem(position).name().equals(Tint.Normal.name())) {
                                  ibImage.setImageResource(R.drawable.ic_launcher);
				} else if(getItem(position).name().equals(Tint.SetTint.name())) {
                                  ibImage.setImageResource(R.drawable.ic_launcher_tint);
                                  Drawable drawable = ibImage.getDrawable();
					DrawableCompat.setTint(drawable, Color.argb(0x55, 0x55, 0, 0));
				} else if(getItem(position).name().equals(Tint.SetTintList.name())) {
                                  ibImage.setImageResource(R.drawable.ic_launcher_tint_list);
                                  Drawable drawable = ibImage.getDrawable();
					int[][] states = new int[][] {
							new int[] {  android.R.attr.state_enabled }, // enabled
							new int[] { -android.R.attr.state_enabled }, // disabled
					};

					int[] colors = new int[] {
							Color.RED,
							Color.BLACK,
					};
					DrawableCompat.setTintList(drawable, new ColorStateList(states, colors));

                                  btnEnable.setVisibility(View.VISIBLE);
				} else if(getItem(position).name().equals(Tint.SetTintMode.name())) {
                                  ibImage.setImageResource(R.drawable.ic_launcher_tint_mode);
				}

				TextView tvDesc = (TextView)view.findViewById(R.id.tvDesc);
				tvDesc.setText(getItem(position).getDescription());

				return view;
			}
		});

		return rootView;
	}
}
