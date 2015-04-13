package cn.joim.controller.view;

import cn.joim.controller.R;
import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class UserCenterLayout extends RelativeLayout {

	private Context mContext;
	private View mainView;
	private SlidingPaneLayout mParentView;

	public UserCenterLayout(Context context) {
		super(context);
		this.mContext = context;
		initUI();
	}

	public UserCenterLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mContext = context;
		initUI();
	}

	public UserCenterLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		initUI();
	}

	public void setParent(SlidingPaneLayout mParentView) {
		this.mParentView = mParentView;

	}

	private void initUI() {
		mainView = inflate(mContext, R.layout.user_center_main, this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (mParentView != null) {
			return mParentView.onTouchEvent(event);
		} else {
			return super.onTouchEvent(event);
		}
	}

}
