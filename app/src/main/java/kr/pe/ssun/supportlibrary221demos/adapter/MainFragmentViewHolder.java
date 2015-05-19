package kr.pe.ssun.supportlibrary221demos.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 15. 5. 1..
 */
public class MainFragmentViewHolder extends RecyclerView.ViewHolder {
	private View itemView;
	private AppCompatTextView textView;

	public MainFragmentViewHolder(View itemView) {
		super(itemView);

		this.itemView = itemView;
		this.textView = (AppCompatTextView) itemView.findViewById(R.id.text);
	}

	public void setText(String text) {
		if (textView != null) {
			textView.setText(text);
		}
	}

	public void setSelected(boolean selected) {
		if (this.itemView != null) {
			this.itemView.setSelected(selected);
		}
	}
}
