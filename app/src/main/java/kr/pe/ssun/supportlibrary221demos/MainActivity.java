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
import android.view.Window;
import android.widget.Toast;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.ArrayList;

import kr.pe.ssun.supportlibrary221demos.fragment.MainFragment;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;

public class MainActivity extends FragmentActivity
		implements AppCompatCallback, MainFragment.MainFragmentListener {
	private AppCompatDelegate mDelegate;

	private Toolbar toolbar;
	private MaterialMenuDrawable materialMenu;
	private ArrayList<String> tags = new ArrayList<String>();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		getDelegate().installViewFactory();
		super.onCreate(savedInstanceState);
		getDelegate().onCreate(savedInstanceState);

		getDelegate().setContentView(R.layout.activity_main);
		getDelegate().getSupportActionBar().hide();

		setupToolbar();

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new MainFragment(), MainFragment.TAG)
					.commit();
		}
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
				if (tags.size() > 0) {
					popBackStack();
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
		popBackStack();
	}

	@Override
	public void onItemClick(int position) {
		FragmentManager fm = getSupportFragmentManager();

		DemoCategories category = DemoCategories.values()[position];
		Fragment fragment = category.createFragment();

		if(fragment != null) {
			String tag = fragment.getClass().toString();
			fm.beginTransaction()
					.add(R.id.container, fragment, tag)
					.commit();
			tags.add(tag);
			materialMenu.animateIconState(MaterialMenuDrawable.IconState.ARROW, false);
			toolbar.setTitle(DemoCategories.values()[position].getTitle());
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
		if (tags.size() <= 0) {
			finish();
			return;
		}
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentByTag(tags.get(tags.size() - 1));
		if (fragment == null) {
			return;
		}

		fm.beginTransaction()
				.remove(fragment)
				.commit();
		tags.remove(tags.size() - 1);
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
