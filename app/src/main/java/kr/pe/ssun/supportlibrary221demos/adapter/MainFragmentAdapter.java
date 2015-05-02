package kr.pe.ssun.supportlibrary221demos.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import kr.pe.ssun.supportlibrary221demos.DemoCategories;
import kr.pe.ssun.supportlibrary221demos.R;
import kr.pe.ssun.supportlibrary221demos.Screen;
import kr.pe.ssun.supportlibrary221demos.fragment.MainFragment;

/**
 * Created by x1210x on 15. 5. 1..
 */
public class MainFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
	implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder> {
	public interface MainFragmentAdapterListener {
		public void onItemClick(View view);
	}

	private MainFragmentAdapterListener listener;

	public MainFragmentAdapter(MainFragmentAdapterListener listener) {
		this.listener = listener;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.category_list_item, parent, false);

		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (listener != null) {
					listener.onItemClick(v);
				}
				notifyDataSetChanged();
			}
		});

		return new MainFragmentViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		MainFragmentViewHolder vh = (MainFragmentViewHolder) holder;
		vh.setText(DemoCategories.values()[position].getTitle());
		if (position == DemoCategories.selected) {
			vh.setSelected(true);
		} else {
			vh.setSelected(false);
		}
	}

	@Override
	public int getItemCount() {
		return DemoCategories.values().length;
	}

	@Override
	public long getHeaderId(int position) {
		return DemoCategories.values()[position].getVersion().getId();
	}

	@Override
	public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {
		View view = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.recycler_view_header_item, viewGroup, false);

		return new RecyclerView.ViewHolder(view){

		};
	}

	@Override
	public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
		TextView tv = (TextView)viewHolder.itemView;
		tv.setText(DemoCategories.values()[position].getVersion().getText());
	}
}
