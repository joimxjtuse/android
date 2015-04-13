package cn.joim.controller;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import cn.joim.controller.view.NewsLayout;
import cn.joim.controller.view.NewsLayout.OnMenuClickListener;
import cn.joim.controller.view.UserCenterLayout;

public class MainActivity extends Activity {

	private SlidingPaneLayout mSlidingPaneLayout;
	private NewsLayout mNewsLayout;
	private UserCenterLayout mUserCenterLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
	}

	private void initUI() {
		mSlidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.main_slide_panel);
		mUserCenterLayout = (UserCenterLayout) findViewById(R.id.layout_user_center);
		mNewsLayout = (NewsLayout) findViewById(R.id.layout_news_master);

		mUserCenterLayout.setParent(mSlidingPaneLayout);
		mNewsLayout.setOnMenuClickListener(new OnMenuClickListener() {

			@Override
			public void onMenuClick(View view) {
				if (mSlidingPaneLayout.isOpen()) {
					mSlidingPaneLayout.closePane();
				} else {
					mSlidingPaneLayout.openPane();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		if (mSlidingPaneLayout.isOpen()) {
			mSlidingPaneLayout.closePane();
		} else {
			super.onBackPressed();
		}
	}
}
