package kr.pe.ssun.supportlibrary221demos.fragment.recyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-06-17.
 */
public class RecyclerViewFragment extends Fragment {
	private static final String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
	private static String[] LIPSUMS = null;
	static {
		LIPSUMS = LIPSUM.split("\\s+");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

		RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.rvRecyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		recyclerView.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>(){
			@Override
			public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				View itemView = LayoutInflater.from(getActivity()).inflate(android.R.layout.simple_list_item_1, parent, false);
				RecyclerView.ViewHolder vh = new RecyclerView.ViewHolder(itemView) { };
				return vh;
			}

			@Override
			public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
				View itemView = holder.itemView;
				TextView text1 = (TextView) itemView.findViewById(android.R.id.text1);
				text1.setText(LIPSUMS[position%LIPSUMS.length]);
			}

			@Override
			public int getItemCount() {
				return Integer.MAX_VALUE;
			}
		});

		return rootView;
	}
}
