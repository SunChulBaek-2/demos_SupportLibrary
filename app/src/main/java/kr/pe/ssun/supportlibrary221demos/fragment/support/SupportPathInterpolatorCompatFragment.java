package kr.pe.ssun.supportlibrary221demos.fragment.support;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 15. 4. 26..
 */
public class SupportPathInterpolatorCompatFragment extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           final Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_support_path_interpolator, container, false);

    // create from path

    // create from x1, y1, x2, y2
    Button btnCreate1 = (Button)rootView.findViewById(R.id.btnCreate1);
    final EditText etDuration1 = (EditText)rootView.findViewById(R.id.etDuration1);
    final EditText etX1 = (EditText)rootView.findViewById(R.id.etX1);
    final EditText etY1 = (EditText)rootView.findViewById(R.id.etY1);
    final EditText etX2 = (EditText)rootView.findViewById(R.id.etX2);
    final EditText etY2 = (EditText)rootView.findViewById(R.id.etY2);
    final ImageView ivNormal1 = (ImageView)rootView.findViewById(R.id.ivNormal1);
    final ImageView ivCreate1 = (ImageView)rootView.findViewById(R.id.ivCreate1);

    // create from x, y
    Button btnCreate2 = (Button)rootView.findViewById(R.id.btnCreate2);
    final EditText etDuration2 = (EditText)rootView.findViewById(R.id.etDuration2);
    final EditText etX = (EditText)rootView.findViewById(R.id.etX);
    final EditText etY = (EditText)rootView.findViewById(R.id.etY);
    final ImageView ivNormal2 = (ImageView)rootView.findViewById(R.id.ivNormal2);
    final ImageView ivCreate2 = (ImageView)rootView.findViewById(R.id.ivCreate2);

    btnCreate1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Animation normal = AnimationUtils.loadAnimation(getActivity(), R.anim.support_v4_interpolators);
        normal.setDuration(Long.valueOf(etDuration1.getText().toString()));

        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.support_v4_interpolators);
        animation.setDuration(Long.valueOf(etDuration1.getText().toString()));
        Interpolator interpolator = PathInterpolatorCompat.create(
            Float.valueOf(etX1.getText().toString()),
            Float.valueOf(etY1.getText().toString()),
            Float.valueOf(etX2.getText().toString()),
            Float.valueOf(etY2.getText().toString())
        );
        animation.setInterpolator(interpolator);

        ivNormal1.startAnimation(normal);
        ivCreate1.startAnimation(animation);
      }
    });

    btnCreate2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Animation normal = AnimationUtils.loadAnimation(getActivity(), R.anim.support_v4_interpolators);
        normal.setDuration(Long.valueOf(etDuration2.getText().toString()));

        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.support_v4_interpolators);
        animation.setDuration(Long.valueOf(etDuration2.getText().toString()));
        Interpolator interpolator = PathInterpolatorCompat.create(
            Float.valueOf(etX.getText().toString()),
            Float.valueOf(etY.getText().toString())
        );
        animation.setInterpolator(interpolator);

        ivNormal2.startAnimation(normal);
        ivCreate2.startAnimation(animation);
      }
    });

    return rootView;
  }
}
