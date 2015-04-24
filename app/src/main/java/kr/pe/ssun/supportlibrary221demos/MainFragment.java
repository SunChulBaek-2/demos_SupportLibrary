package kr.pe.ssun.supportlibrary221demos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by x1210x on 2015-04-24.
 */
public class MainFragment extends Fragment {
	public static final String TAG = MainFragment.class.toString();

	public interface MainFragmentListener {
		public void onItemClick(int position);
	}

	private MainFragmentListener listener;

	public MainFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		final RelativeLayout rlContainer = (RelativeLayout) rootView.findViewById(R.id.rlContainer);
		ListView lvCategory = (ListView) rootView.findViewById(R.id.lvCategory);

		lvCategory.setAdapter(new ArrayAdapter<DemoCategories>(getActivity(),
				android.R.layout.simple_list_item_1,
				android.R.id.text1,
				DemoCategories.values()));

		lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (listener != null) {
					listener.onItemClick(position);
				}
			}
		});

		return rootView;
	}

	@Override
	public void onAttach (Activity activity) {
		super.onAttach(activity);

		listener = (MainFragmentListener)activity;
	}
}
