package kr.pe.ssun.supportlibrary221demos;

import android.support.v4.app.Fragment;

import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatDialogFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatWidgetFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.PaletteFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.recyclerview.RecyclerViewFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportV4DrawableCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportV4NestedScrollViewFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportV4PathInterpolatorCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportV4PrebuiltInterpolatorsFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportV4SpaceFragment;

/**
 * Created by x1210x on 2015-04-24.
 */
public enum DemoCategories {
	// Support V4
	V4SupportDrawableCompat("v4 support : DrawableCompat"),
	//SupportV4ColorUtils("v4 support : ColorUtils (not implemented yet)"),
	V4SupportPrebuiltInterpolators("v4 support : Prebuilt Interpolators"),
	V4SupportPathInterpolatorCompat("v4 support : PathInterpolatorCompat"),
	V4SupportSpace("v4 support : Space"),
	V4SupportNestedScrollView("v4 support : NestedScrollView"),
	// AppCompat
	V7AppCompatDelegate("v7 appcompat : AppCompatDelegate"),
	V7AppCompatDialog("v7 appcompat : AppCompatDialog"),
	V7AppCompatWidget("v7 appcompat : AppCompat Widgets"),
	V7AppCompatPalette("v4 appcompat : Palette"),
	// V7RecyclerViewSortedList
	V7RecyclerViewSortedList("v7 recyclerview : SortedList");

	// RenderScript
	//RenderScript("RenderScript (not implemented yet)");

	public static int selected = -1;
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

		if (this.equals(V4SupportDrawableCompat)) {
			fragment = new SupportV4DrawableCompatFragment();
		} else if (this.equals(V4SupportPrebuiltInterpolators)) {
			fragment = new SupportV4PrebuiltInterpolatorsFragment();
		} else if (this.equals(V4SupportPathInterpolatorCompat)) {
			fragment = new SupportV4PathInterpolatorCompatFragment();
		} else if (this.equals(V4SupportSpace)) {
			fragment = new SupportV4SpaceFragment();
		} else if (this.equals(V4SupportNestedScrollView)) {
			fragment = new SupportV4NestedScrollViewFragment();
		} else if (this.equals(V7AppCompatDelegate)) {
			fragment = null;
		} else if (this.equals(V7AppCompatDialog)) {
			fragment = new AppCompatDialogFragment();
		} else if (this.equals(V7AppCompatWidget)) {
			fragment = new AppCompatWidgetFragment();
		} else if (this.equals(V7RecyclerViewSortedList)) {
			fragment = new RecyclerViewFragment();
		} else if (this.equals(V7AppCompatPalette)) {
			fragment = new PaletteFragment();
		}

		return fragment;
	}
}
