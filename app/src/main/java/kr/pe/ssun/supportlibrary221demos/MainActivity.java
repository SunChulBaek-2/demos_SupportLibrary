package kr.pe.ssun.supportlibrary221demos;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.balysv.materialmenu.MaterialMenuDrawable;

import kr.pe.ssun.supportlibrary221demos.data.DemoCategories;
import kr.pe.ssun.supportlibrary221demos.fragment.MainFragment;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;

public class MainActivity extends FragmentActivity
		implements AppCompatCallback, MainFragment.MainFragmentListener {
	private AppCompatDelegate mDelegate;

	private DrawerLayout mDrawer;
	private RelativeLayout mRlMain;
	private RelativeLayout mRlDrawer;
	private Toolbar mMainToolbar;
	private Toolbar mDrawerToolbar;
	private MaterialMenuDrawable mMaterialMenu;

	private String tag = null;
	private int selected = -1;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		getDelegate().installViewFactory();
		super.onCreate(savedInstanceState);
		getDelegate().onCreate(savedInstanceState);

		getDelegate().setContentView(R.layout.activity_main);

		mDrawer = (DrawerLayout) findViewById(R.id.drawer);
		// Drawer
		mRlDrawer = (RelativeLayout)findViewById(R.id.rlDrawer);
		mDrawerToolbar = (Toolbar) findViewById(R.id.drawer_toolbar);
		// Main Content
		mRlMain = (RelativeLayout)findViewById(R.id.rlMain);
		mMainToolbar = (Toolbar) findViewById(R.id.main_toolbar);

		mMaterialMenu = new MaterialMenuDrawable(this,
				Color.WHITE,
				MaterialMenuDrawable.Stroke.THIN,
				DEFAULT_SCALE,
				DEFAULT_TRANSFORM_DURATION,
				DEFAULT_PRESSED_DURATION);

		if(mDrawer.getTag() != null) {
			Screen screen = Screen.valueOf(((String)mDrawer.getTag()).toUpperCase());
			Screen.setCurrent(screen);
			mDrawer.requestDisallowInterceptTouchEvent(true);
		}

		setupToolbar();

		if (Screen.getCurrent().equals(Screen.LARGE_LAND)) {
			mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
			mDrawer.setScrimColor(Color.TRANSPARENT);
		}

		if (savedInstanceState == null) {
			MainFragment fragment = new MainFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.list, fragment, MainFragment.TAG)
					.commit();
		} else {
			tag = savedInstanceState.getString("tag");
			selected = savedInstanceState.getInt("selected");
			String title = savedInstanceState.getString("title", getString(R.string.app_name));

			DemoCategories.setSelected(selected);

			if (selected >= 0) {
				mMainToolbar.setTitle(title);
			}
		}
	}

	@Override
	protected void onSaveInstanceState (Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putString("tag", tag);
		outState.putInt("selected", selected);

		if (mMainToolbar.getTitle() != null) {
			outState.putString("title", mMainToolbar.getTitle().toString());
		}
	}

	private void setupToolbar() {
		// Drawer Toolbar
		mDrawerToolbar.setTitle(R.string.app_name);
		mDrawerToolbar.setTitleTextColor(Color.WHITE);

		// Main Toolbar
		if (Screen.getCurrent().equals(Screen.NORMAL)) {
			mMainToolbar.setNavigationIcon(mMaterialMenu);
			mMainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					mDrawer.openDrawer(mRlDrawer);
				}
			});
			mMainToolbar.setTitle(R.string.app_name);
		}
		mMainToolbar.setTitleTextColor(Color.WHITE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		if (Screen.getCurrent().equals(Screen.NORMAL) && mDrawer.isDrawerOpen(mRlDrawer)) {
			mDrawer.closeDrawer(mRlDrawer);
		} else {
			selected = -1;
			DemoCategories.setSelected(-1);

			finish();
		}
	}

	@Override
	public boolean onItemClick(MenuItem menuItem) {
		selected = menuItem.getItemId();

		if (selected >= 0) {
			DemoCategories.setSelected(selected);
		}

		FragmentManager fm = getSupportFragmentManager();

		DemoCategories category = DemoCategories.get(menuItem.getItemId());
		Fragment fragment = category.createFragment();

		if(fragment != null) {
			mMainToolbar.setTitle(menuItem.getTitle());

			String tag = fragment.getClass().toString();
			fm.beginTransaction()
					.replace(R.id.container, fragment, tag)
					.commit();

			this.tag = tag;
			if(Screen.getCurrent().equals(Screen.NORMAL)) {
				mDrawer.closeDrawer(mRlDrawer);
			}
			return true;
		} else {
			if(category.equals(DemoCategories.AppCompatDelegate)) {
				new AlertDialog.Builder(this)
						.setTitle(R.string.action_app_compat_delegate)
						.setMessage("MainActivity is created using AppCompatDelegate.")
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
				return true;
			} else if (category.equals(DemoCategories.DesignNavigationView)) {
				new AlertDialog.Builder(this)
						.setTitle(R.string.action_design_navigation_view)
						.setMessage("MainActivity is created using NavigationView.")
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
				return true;
			}
		}
		return false;
	}

	@Override
	public void onSupportActionModeStarted(ActionMode mode) {

	}

	@Override
	public void onSupportActionModeFinished(ActionMode mode) {

	}

	@Nullable
	@Override
	public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
		return null;
	}

	public AppCompatDelegate getDelegate() {
		if (mDelegate == null) {
			mDelegate = AppCompatDelegate.create(this, this);
		}
		return mDelegate;
	}
}
