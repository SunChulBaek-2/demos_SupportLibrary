package kr.pe.ssun.supportlibrary221demos.data;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

import kr.pe.ssun.supportlibrary221demos.R;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatDialogFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatSwitchCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatToolbarFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.appcompat.AppCompatWidgetFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.card.CardViewFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.palette.PalettePaletteFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.design.DesignAppBarLayoutFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.design.DesignCollapsingToolbarLayoutFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.design.DesignFloatingActionButtonFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.design.DesignNavigationViewFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.design.DesignSwipeDismissBehaviorFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.design.DesignTabLayoutFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.design.DesignTextInputLayoutFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.recyclerview.RecyclerViewFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.recyclerview.RecyclerViewPositionFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.recyclerview.RecyclerViewSortedListFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportDrawableCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportDrawerLayoutFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportFragmentTransitionFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportNestedScrollViewFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportPathInterpolatorCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportPrebuiltInterpolatorsFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportResourceCompatFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportSlidingPaneLayoutFragment;
import kr.pe.ssun.supportlibrary221demos.fragment.support.SupportSpaceFragment;

/**
 * Created by x1210x on 2015-04-24.
 */
public enum DemoCategories {
	// Revision 22.2.0
	DesignAppBarLayout(Revision.REV_22_2_0, Library.V7_DESIGN, R.string.action_design_appbar_layout),
	DesignTabLayout(Revision.REV_22_2_0, Library.V7_DESIGN, R.string.action_design_tab_layout),
	DesignNavigationView(Revision.REV_22_2_0, Library.V7_DESIGN, R.string.action_design_navigation_view),
	DesignFloatingActionButton(Revision.REV_22_2_0, Library.V7_DESIGN, R.string.action_design_floating_action_button),
	DesignSwipeDismissBehavior(Revision.REV_22_2_0, Library.V7_DESIGN, R.string.action_design_swipe_dismiss_behavior),
	DesignTextInputLayout(Revision.REV_22_2_0, Library.V7_DESIGN, R.string.action_design_text_input_layout),
	DesignCollapsingToolbarLayout(Revision.REV_22_2_0, Library.V7_DESIGN, R.string.action_design_collapsing_toolbar_layout),

	// Revision 22.1.0
	SupportDrawableCompat(Revision.REV_22_1_0, Library.V4_SUPPORT, R.string.action_support_drawable_compat),
	SupportPrebuiltInterpolators(Revision.REV_22_1_0, Library.V4_SUPPORT, R.string.action_support_prebuilt_interpolators),
	SupportPathInterpolatorCompat(Revision.REV_22_1_0, Library.V4_SUPPORT, R.string.action_support_path_interpolator_compat),
	SupportSpace(Revision.REV_22_1_0, Library.V4_SUPPORT, R.string.action_support_space),
	SupportNestedScrollView(Revision.REV_22_1_0, Library.V4_SUPPORT, R.string.action_support_nested_scroll_view),
	AppCompatDelegate(Revision.REV_22_1_0, Library.V7_APPCOMPAT, R.string.action_app_compat_delegate),
	AppCompatDialog(Revision.REV_22_1_0, Library.V7_APPCOMPAT, R.string.action_app_compat_dialog),
	AppCompatWidget(Revision.REV_22_1_0, Library.V7_APPCOMPAT, R.string.action_app_compat_widget),
	AppCompatPaletteBuilder(Revision.REV_22_1_0, Library.V7_APPCOMPAT, R.string.action_app_compat_palette_builder),
	RecyclerViewSortedList(Revision.REV_22_1_0, Library.V7_RECYCLERVIEW, R.string.action_recycler_view_sorted_list),

	// Revision 22
	SupportResourceCompat(Revision.REV_22, Library.V4_SUPPORT, R.string.action_support_resource_compat),
	RecyclerViewPosition(Revision.REV_22, Library.V7_RECYCLERVIEW, R.string.action_recycler_view_position),

	// Revision 21.0.3

	// Revision 21.0.2
	CardViewBackgroundColor(Revision.REV_21_0_2, Library.V7_CARDVIEW, R.string.action_card_view_background),

	// Revision 21.0.1

	// Revision 21
	SupportFragmentTransition(Revision.REV_21, Library.V4_SUPPORT, R.string.action_support_fragment_transition),
	AppCompatToolbar(Revision.REV_21, Library.V7_APPCOMPAT, R.string.action_app_compat_toolbar),
	AppCompatActionBarDrawerToggle(Revision.REV_21, Library.V7_APPCOMPAT, R.string.action_app_compat_actionbar_drawer_toggle),
	AppCompatSwitchCompat(Revision.REV_21, Library.V7_APPCOMPAT, R.string.action_app_compat_switch_compat),
	CardView(Revision.REV_21, Library.V7_CARDVIEW, R.string.action_card_view),
	RecyclerView(Revision.REV_21, Library.V7_RECYCLERVIEW, R.string.action_recycler_view),
	PalettePalette(Revision.REV_21, Library.V7_PALETTE, R.string.action_palette_palette),

	// Revision 13
	SupportDrawerLayout(Revision.REV_13, Library.V4_SUPPORT, R.string.action_support_drawer_layout),
	SupportSlidingPaneLayout(Revision.REV_13, Library.V4_SUPPORT, R.string.action_support_sliding_pane_layout);

	@Nullable
	public static DemoCategories get(int menuId) {
		for (DemoCategories cat : DemoCategories.values()) {
			if (cat.getResTitle() == menuId) {
				return cat;
			}
		}
		return null;
	}

	private static int selected = -1; // menuId

	private Revision revision;
	private Library library;
	private int resTitle;

	DemoCategories(Revision revision, Library library, int resTitle) {
		this.revision = revision;
		this.library = library;
		this.resTitle = resTitle;
	}

	public Revision getRevision() {
		return this.revision;
	}

	public Library getLibrary() {
		return this.library;
	}

	public int getResTitle() {
		return this.resTitle;
	}

	public static void setSelected(int selected) {
		DemoCategories.selected = selected;
	}

	public static int getSelected() {
		return DemoCategories.selected;
	}

	public Fragment createFragment() {
		Fragment fragment = null;

		// Revision 22.2.0
		if (this.equals(DesignAppBarLayout)) {
			fragment = new DesignAppBarLayoutFragment();
		} else if (this.equals(DesignTabLayout)) {
			fragment = new DesignTabLayoutFragment();
		} else if (this.equals(DesignNavigationView)) {
			fragment = new DesignNavigationViewFragment();
		} else if (this.equals(DesignFloatingActionButton)) {
			fragment = new DesignFloatingActionButtonFragment();
		} else if (this.equals(DesignSwipeDismissBehavior)) {
			fragment = new DesignSwipeDismissBehaviorFragment();
		} else if (this.equals(DesignTextInputLayout)) {
			fragment = new DesignTextInputLayoutFragment();
		} else if (this.equals(DesignCollapsingToolbarLayout)) {
			fragment = new DesignCollapsingToolbarLayoutFragment();
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
		} else if (this.equals(AppCompatPaletteBuilder)) {
			fragment = new PalettePaletteFragment();
		}
		// Revision 22
		else if (this.equals(SupportResourceCompat)) {
			fragment = new SupportResourceCompatFragment();
		} else if (this.equals(RecyclerViewPosition)) {
			fragment = new RecyclerViewPositionFragment();
		}
		// Revision 21.0.3
		// Revision 21.0.2
		else if (this.equals(CardViewBackgroundColor)) {
			fragment = new CardViewFragment();
		}
		// Revision 21.0.1
		// Revision 21
		else if (this.equals(SupportFragmentTransition)) {
			fragment = new SupportFragmentTransitionFragment();
		} else if (this.equals(AppCompatToolbar)) {
			fragment = new AppCompatToolbarFragment();
		} else if (this.equals(AppCompatSwitchCompat)) {
			fragment = new AppCompatSwitchCompatFragment();
		} else if (this.equals(CardView)) {
			fragment = new CardViewFragment();
		} else if (this.equals(RecyclerView)) {
			fragment = new RecyclerViewFragment();
		} else if (this.equals(PalettePalette)) {
			fragment = new PalettePaletteFragment();
		}
		// Revision 13
		else if (this.equals(SupportDrawerLayout)) {
			fragment = new SupportDrawerLayoutFragment();
		} else if (this.equals(SupportSlidingPaneLayout)) {
			fragment = new SupportSlidingPaneLayoutFragment();
		}

		return fragment;
	}
}
