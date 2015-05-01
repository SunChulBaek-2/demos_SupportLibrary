package kr.pe.ssun.supportlibrary221demos.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import kr.pe.ssun.supportlibrary221demos.DemoCategories;
import kr.pe.ssun.supportlibrary221demos.R;
import kr.pe.ssun.supportlibrary221demos.Screen;
import kr.pe.ssun.supportlibrary221demos.adapter.MainFragmentAdapter;

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
		final RecyclerView rvCategory = (RecyclerView)rootView.findViewById(R.id.rvCategory);

		rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
		rvCategory.setAdapter(new MainFragmentAdapter(new MainFragmentAdapter.MainFragmentAdapterListener() {
			@Override
			public void onItemClick(View view) {
				int position = rvCategory.getChildAdapterPosition(view);
				DemoCategories.selected = position;

				if (listener != null) {
					listener.onItemClick(position);
				}
			}
		}));

		return rootView;
	}

	@Override
	public void onAttach (Activity activity) {
		super.onAttach(activity);

		listener = (MainFragmentListener)activity;
	}
}
