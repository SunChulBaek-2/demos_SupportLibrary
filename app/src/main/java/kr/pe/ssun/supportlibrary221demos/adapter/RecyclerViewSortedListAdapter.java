package kr.pe.ssun.supportlibrary221demos.adapter;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-04-27.
 */
public class RecyclerViewSortedListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private SortedList<String> list;
	private View.OnLongClickListener listener;

	public RecyclerViewSortedListAdapter(SortedList<String> list, View.OnLongClickListener onLongClickListener) {
		this.list = list;
		this.listener = onLongClickListener;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View view = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.recycler_recyclerview_item, viewGroup, false);
		if (listener != null) {
			view.setOnLongClickListener(listener);
		}
		return new RecyclerViewSortedListViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
		RecyclerViewSortedListViewHolder vh = (RecyclerViewSortedListViewHolder) viewHolder;
		vh.setText(list.get(i));
	}

	@Override
	public int getItemCount() {
		return this.list.size();
	}
}
