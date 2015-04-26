package kr.pe.ssun.supportlibrary221demos;

import android.support.v4.app.Fragment;

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
	SupportV4Palette("Support V4 : Palette (not implemented yet)"),
	SupportV4PrebuiltInterpolators("Support V4 : Prebuilt Interpolators"),
	SupportV4PathInterpolatorCompat("Support V4 : PathInterpolatorCompat"),
	SupportV4Space("Support V4 : Space"),
	// AppCompat
	AppCompatActivity("AppCompat : AppCompatActivity (not implemented yet)"),
	AppCompatDialog("AppCompat : AppCompatDialog (not implemented yet)"),
	AppCompatWidget("AppCompat : AppCompatWidget (not implemented yet)"),
	// LeanBack : for Android TV apps
	//LeanBack("LeanBack", null),
	// RecyclerView
	RecyclerView("RecyclerView (not implemented yet)"),
	// Palette
	Palette("Palette (not implemented yet)"),
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

          if(this.equals(SupportV4DrawableCompat)) {
            fragment = new SupportV4DrawableCompatFragment();
          } else if(this.equals(SupportV4PrebuiltInterpolators)) {
            fragment = new SupportV4PrebuiltInterpolatorsFragment();
          } else if(this.equals(SupportV4PathInterpolatorCompat)) {
            fragment = new SupportV4PathInterpolatorCompatFragment();
          } else if(this.equals(SupportV4Space)) {
            fragment = new SupportV4SpaceFragment();
          }

          return fragment;
        }
}
