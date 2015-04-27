package kr.pe.ssun.supportlibrary221demos.fragment.appcompat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-04-27.
 */
public class AppCompatDialogFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_appcompat_dialog, container, false);

		AppCompatButton btnShowDialog = (AppCompatButton) rootView.findViewById(R.id.btnShowDialog);
		AppCompatButton btnShowDialogWithP = (AppCompatButton) rootView.findViewById(R.id.btnShowDialogWithP);
		AppCompatButton btnShowDialogWithNP = (AppCompatButton) rootView.findViewById(R.id.btnShowDialogWithNP);
		AppCompatButton btnShowDialogWithNNP = (AppCompatButton) rootView.findViewById(R.id.btnShowDialogWithNNP);
		AppCompatButton btnShowDialogWithView = (AppCompatButton) rootView.findViewById(R.id.btnShowDialogWithView);
		AppCompatButton btnShowDialogWithItems = (AppCompatButton) rootView.findViewById(R.id.btnShowDialogWithItems);
		AppCompatButton btnShowDialogWithSingleChoiceItems = (AppCompatButton) rootView.findViewById(R.id.btnShowDialogWithSingleChoiceItems);
		AppCompatButton btnShowDialogWithMultiChoiceItems = (AppCompatButton) rootView.findViewById(R.id.btnShowDialogWithMultiChoiceItems);

		AppCompatButton btnShowAppCompatDialog = (AppCompatButton) rootView.findViewById(R.id.btnShowAppCompatDialog);
		AppCompatButton btnShowAppCompatDialogWithP = (AppCompatButton) rootView.findViewById(R.id.btnShowAppCompatDialogWithP);
		AppCompatButton btnShowAppCompatDialogWithNP = (AppCompatButton) rootView.findViewById(R.id.btnShowAppCompatDialogWithNP);
		AppCompatButton btnShowAppCompatDialogWithNNP = (AppCompatButton) rootView.findViewById(R.id.btnShowAppCompatDialogWithNNP);
		AppCompatButton btnShowAppCompatDialogWithView = (AppCompatButton) rootView.findViewById(R.id.btnShowAppCompatDialogWithView);
		AppCompatButton btnShowAppCompatDialogWithItems = (AppCompatButton) rootView.findViewById(R.id.btnShowAppCompatDialogWithItems);
		AppCompatButton btnShowAppCompatDialogWithSingleChoiceItems = (AppCompatButton) rootView.findViewById(R.id.btnShowAppCompatDialogWithSingleChoiceItems);
		AppCompatButton btnShowAppCompatDialogWithMultiChoiceItems = (AppCompatButton) rootView.findViewById(R.id.btnShowAppCompatDialogWithMultiChoiceItems);

		// show Dialogs
		btnShowDialog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new android.app.AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.create().show();
			}
		});

		btnShowDialogWithP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new android.app.AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
			}
		});

		btnShowDialogWithNP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new android.app.AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.setNegativeButton(android.R.string.cancel, null)
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
			}
		});

		btnShowDialogWithNNP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new android.app.AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.setNeutralButton("Neutral", null)
						.setNegativeButton(android.R.string.cancel, null)
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
			}
		});

		btnShowDialogWithView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				View view = LayoutInflater.from(getActivity()).inflate(
						R.layout.dialog_recycler_view_add, null, false);
				new android.app.AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.setView(view)
						.setNegativeButton(android.R.string.cancel, null)
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
			}
		});

		btnShowDialogWithItems.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new android.app.AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
								//.setMessage("Message")
						.setItems(new String[]{
								"Apple", "Banana", "Google", "Infraware", "Microsoft"
						}, null)
						.create().show();
			}
		});

		btnShowDialogWithSingleChoiceItems.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new android.app.AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
								//.setMessage("Message")
						.setSingleChoiceItems(new String[]{
								"Apple", "Banana", "Google", "Infraware", "Microsoft"
						}, -1, null)
						.create().show();
			}
		});

		btnShowDialogWithMultiChoiceItems.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
								//.setMessage("Message")
						.setMultiChoiceItems(new String[]{
								"Apple", "Banana", "Google", "Infraware", "Microsoft"
						}, null, null)
						.create().show();
			}
		});

		// show AppCompatDialogs
		btnShowAppCompatDialog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.create().show();
			}
		});

		btnShowAppCompatDialogWithP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
			}
		});

		btnShowAppCompatDialogWithNP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.setNegativeButton(android.R.string.cancel, null)
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
			}
		});

		btnShowAppCompatDialogWithNNP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.setNeutralButton("Neutral", null)
						.setNegativeButton(android.R.string.cancel, null)
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
			}
		});

		btnShowAppCompatDialogWithView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
						.setMessage("Message")
						.setView(R.layout.dialog_recycler_view_add)
						.setNegativeButton(android.R.string.cancel, null)
						.setPositiveButton(android.R.string.ok, null)
						.create().show();
			}
		});

		btnShowAppCompatDialogWithItems.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
								//.setMessage("Message")
						.setItems(new String[]{
								"Apple", "Banana", "Google", "Infraware", "Microsoft"
						}, null)
						.create().show();
			}
		});

		btnShowAppCompatDialogWithSingleChoiceItems.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
								//.setMessage("Message")
						.setSingleChoiceItems(new String[]{
								"Apple", "Banana", "Google", "Infraware", "Microsoft"
						}, -1, null)
						.create().show();
			}
		});

		btnShowAppCompatDialogWithMultiChoiceItems.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(getActivity())
						.setIcon(R.drawable.ic_launcher)
						.setTitle("Title")
								//.setMessage("Message")
						.setMultiChoiceItems(new String[]{
								"Apple", "Banana", "Google", "Infraware", "Microsoft"
						}, null, null)
						.create().show();
			}
		});

		return rootView;
	}
}
