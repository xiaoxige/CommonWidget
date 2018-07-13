package cn.xiaoxige.commonwidget;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.xiaoxige.commonwidgetlibrary.emptylayoutlibrary.EmptyLayout;

/**
 * @author by zhuxiaoan on 2018/7/13 0013.
 */

public class CustomEmptyLayout extends EmptyLayout {

    private Button btnCustom;

    public CustomEmptyLayout(Context context, View view) {
        super(context, view);
    }

    public CustomEmptyLayout(Context context, View view, int relativeWho) {
        super(context, view, relativeWho);
        initView();
        registerListener();
    }

    private void initView() {
        View view = mInFlater.inflate(R.layout.custom_one, null, false);
        btnCustom = (Button) view.findViewById(R.id.btnCustom);
        addCustomLayout(100, view);
    }


    private void registerListener() {
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "自定义布局的按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showCustumLayout() {
        mState = 100;
        showInvalidate();
    }

}
