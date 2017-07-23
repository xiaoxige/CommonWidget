package cn.xiaoxige.commonwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import cn.xiaoxige.commonwidgetlibrary.emptylayoutlibrary.EmptyLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mLlCenter;
    private EmptyLayout mEmptyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLlCenter = (LinearLayout) findViewById(R.id.llCenter);
        mEmptyLayout = new EmptyLayout(MainActivity.this, mLlCenter, EmptyLayout.RELATIVEPARENT);
        mEmptyLayout.showContent();
    }

    public void onClickEmpty(View v) {
        mEmptyLayout.showEmpty();
    }

    public void onClickError(View v) {
        mEmptyLayout.showError();
    }

    public void onClickLoading(View v) {
        mEmptyLayout.showLoading();
    }

    public void onClickCenter(View v) {
        mEmptyLayout.showContent();
    }
}
