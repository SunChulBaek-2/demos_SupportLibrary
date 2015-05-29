package kr.pe.ssun.supportlibrary221demos.data;

import android.support.v4.app.Fragment;

import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatDialogFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatWidgetFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatPaletteFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.design.DesignAppBarLayoutFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.design.DesignFloatingActionButtonFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.recyclerview.RecyclerViewPositionFragment;
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
	// Revision 22.2.0
	DesignAppBarLAyout(Revision.REV_22_2_0, Library.V7_DESIGN, "AppBarLayout"),
	DesignFloatingActionButton(Revision.REV_22_2_0, Library.V7_DESIGN, "Floating Action Button"),

	// Revision 22.1.0
	SupportDrawableCompat(Revision.REV_22_1_0, Library.V4_SUPPORT, "DrawableCompat"),
	SupportPrebuiltInterpolators(Revision.REV_22_1_0, Library.V4_SUPPORT, "Prebuilt Interpolators"),
	SupportPathInterpolatorCompat(Revision.REV_22_1_0, Library.V4_SUPPORT, "PathInterpolatorCompat"),
	SupportSpace(Revision.REV_22_1_0, Library.V4_SUPPORT, "Space"),
	SupportNestedScrollView(Revision.REV_22_1_0, Library.V4_SUPPORT, "NestedScrollView"),
	AppCompatDelegate(Revision.REV_22_1_0, Library.V7_APPCOMPAT, "AppCompatDelegate"),
	AppCompatDialog(Revision.REV_22_1_0, Library.V7_APPCOMPAT, "AppCompatDialog"),
	AppCompatWidget(Revision.REV_22_1_0, Library.V7_APPCOMPAT, "AppCompat Widgets"),
	AppCompatPalette(Revision.REV_22_1_0, Library.V7_APPCOMPAT, "Palette"),
	RecyclerViewSortedList(Revision.REV_22_1_0, Library.V7_RECYCLERVIEW, "SortedList"),

	// Revision 22
	SupportResourceCompat(Revision.REV_22, Library.V4_SUPPORT, "ResourceCompat"),
	RecyclerViewPosition(Revision.REV_22, Library.V7_RECYCLERVIEW, "getLayoutPosition (), getAdapterPosition ()");

	private static int selected = -1;

	private Revision revision;
	private Library library;
	private String title;

	DemoCategories(Revision revision, Library library, String title) {
		this.revision = revision;
		this.library = library;
		this.title = title;
	}

	public Revision getRevision() {
		return this.revision;
	}

	public Library getLibrary() {
		return this.library;
	}

	public String getTitle() {
		return this.title;
	}

	public static void setSelected(int selected) {
		DemoCategories.selected = selected;
	}

	public static int getSelected() {
		return DemoCategories.selected;
	}

	@Override
	public String toString() {
		return this.title;
	}

	public Fragment createFragment() {
		Fragment fragment = null;

		// Revision 22.2.0
		if (this.equals(DesignAppBarLAyout)) {
			fragment = new DesignAppBarLayoutFragment();
		} else if (this.equals(DesignFloatingActionButton)) {
			fragment = new DesignFloatingActionButtonFragment();
		}
		// Revision 22.1.0
		else if (this.equals(SupportDrawableCompat)) {
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
		} else if (this.equals(RecyclerViewPosition)) {
			fragment = new RecyclerViewPositionFragment();
		}

		return fragment;
	}
}
