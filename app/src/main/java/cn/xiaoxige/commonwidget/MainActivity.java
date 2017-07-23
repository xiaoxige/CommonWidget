package cn.xiaoxige.commonwidget;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import cn.xiaoxige.commonwidgetlibrary.basetitlebar.BaseTitleBar;
import cn.xiaoxige.commonwidgetlibrary.emptylayoutlibrary.EmptyLayout;
import cn.xiaoxige.commonwidgetlibrary.statetextview.State4TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mLlCenter;
    private EmptyLayout mEmptyLayout;
    private BaseTitleBar mBaseTitleBar;
    private State4TextView mStateTextView;
    private int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBaseTitleBar = (BaseTitleBar) findViewById(R.id.baseTitleBar);
        mLlCenter = (LinearLayout) findViewById(R.id.llCenter);
        mStateTextView = (State4TextView) findViewById(R.id.stateText);

        mEmptyLayout = new EmptyLayout(MainActivity.this, mLlCenter, EmptyLayout.RELATIVEPARENT);
        mEmptyLayout.showContent();
        mBaseTitleBar.setRightView(View.inflate(MainActivity.this, R.layout.right_ment_layout, null));
        registerListener();
    }

    private void registerListener() {
        mBaseTitleBar.setOnTitleBarListener(new BaseTitleBar.onClickTitleBarListener() {
            @Override
            public void onClick(@IdRes int id) {
                if (id == R.id.right_layout) {
                    int n = state++ % 4;
                    if (n == 0) {
                        mStateTextView.showState1();
                    } else if (n == 1) {
                        mStateTextView.showState2();
                    } else if (n == 2) {
                        mStateTextView.showState3();
                    } else {
                        mStateTextView.showState4();
                    }
                }
            }
        });
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
