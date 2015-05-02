package kr.pe.ssun.supportlibrary221demos.fragment.support;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 15. 4. 26..
 */
public class SupportPrebuiltInterpolatorsFragment extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           final Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_support_interpolators, container, false);

    final EditText etDuration = (EditText)rootView.findViewById(R.id.etDuration);
    Button btnAnimate = (Button)rootView.findViewById(R.id.btnAnimate);
    final ImageView ivNormal = (ImageView)rootView.findViewById(R.id.ivNormal);
    final ImageView ivFastOutLinear = (ImageView)rootView.findViewById(R.id.ivFastOutLinear);
    final ImageView ivFastOutSlow = (ImageView)rootView.findViewById(R.id.ivFastOutSlow);
    final ImageView ivLinearOutSlow = (ImageView)rootView.findViewById(R.id.ivLinearOutSlow);

    btnAnimate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        long duration = Long.valueOf(etDuration.getText().toString());

        Animation normalAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.support_v4_interpolators);
        normalAnimation.setDuration(duration);

        Animation fastOutLinearAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.support_v4_interpolators);
        fastOutLinearAnimation.setDuration(duration);
        fastOutLinearAnimation.setInterpolator(new FastOutLinearInInterpolator());

        Animation fastOutSlowAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.support_v4_interpolators);
        fastOutSlowAnimation.setDuration(duration);
        fastOutSlowAnimation.setInterpolator(new FastOutSlowInInterpolator());

        Animation linearOutSlowAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.support_v4_interpolators);
        linearOutSlowAnimation.setDuration(duration);
        linearOutSlowAnimation.setInterpolator(new LinearOutSlowInInterpolator());

        ivNormal.startAnimation(normalAnimation);
        ivFastOutLinear.startAnimation(fastOutLinearAnimation);
        ivFastOutSlow.startAnimation(fastOutSlowAnimation);
        ivLinearOutSlow.startAnimation(linearOutSlowAnimation);
      }
    });

    return rootView;
  }
}
