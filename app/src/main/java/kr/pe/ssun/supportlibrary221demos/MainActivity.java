package kr.pe.ssun.supportlibrary221demos;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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

	private Toolbar toolbar;
	private MaterialMenuDrawable materialMenu;

	private String tag = null;
	private int selected = -1;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		getDelegate().installViewFactory();
		super.onCreate(savedInstanceState);
		getDelegate().onCreate(savedInstanceState);

		getDelegate().setContentView(R.layout.activity_main);

		setupToolbar();

		RelativeLayout rlMain = (RelativeLayout)findViewById(R.id.rlMain);
		if(rlMain.getTag() != null) {
			Screen screen = Screen.valueOf(((String)rlMain.getTag()).toUpperCase());
			Screen.setCurrent(screen);
		}

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.list, new MainFragment(), MainFragment.TAG)
					.commit();
		} else {
			tag = savedInstanceState.getString("tag");
			selected = savedInstanceState.getInt("selected");

			DemoCategories.setSelected(selected);

			if (Screen.getCurrent().equals(Screen.LARGE_LAND)) {
				materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER, false);
				toolbar.setTitle(R.string.app_name);
			} else if (tag != null && !tag.trim().isEmpty()) {
				materialMenu.animateIconState(MaterialMenuDrawable.IconState.ARROW, false);
				toolbar.setTitle(DemoCategories.values()[selected].getTitle());
			}
		}
	}

	@Override
	protected void onSaveInstanceState (Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putString("tag", tag);
		outState.putInt("selected", selected);
	}

	private void setupToolbar() {
		toolbar = (Toolbar)findViewById(R.id.toolbar);
		materialMenu = new MaterialMenuDrawable(this,
				Color.WHITE,
				MaterialMenuDrawable.Stroke.THIN,
				DEFAULT_SCALE,
				DEFAULT_TRANSFORM_DURATION,
				DEFAULT_PRESSED_DURATION);
		toolbar.setNavigationIcon(materialMenu);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				selected = -1;
				DemoCategories.setSelected(-1);

				if (Screen.getCurrent().equals(Screen.LARGE_LAND)) {
					finish();
					return;
				} else if (tag != null && !tag.trim().isEmpty()) {
					MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.TAG);
					fragment.setSelected(-1);
					popBackStack();
				} else {
					finish();
					return;
				}
			}
		});
		toolbar.setTitle(R.string.app_name);
		toolbar.setTitleTextColor(Color.WHITE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		selected = -1;
		DemoCategories.setSelected(-1);

		if (Screen.getCurrent().equals(Screen.LARGE_LAND)) {
			finish();
			return;
		} else if (tag == null || tag.trim().isEmpty()) {
			finish();
			return;
		}

		MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.TAG);
		fragment.setSelected(-1);

		popBackStack();
	}

	@Override
	public void onItemClick(int position) {
		selected = position;

		if (selected >= 0) {
			MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.TAG);
			fragment.setSelected(selected);
		}

		FragmentManager fm = getSupportFragmentManager();

		DemoCategories category = DemoCategories.values()[position];
		Fragment fragment = category.createFragment();

		if(fragment != null) {
			String tag = fragment.getClass().toString();
			fm.beginTransaction()
					.replace(R.id.container, fragment, tag)
					.commit();

			this.tag = tag;
			if(Screen.getCurrent().equals(Screen.NORMAL)) {
				materialMenu.animateIconState(MaterialMenuDrawable.IconState.ARROW, false);
				toolbar.setTitle(DemoCategories.values()[position].getTitle());
			}
		} else {
			if(category.equals(DemoCategories.AppCompatDelegate)) {
				new AlertDialog.Builder(this)
						.setTitle("AppCompatDelegate")
						.setMessage("MainActivity is created using AppCompatDelegate.")
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
			}
		}
	}

	private void popBackStack() {
		if (tag == null || tag.trim().isEmpty()) {
			return;
		}
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentByTag(MainFragment.TAG);
		if (fragment != null) {
			MainFragment mainFragment = (MainFragment) fragment;
			mainFragment.updateUI();
		}

		fragment = fm.findFragmentByTag(tag);
		if (fragment == null) {
			return;
		}

		fm.beginTransaction()
				.remove(fragment)
				.commit();

		tag = null;
		materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER, false);
		toolbar.setTitle(R.string.app_name);
	}

	@Override
	public void onSupportActionModeStarted(ActionMode mode) {

	}

	@Override
	public void onSupportActionModeFinished(ActionMode mode) {

	}

	public AppCompatDelegate getDelegate() {
		if (mDelegate == null) {
			mDelegate = AppCompatDelegate.create(this, this);
		}
		return mDelegate;
	}
}
