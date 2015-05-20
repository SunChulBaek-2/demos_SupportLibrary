package kr.pe.ssun.supportlibrary221demos.view;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * An improved version of DrawerLayout that will ensure that a locked open DrawerLayout can be used without capturing all touches into the client
 * area.
 * <p>
 *     To activate, call {@link #requestDisallowInterceptTouchEvent(boolean)} on the layout. Note that this should only ever be done in case when
 *     the drawer is to be locked open.
 * </p>
 * @author Rainer Burgstaller
 */
public class BetterDrawerLayout extends DrawerLayout {
	private boolean m_disallowIntercept;

	public BetterDrawerLayout(final Context context) {
		super(context);
	}

	public BetterDrawerLayout(final Context context, final AttributeSet attrs) {
		super(context, attrs);
	}

	public BetterDrawerLayout(final Context context, final AttributeSet attrs, final int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean onInterceptTouchEvent(final MotionEvent ev) {
		if (m_disallowIntercept) {
			return false;
		}
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public void requestDisallowInterceptTouchEvent(final boolean disallowIntercept) {
		super.requestDisallowInterceptTouchEvent(disallowIntercept);

		m_disallowIntercept = disallowIntercept;
	}
}