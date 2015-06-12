package kr.pe.ssun.supportlibrary221demos;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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

import kr.pe.ssun.supportlibrary221demos.activity.appcompat.AppCompatActionBarDrawerToggleActivity;
import kr.pe.ssun.supportlibrary221demos.data.DemoCategories;

public class MainActivity extends FragmentActivity implements AppCompatCallback {
	private AppCompatDelegate mDelegate;

	private DrawerLayout mDrawer;
	private ActionBarDrawerToggle mToggle;
	private RelativeLayout mRlMain;
	private NavigationView mNavigation;
	private Toolbar mToolbar;

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
		mNavigation = (NavigationView) findViewById(R.id.navigation);
		// Main Content
		mRlMain = (RelativeLayout)findViewById(R.id.rlMain);
		mToolbar = (Toolbar) findViewById(R.id.main_toolbar);

		mToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, 0, 0);
		mDrawer.setDrawerListener(mToggle);

		mNavigation.inflateHeaderView(R.layout.header_navigation_view);
		mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {
				setNavItemChecked(menuItem.getItemId());

				if (menuItem.isEnabled() && menuItem.isCheckable()) {
					return onItemClick(menuItem);
				}
				return false;
			}
		});
		setNavItemChecked(DemoCategories.getSelected());

		// init
		MenuItem item = mNavigation.getMenu().getItem(0);
		setNavItemChecked(item.getItemId());
		if (item.isEnabled() && item.isCheckable()) {
			onItemClick(item);
		}

		if(mDrawer.getTag() != null) {
			Screen screen = Screen.valueOf(((String)mDrawer.getTag()).toUpperCase());
			Screen.setCurrent(screen);
		}

		setupToolbar();

		if (savedInstanceState == null) {
		} else {
			tag = savedInstanceState.getString("tag");
			selected = savedInstanceState.getInt("selected");
			String title = savedInstanceState.getString("title", getString(R.string.app_name));

			DemoCategories.setSelected(selected);

			if (selected >= 0) {
				mToolbar.setTitle(title);
			}
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		getDelegate().onPostCreate(savedInstanceState);
		mToggle.syncState();
	}

	private void setNavItemChecked(int id) {
		for (int i=0; i<mNavigation.getMenu().size(); i++) {
			MenuItem item = mNavigation.getMenu().getItem(i);
			if (item.isEnabled() && item.isCheckable()) {
				item.setChecked(item.getItemId() == id);
			}
		}
	}

	@Override
	protected void onSaveInstanceState (Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putString("tag", tag);
		outState.putInt("selected", selected);

		if (mToolbar.getTitle() != null) {
			outState.putString("title", mToolbar.getTitle().toString());
		}
	}

	private void setupToolbar() {
		mToolbar.setTitle(R.string.app_name);
		mToolbar.setTitleTextColor(Color.WHITE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		if (mDrawer.isDrawerOpen(mNavigation)) {
			mDrawer.closeDrawer(mNavigation);
		} else {
			selected = -1;
			DemoCategories.setSelected(-1);

			finish();
		}
	}

	public boolean onItemClick(MenuItem menuItem) {
		selected = menuItem.getItemId();

		if (selected >= 0) {
			DemoCategories.setSelected(selected);
		}

		FragmentManager fm = getSupportFragmentManager();

		DemoCategories category = DemoCategories.get(menuItem.getItemId());
		Fragment fragment = category.createFragment();

		if(fragment != null) {
			mToolbar.setTitle(menuItem.getTitle());

			String tag = fragment.getClass().toString();
			fm.beginTransaction()
					.replace(R.id.container, fragment, tag)
					.commit();

			this.tag = tag;
			mDrawer.closeDrawer(mNavigation);
			return true;
		} else {
			if(category.equals(DemoCategories.AppCompatDelegate)) {
				new AlertDialog.Builder(this)
						.setTitle(R.string.action_app_compat_delegate)
						.setMessage("MainActivity is created using AppCompatDelegate.")
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
				return true;
			} else if (category.equals(DemoCategories.AppCompatActionBarDrawerToggle)) {
				Intent intent = new Intent(this, AppCompatActionBarDrawerToggleActivity.class);
				startActivity(intent);
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
