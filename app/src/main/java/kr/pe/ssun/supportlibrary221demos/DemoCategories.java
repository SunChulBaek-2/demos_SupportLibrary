package kr.pe.ssun.supportlibrary221demos;

import android.support.v4.app.Fragment;

import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatDialogFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatWidgetFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatPaletteFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.recyclerview.RecyclerViewSortedListFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportDrawableCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportNestedScrollViewFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportPathInterpolatorCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportPrebuiltInterpolatorsFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportResourceCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportSpaceFragment;

/**
 * Created by x1210x on 2015-04-24.
 */
public enum DemoCategories {
	// Revision 22.1.0
	SupportDrawableCompat(Revision.REV_22_1_0, "v4 support : DrawableCompat"),
	SupportPrebuiltInterpolators(Revision.REV_22_1_0, "v4 support : Prebuilt Interpolators"),
	SupportPathInterpolatorCompat(Revision.REV_22_1_0, "v4 support : PathInterpolatorCompat"),
	SupportSpace(Revision.REV_22_1_0, "v4 support : Space"),
	SupportNestedScrollView(Revision.REV_22_1_0, "v4 support : NestedScrollView"),
	AppCompatDelegate(Revision.REV_22_1_0, "v7 appcompat : AppCompatDelegate"),
	AppCompatDialog(Revision.REV_22_1_0, "v7 appcompat : AppCompatDialog"),
	AppCompatWidget(Revision.REV_22_1_0, "v7 appcompat : AppCompat Widgets"),
	AppCompatPalette(Revision.REV_22_1_0, "v4 appcompat : Palette"),
	RecyclerViewSortedList(Revision.REV_22_1_0, "v7 recyclerview : SortedList"),

	// Revision 22
	SupportResourceCompat(Revision.REV_22, "v4 support : ResourceCompat");

	public static int selected = -1;
	private Revision revision;
	private String title;

	DemoCategories(Revision revision, String title) {
		this.revision = revision;
		this.title = title;
	}

	public Revision getRevision() {
		return this.revision;
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

		// Revision 22.1.0
		if (this.equals(SupportDrawableCompat)) {
			fragment = new SupportDrawableCompatFragment();
		} else if (this.equals(SupportPrebuiltInterpolators)) {
			fragment = new SupportPrebuiltInterpolatorsFragment();
		} else if (this.equals(SupportPathInterpolatorCompat)) {
			fragment = new SupportPathInterpolatorCompatFragment();
		} else if (this.equals(SupportSpace)) {
			fragment = new SupportSpaceFragment();
		} else if (this.equals(SupportNestedScrollView)) {
			fragment = new SupportNestedScrollViewFragment();
		} else if (this.equals(AppCompatDelegate)) {
			fragment = null;
		} else if (this.equals(AppCompatDialog)) {
			fragment = new AppCompatDialogFragment();
		} else if (this.equals(AppCompatWidget)) {
			fragment = new AppCompatWidgetFragment();
		} else if (this.equals(RecyclerViewSortedList)) {
			fragment = new RecyclerViewSortedListFragment();
		} else if (this.equals(AppCompatPalette)) {
			fragment = new AppCompatPaletteFragment();
		}
		// Revision 22
		else if (this.equals(SupportResourceCompat)) {
			fragment = new SupportResourceCompatFragment();
		}

		return fragment;
	}
}
