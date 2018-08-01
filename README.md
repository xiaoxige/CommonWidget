# 常用的控件
	* 空布局（加载中、加载为空、加载失败、自定义其他空布局）
	* 四中状态的TextView
	* 标题

# 用法
## 空布局（不会影响一丁点布局， 除了这几种状态， 还可以自定义自己的状态，详情可看Demo）
	直接实例化空布局类
	private EmptyLayout mEmptyLayout;
	/**
	 * Context: 不解释
	 * View：   你要在那个View上加空布局
	 * int：    相对位置
	 *          1. EmptyLayout.RELATIVESELF（View为ContentView）
	 *          2. EmptyLayout.RELATIVEPARENT (View的父亲为ContentView)
	 */
	mEmptyLayout = new EmptyLayout(Context, View, int);
	// 是否加载中时显示ContentView
	mEmptyLayout.setIsLoadingTransparent(Boolean);
	
	// 显示加载中
    mEmptyLayout.showLoading();
	// 显示数据为空
    mEmptyLayout.showEmpty();
	// 显示加载错误
    mEmptyLayout.showError();
	// 显示本来的布局
    mEmptyLayout.showContent();

## 四种状态的TextView（其实可以很多种， 这里只是定义了四种）
	设计这个的原因可以在drawable中定义多的状态。eg:
	<selector xmlns:android="http://schemas.android.com/apk/res/android" xmlns:app="http://schemas.android.com/apk/res-auto">

	    <item android:color="@android:color/black" app:state1="true" />
	    <item android:color="@android:color/holo_red_dark" app:state2="true" />
	    <item android:color="@android:color/holo_blue_dark" app:state3="true" />
	    <item android:color="@android:color/holo_green_light" app:state4="true" />
	    <item android:color="@android:color/black" />

	</selector>

	直接拿实例.showState1（）or .showState2（） or .showState3（） or .showState4（）即可
	你想下， 如果需要改变TestView的leftDrawable等而不是仅仅改变颜色， 这样做是很好的方式

## 标题
	可自定义左边视图、右边视图、中间视图（默认是文字）
	比较简单，就不再写用法了