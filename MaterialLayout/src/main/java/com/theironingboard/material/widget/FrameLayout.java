package com.theironingboard.material.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.theironingboard.material.drawable.RippleDrawable;

public class FrameLayout extends android.widget.FrameLayout {
	private RippleManager mRippleManager = new RippleManager();

	public FrameLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public FrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);

		init(context, attrs, 0, 0);
	}

	private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		applyStyle(context, attrs, defStyleAttr, defStyleRes);
	}

	public void applyStyle(int resId) {
		applyStyle(getContext(), null, 0, resId);
	}

	private void applyStyle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		mRippleManager.onCreate(this, context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	public void setBackgroundDrawable(Drawable drawable) {
		Drawable background = getBackground();
		if (background instanceof RippleDrawable && !(drawable instanceof RippleDrawable))
			((RippleDrawable) background).setBackgroundDrawable(drawable);
		else
			super.setBackgroundDrawable(drawable);
	}

	@Override
	public void setOnClickListener(OnClickListener l) {
		if (l == mRippleManager)
			super.setOnClickListener(l);
		else {
			mRippleManager.setOnClickListener(l);
			setOnClickListener(mRippleManager);
		}
	}

	@Override
	public boolean onTouchEvent(@NonNull MotionEvent event) {
		boolean result = super.onTouchEvent(event);
		return mRippleManager.onTouchEvent(event) || result;
	}

}
