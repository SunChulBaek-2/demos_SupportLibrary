package kr.pe.ssun.supportlibrary221demos.activity.appcompat;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-06-12.
 */
public class AppCompatActionBarDrawerToggleActivity extends Activity {
	private ActionBarDrawerToggle actionBarDrawerToggle;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_appcompat_actionbar_drawer_toggle);

		final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		final DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
		final View content = findViewById(R.id.content);

		toolbar.setTitleTextColor(R.color.lightTextPrimary);
		toolbar.setTitle("ActionBarDrawerToggle");
		actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				toolbar, 0, 0){
			@Override
			public void onDrawerClosed(View drawerView) {
				Snackbar.make(content, "onDrawerClosed Called", Snackbar.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				Snackbar.make(content, "onDrawerOpened Called", Snackbar.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				Snackbar.make(content, "onDrawerSlide Called (offset="+slideOffset+")", Snackbar.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerStateChanged(int newState) {
				Snackbar.make(content, "onDrawerStateChanged Called (state="+newState+")", Snackbar.LENGTH_SHORT).show();
			}
		};
		drawerLayout.setDrawerListener(actionBarDrawerToggle);
	}

	@Override
	protected void onPostCreate (Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		actionBarDrawerToggle.syncState();
	}
}
