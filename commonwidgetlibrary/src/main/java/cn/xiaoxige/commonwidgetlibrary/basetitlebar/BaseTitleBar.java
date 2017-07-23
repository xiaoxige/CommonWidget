package cn.xiaoxige.commonwidgetlibrary.basetitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import cn.xiaoxige.commonwidgetlibrary.R;

/**
 * Created by 小稀革 on 2017/7/23.
 */

public class BaseTitleBar extends FrameLayout {

    private Context mContext;
    private ViewGroup mVgLeft;
    private ViewGroup mVgCenter;
    private ViewGroup mVgRight;
    private View mBollomLine;

    private boolean mIsShowLeftBack;
    private boolean mIsShowBollomLine;
    private String mCenterTitle;

    public BaseTitleBar(@NonNull Context context) {
        this(context, null);
    }

    public BaseTitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseTitleBar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initDefaultData(attrs);
        initRootViews();
        initDefaultLeft();
        initDefaultCenter();
        initDefaultRight();
        registerListener();
    }

    public void setCenterTitle(String centerTitle) {
        mCenterTitle = centerTitle;
        initDefaultCenter();
    }

    public void setLeftView(View view) {
        addLeftView(view);
    }

    public void setCenterView(View view) {
        addCenterView(view);
    }

    public void setRightView(View view) {
        addRightView(view);
    }

    private void initRootViews() {
        View.inflate(mContext, R.layout.basetitlebar_layout, this);
        mVgLeft = (ViewGroup) findViewById(R.id.left_layout);
        mVgCenter = (ViewGroup) findViewById(R.id.center_layout);
        mVgRight = (ViewGroup) findViewById(R.id.right_layout);
        mBollomLine = findViewById(R.id.bollom_line);
        mBollomLine.setVisibility(mIsShowBollomLine ? VISIBLE : GONE);
    }

    private void initDefaultData(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.BaseTitleBar);
        mIsShowLeftBack = typedArray.getBoolean(R.styleable.BaseTitleBar_left_back, true);
        mIsShowBollomLine = typedArray.getBoolean(R.styleable.BaseTitleBar_show_bollom_line, false);
        mCenterTitle = typedArray.getString(R.styleable.BaseTitleBar_center_title);
        typedArray.recycle();
    }

    private void initDefaultLeft() {
        if (mIsShowLeftBack) {
            ImageView iconBack = new ImageView(mContext);
            iconBack.setImageResource(R.mipmap.icon_leftback);
            addLeftView(iconBack);
        }
    }

    private void initDefaultCenter() {
        if (!TextUtils.isEmpty(mCenterTitle)) {
            TextView title = new TextView(mContext);
            title.setText(mCenterTitle);
            addCenterView(title);
        }
    }

    private void initDefaultRight() {

    }


    private void registerListener() {
        mVgLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTitleBarListener != null) {
                    mTitleBarListener.onClick(R.id.left_layout);
                }
            }
        });
        mVgCenter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTitleBarListener != null) {
                    mTitleBarListener.onClick(R.id.center_layout);
                }
            }
        });
        mVgRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTitleBarListener != null) {
                    mTitleBarListener.onClick(R.id.right_layout);
                }
            }
        });
    }

    private void addLeftView(View view) {
        mVgLeft.removeAllViews();
        mVgLeft.addView(view);
    }

    private void addCenterView(View view) {
        mVgCenter.removeAllViews();
        mVgCenter.addView(view);
    }

    private void addRightView(View view) {
        mVgRight.removeAllViews();
        mVgRight.addView(view);
    }

    private onClickTitleBarListener mTitleBarListener;

    public void setOnTitleBarListener(onClickTitleBarListener titleBarListener) {
        this.mTitleBarListener = titleBarListener;
    }

    public interface onClickTitleBarListener {
        void onClick(@IdRes int id);
    }
}
