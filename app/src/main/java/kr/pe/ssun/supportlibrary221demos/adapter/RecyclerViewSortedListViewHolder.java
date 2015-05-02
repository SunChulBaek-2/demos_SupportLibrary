package kr.pe.ssun.supportlibrary221demos.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by x1210x on 2015-04-27.
 */
public class RecyclerViewSortedListViewHolder extends RecyclerView.ViewHolder {
	private TextView textView;

	public RecyclerViewSortedListViewHolder(View itemView) {
		super(itemView);

		textView = (TextView)itemView.findViewById(android.R.id.text1);
	}

	public void setText(String text) {
		if (textView != null) {
			textView.setText(text);
		}
	}
}
