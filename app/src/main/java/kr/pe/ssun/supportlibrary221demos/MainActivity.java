package kr.pe.ssun.supportlibrary221demos;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.ArrayList;

import kr.pe.ssun.supportlibrary221demos.supportv4.SupportV4DrawableCompatFragment;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;

public class MainActivity extends FragmentActivity
		implements MainFragment.MainFragmentListener {
	private Toolbar toolbar;
	private MaterialMenuDrawable materialMenu;
	private ArrayList<String> tags = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new MainFragment(), MainFragment.TAG)
					.commit();
		}
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

		Fragment fragment = null;
		String tag = null;
		if(position == DemoCategories.SupportV4DrawableCompat.ordinal()) {
			fragment = new SupportV4DrawableCompatFragment();
			tag = SupportV4DrawableCompatFragment.TAG;
		}

		if(fragment != null) {
			fm.beginTransaction()
					.add(R.id.container, fragment, tag)
					.commit();
			tags.add(tag);
			materialMenu.animateIconState(MaterialMenuDrawable.IconState.ARROW, false);
			toolbar.setTitle(DemoCategories.values()[position].getTitle());
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
}
