package kr.pe.ssun.supportlibrary221demos.fragment.design;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-05-29.
 */
public class DesignAppBarLayoutFragment extends Fragment {
	private Toolbar toolbar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_design_appbar_layout, container, false);

		toolbar = (Toolbar)rootView.findViewById(R.id.toolbar);
		toolbar.inflateMenu(R.menu.menu_appbar_layout);
		toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				AppBarLayout.LayoutParams params1 = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();

				if (item.getItemId() == R.id.enter_always) {
					Snackbar.make(rootView, "You Selected EnterAlways", Snackbar.LENGTH_SHORT).show();
					params1.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
					toolbar.setLayoutParams(params1);
					return true;
				} else if (item.getItemId() == R.id.enter_always_collapsed) {
					Snackbar.make(rootView, "You Selected EnterAlwaysCollapsed", Snackbar.LENGTH_SHORT).show();
					params1.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
					toolbar.setLayoutParams(params1);
					return true;
				} else if (item.getItemId() == R.id.exit_until_collapsed) {
					Snackbar.make(rootView, "You Selected ExitUntilCollapsed", Snackbar.LENGTH_SHORT).show();
					params1.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
					toolbar.setLayoutParams(params1);
					return true;
				}
				return false;
			}
		});

		toolbar.setTitle("Toolbar");

		return rootView;
	}
}
