package kr.pe.ssun.supportlibrary221demos.supportv4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 15. 4. 26..
 */
public class SupportV4SpaceFragment extends Fragment {
  public static final String TAG = SupportV4SpaceFragment.class.toString();

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           final Bundle savedInstanceState) {
    final View rootView = inflater.inflate(R.layout.fragment_support_v4_space, container, false);

    return rootView;
  }
}
