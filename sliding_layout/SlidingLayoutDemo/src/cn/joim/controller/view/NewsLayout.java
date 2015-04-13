package cn.joim.controller.view;

import cn.joim.controller.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class NewsLayout extends RelativeLayout {

	private Context mContext;

	private View mainView;
	private Button mBtn;

	private OnMenuClickListener mMenuClickListener;

	public NewsLayout(Context context) {
		super(context);
		this.mContext = context;
		initUI();
	}

	public NewsLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mContext = context;
		initUI();
	}

	public NewsLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		initUI();
	}

	private void initUI() {
		mainView = inflate(mContext, R.layout.news_master_main, this);
		mBtn = (Button) findViewById(R.id.btn);

		mBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mMenuClickListener != null) {
					mMenuClickListener.onMenuClick(mBtn);
				}
			}
		});
	}

	public void setOnMenuClickListener(OnMenuClickListener clickListener) {
		this.mMenuClickListener = clickListener;
	}

	public interface OnMenuClickListener {

		public void onMenuClick(View view);

	}

}
