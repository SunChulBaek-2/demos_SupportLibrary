package kr.pe.ssun.supportlibrary221demos.fragment.design;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 2015-05-29.
 */
public class DesignTextInputLayoutFragment extends Fragment {
	TextInputLayout til;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_design_text_input_layout, container, false);

		til = (TextInputLayout)rootView.findViewById(R.id.til);
		til.setHint("Input text");

		til.getEditText().setHint("Input text");
		til.getEditText().addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (count > 5) {
					til.setError("string length is over 5");
				} else if (count > 3 && count <=5) {
					til.setError(null);
				} else  {
					til.setError(null);
				}
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		return rootView;
	}
}
