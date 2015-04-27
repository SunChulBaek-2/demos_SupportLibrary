package kr.pe.ssun.supportlibrary221demos.fragment.recyclerview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.util.SortedList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.AddFloatingActionButton;

import kr.pe.ssun.supportlibrary221demos.R;
import kr.pe.ssun.supportlibrary221demos.adapter.MyRecyclerViewAdapter;

/**
 * Created by x1210x on 2015-04-27.
 */
public class RecyclerViewFragment extends Fragment {
	private MyRecyclerViewAdapter adapter;

	private SortedList<String> sortedList = new SortedList<String>(String.class,
			new SortedList.Callback<String>() {
				@Override
				public int compare(String s, String s2) {
					return s.compareTo(s2);
				}

				@Override
				public void onInserted(int position, int count) {
					Toast.makeText(getActivity(),
							"SortedList.Callback.onInserted",
							Toast.LENGTH_SHORT).show();
					if (adapter!= null)
						adapter.notifyItemInserted(position);
				}

				@Override
				public void onRemoved(int position, int count) {
					Toast.makeText(getActivity(),
							"SortedList.Callback.onRemoved",
							Toast.LENGTH_SHORT).show();
					if (adapter!= null)
						adapter.notifyItemRemoved(position);
				}

				@Override
				public void onMoved(int fromPosition, int toPosition) {
					Toast.makeText(getActivity(),
							"SortedList.Callback.onMoved",
							Toast.LENGTH_SHORT).show();
					if (adapter!= null)
						adapter.notifyItemMoved(fromPosition, toPosition);
				}

				@Override
				public void onChanged(int position, int count) {
					Toast.makeText(getActivity(),
							"SortedList.Callback.onChanged",
							Toast.LENGTH_SHORT).show();
					if (adapter!= null)
						adapter.notifyItemRangeChanged(position, count);
				}

				@Override
				public boolean areContentsTheSame(String s, String s2) {
					return s.equals(s2);
				}

				@Override
				public boolean areItemsTheSame(String s, String s2) {
					return s.equals(s2);
				}
			});

	private AlertDialog mDialog;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
		final RecyclerView rcRecyclerView = (RecyclerView)rootView.findViewById(R.id.rvRecyclerView);
		final AddFloatingActionButton fab = (AddFloatingActionButton)rootView.findViewById(R.id.fab);

		rcRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		adapter = new MyRecyclerViewAdapter(sortedList, new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				final int itemPosition = rcRecyclerView.getChildAdapterPosition(v);
				final String item = sortedList.get(itemPosition);

				View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_recycler_view_modify, null, false);

				ListView lvListView = (ListView)view.findViewById(R.id.lvListView);
				lvListView.setAdapter(new ArrayAdapter<String>(getActivity(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1,
						new String[] {
							"Rename",
							"Delete",
						}));
				lvListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						if(position == 0) { // rename
							final View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_recycler_view_add, null, false);
							new AlertDialog.Builder(getActivity())
									.setTitle("Rename "+item+" to")
									.setView(view2)
									.setPositiveButton(android.R.string.ok,
											new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface dialog, int which) {
													EditText etRename = (EditText)view2.findViewById(R.id.etItem);
													sortedList.updateItemAt(itemPosition, etRename.getText().toString());
													dialog.dismiss();
												}
											})
									.setNegativeButton(android.R.string.cancel,
											new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface dialog, int which) {
													dialog.dismiss();
												}
											})
									.create().show();
						} else if(position == 1) { // delete
							sortedList.removeItemAt(position);
						}
						mDialog.dismiss();
					}
				});

				mDialog = new AlertDialog.Builder(getActivity())
						.setTitle(item)
						.setView(view)
						.create();
				mDialog.show();

				return false;
			}
		});
		sortedList.add("Banana");
		sortedList.add("Apple");
		rcRecyclerView.setAdapter(adapter);

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_recycler_view_add, null, false);
				new AlertDialog.Builder(getActivity())
						.setTitle("Add Item")
						.setView(view)
						.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();
							}
						})
						.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								EditText etItem = (EditText)view.findViewById(R.id.etItem);
								sortedList.add(etItem.getText().toString());
								dialog.dismiss();
							}
						})
						.create().show();
			}
		});

		return rootView;
	}
}
