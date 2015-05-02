package kr.pe.ssun.supportlibrary221demos.fragment.support;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-04-24.
 */
public class SupportV4DrawableCompatFragment extends Fragment {
	private enum Tint {
		Normal("Normal", R.drawable.ic_launcher, null),
		SetTint("SetTint()", R.drawable.ic_launcher_tint, null),
		SetTintList("SetTintList()", R.drawable.ic_launcher_tint_list, null),
		SetTintModeAdd("SetTintMode(Add)", R.drawable.ic_launcher_tint_mode_add, PorterDuff.Mode.ADD),
		SetTintModeClear("SetTintMode(Clear)", R.drawable.ic_launcher_tint_mode_clear, PorterDuff.Mode.CLEAR),
		SetTintModeDarken("SetTintMode(Darken)", R.drawable.ic_launcher_tint_mode_darken, PorterDuff.Mode.DARKEN),
		SetTintModeDst("SetTintMode(Dst)", R.drawable.ic_launcher_tint_mode_dst, PorterDuff.Mode.DST),
		SetTintModeDstAtop("SetTintMode(DstAtop)", R.drawable.ic_launcher_tint_mode_dst_atop, PorterDuff.Mode.DST_ATOP),
		SetTintModeDstIn("SetTintMode(DstIn)", R.drawable.ic_launcher_tint_mode_dst_in, PorterDuff.Mode.DST_IN),
		SetTintModeDstOut("SetTintMode(DstOut)", R.drawable.ic_launcher_tint_mode_dst_out, PorterDuff.Mode.DST_OUT),
		SetTintModeDstOver("SetTintMode(DstOver)", R.drawable.ic_launcher_tint_mode_dst_over, PorterDuff.Mode.DST_OVER),
		SetTintModeLighten("SetTintMode(Lighten)", R.drawable.ic_launcher_tint_mode_lighten, PorterDuff.Mode.LIGHTEN),
		SetTintModeMultiply("SetTintMode(Multiply)", R.drawable.ic_launcher_tint_mode_multiply, PorterDuff.Mode.MULTIPLY),
		SetTintModeOverlay("SetTintMode(Overlay)", R.drawable.ic_launcher_tint_mode_overlay, PorterDuff.Mode.OVERLAY),
		SetTintModeScreen("SetTintMode(Screen)", R.drawable.ic_launcher_tint_mode_screen, PorterDuff.Mode.SCREEN),
		SetTintModeSrc("SetTintMode(Src)", R.drawable.ic_launcher_tint_mode_src, PorterDuff.Mode.SRC),
		SetTintModeSrcAtop("SetTintMode(SrcAtop)", R.drawable.ic_launcher_tint_mode_src_atop, PorterDuff.Mode.SRC_ATOP),
		SetTintModeSrcIn("SetTintMode(SrcIn)", R.drawable.ic_launcher_tint_mode_src_in, PorterDuff.Mode.SRC_IN),
		SetTintModeSrcOut("SetTintMode(SrcOut)", R.drawable.ic_launcher_tint_mode_src_out, PorterDuff.Mode.SRC_OUT),
		SetTintModeSrcOver("SetTintMode(SrcOver)", R.drawable.ic_launcher_tint_mode_src_over, PorterDuff.Mode.SRC_OVER),
		SetTintModeXor("SetTintMode(Xor)", R.drawable.ic_launcher_tint_mode_xor, PorterDuff.Mode.XOR);

		private String mDesc;
		private int resId;
		private PorterDuff.Mode mode;

		Tint(String desc, int resId, PorterDuff.Mode mode) {
			this.mDesc = desc;
			this.resId = resId;
			this.mode = mode;
		}

		public String getDescription() {
			return this.mDesc;
		}

		public int getResId() {
			return this.resId;
		}

		public PorterDuff.Mode getMode() {
			return this.mode;
		}
	}

	public SupportV4DrawableCompatFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_support_v4_drawable_compat, container, false);
		ListView lvTint = (ListView) rootView.findViewById(R.id.lvTint);
		lvTint.setAdapter(new ArrayAdapter<Tint>(getActivity(),
				R.layout.list_item_tint, Tint.values()) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view;
				if (convertView != null) {
					view = convertView;
				} else {
					view = getLayoutInflater(savedInstanceState).inflate(
							R.layout.list_item_tint, null);
				}

				final ImageView ibImage = (ImageView) view.findViewById(R.id.ivImage);
				AppCompatButton btnEnable = (AppCompatButton) view.findViewById(R.id.btnToggle);

				ibImage.setImageResource(getItem(position).getResId());
				btnEnable.setVisibility(View.GONE);
				btnEnable.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						ibImage.setEnabled(!ibImage.isEnabled());
					}
				});

				if (getItem(position).name().equals(Tint.Normal.name())) {

				} else if (getItem(position).name().equals(Tint.SetTint.name())) {
					Drawable drawable = ibImage.getDrawable();
					DrawableCompat.setTint(drawable, Color.RED);
				} else if (getItem(position).name().equals(Tint.SetTintList.name())) {
					Drawable drawable = ibImage.getDrawable();
					int[][] states = new int[][]{
							new int[]{android.R.attr.state_enabled}, // enabled
							new int[]{-android.R.attr.state_enabled}, // disabled
					};

					int[] colors = new int[]{
							Color.RED,
							Color.BLACK,
					};
					DrawableCompat.setTintList(drawable, new ColorStateList(states, colors));

					btnEnable.setVisibility(View.VISIBLE);
				} else { // setTintMode()
					Drawable drawable = ibImage.getDrawable();
					DrawableCompat.setTintMode(drawable, getItem(position).getMode());
					DrawableCompat.setTint(drawable, Color.RED);
				}

				TextView tvDesc = (TextView) view.findViewById(R.id.tvDesc);
				tvDesc.setText(getItem(position).getDescription());

				return view;
			}
		});

		return rootView;
	}
}
