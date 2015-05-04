package kr.pe.ssun.supportlibrary221demos.fragment.recyclerview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 15. 5. 2..
 */
public class RecyclerViewPositionFragment extends Fragment {
	private static ArrayList<Integer> data = new ArrayList<>();

	static {
		for(int i=0; i<100; i++) {
			data.add(i);
		}
	}

	private RecyclerView rcRecyclerView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_recyclerview_position, container, false);
		rcRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvRecyclerView);

		rcRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		rcRecyclerView.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {

			@Override
			public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				View view = LayoutInflater.from(parent.getContext())
						.inflate(android.R.layout.simple_list_item_1, parent, false);

				final RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(view) { };

				view.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						int adapterPosition = holder.getAdapterPosition();
						int layoutPosition = holder.getLayoutPosition();

						new AlertDialog.Builder(getActivity())
								.setIcon(R.drawable.ic_launcher)
								.setTitle("RecyclerView")
								.setMessage("getAdapterPosition(view)=" + adapterPosition + "\n" +
										"getLayoutPosition(view)=" + layoutPosition).show();
					}
				});

				return holder;
			}

			@Override
			public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
				View itemView = holder.itemView;

				TextView text1 = (TextView) itemView.findViewById(android.R.id.text1);
				text1.setText("RecyclerView item (" + data.get(position) + ")");
			}

			@Override
			public int getItemCount() {
				return data.size();
			}
		});
		return rootView;
	}
}
