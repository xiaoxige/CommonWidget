package cn.xiaoxige.commonwidgetlibrary.statetextview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import cn.xiaoxige.commonwidgetlibrary.R;

/**
 * Created by 小稀革 on 2017/7/23.
 * 4中互斥的状态
 */

public class State4TextView extends AppCompatTextView {

    private static final int[] STATE1 = {
            R.attr.state1
    };
    private static final int[] STATE2 = {
            R.attr.state2
    };
    private static final int[] STATE3 = {
            R.attr.state3
    };
    private static final int[] STATE4 = {
            R.attr.state4
    };

    private boolean mState1;
    private boolean mState2;
    private boolean mState3;
    private boolean mState4;

    public State4TextView(Context context) {
        this(context, null);
    }

    public State4TextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public State4TextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void showState1() {
        clearState();
        this.mState1 = true;
        refreshDrawableState();
    }

    public void showState2() {
        clearState();
        this.mState2 = true;
        refreshDrawableState();
    }

    public void showState3() {
        clearState();
        this.mState3 = true;
        refreshDrawableState();
    }

    public void showState4() {
        clearState();
        this.mState4 = true;
        refreshDrawableState();
    }

    public void clearState() {
        mState1 = false;
        mState2 = false;
        mState3 = false;
        mState4 = false;
        refreshDrawableState();
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 4);

        if (mState1) {
            mergeDrawableStates(drawableState, STATE1);
        }
        if (mState2) {
            mergeDrawableStates(drawableState, STATE2);
        }
        if (mState3) {
            mergeDrawableStates(drawableState, STATE3);
        }
        if (mState4) {
            mergeDrawableStates(drawableState, STATE4);
        }

        return drawableState;
    }
}
