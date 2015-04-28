package kr.pe.ssun.supportlibrary221demos;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatDialogFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatWidgetFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.palette.PaletteFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.recyclerview.RecyclerViewFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.supportv4.SupportV4DrawableCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.supportv4.SupportV4PathInterpolatorCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.supportv4.SupportV4PrebuiltInterpolatorsFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.supportv4.SupportV4SpaceFragment;

/**
 * Created by x1210x on 2015-04-24.
 */
public enum DemoCategories {
	// Support V4
	SupportV4DrawableCompat("Support V4 : DrawableCompat"),
	SupportV4ColorUtils("Support V4 : ColorUtils (not implemented yet)"),
	SupportV4PrebuiltInterpolators("Support V4 : Prebuilt Interpolators"),
	SupportV4PathInterpolatorCompat("Support V4 : PathInterpolatorCompat"),
	SupportV4Space("Support V4 : Space"),
	// AppCompat
	AppCompatDelegate("AppCompat : AppCompatDelegate"),
	AppCompatDialog("AppCompat : AppCompatDialog"),
	AppCompatWidget("AppCompat : AppCompat Widgets"),
	// LeanBack : for Android TV apps
	//LeanBack("LeanBack", null),
	// RecyclerView
	RecyclerView("RecyclerView"),
	// Palette
	Palette("Palette"),
	// RenderScript
	RenderScript("RenderScript (not implemented yet)");

	private String title;

	DemoCategories(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return this.title;
	}

	public Fragment createFragment() {
		Fragment fragment = null;

		if (this.equals(SupportV4DrawableCompat)) {
			fragment = new SupportV4DrawableCompatFragment();
		} else if (this.equals(SupportV4PrebuiltInterpolators)) {
			fragment = new SupportV4PrebuiltInterpolatorsFragment();
		} else if (this.equals(SupportV4PathInterpolatorCompat)) {
			fragment = new SupportV4PathInterpolatorCompatFragment();
		} else if (this.equals(SupportV4Space)) {
			fragment = new SupportV4SpaceFragment();
		} else if (this.equals(AppCompatDelegate)) {
			fragment = null;
		} else if (this.equals(AppCompatDialog)) {
			fragment = new AppCompatDialogFragment();
		} else if (this.equals(AppCompatWidget)) {
			fragment = new AppCompatWidgetFragment();
		} else if (this.equals(RecyclerView)) {
			fragment = new RecyclerViewFragment();
		} else if (this.equals(Palette)) {
			fragment = new PaletteFragment();
		}

		return fragment;
	}
}
