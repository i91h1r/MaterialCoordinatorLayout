#MaterialCoordinatorLayout + Fragment+viewpager 滑动折叠image,toolbar
=============================
----------
<br>[![TypeScript](https://badges.frapsoft.com/typescript/version/typescript-v18.svg?v=101)](https://github.com/hyr0318/MaterialCoordinatorlayout/)  [![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.png?v=103)](https://github.com/hyr0318/MaterialCoordinatorlayout/)    
# 一 介绍：
    Material Design + Fragment +Viewpager 上滑 头部image 隐藏，Toolbar 固定在顶部位置 5.0 系统以上实现图片状态栏沉浸式

#####截图：
![image](https://github.com/hyr0318/MaterialCoordinatorLayout/blob/master/image/2.gif)



## 二 用法：
1. 使用CoordinatorLayout 作为跟布局<br><pre>android:fitsSystemWindows="true"</pre> 视情况设置，会导致状态栏和内容重叠
2. 要使用toolbar折叠或者包含一个图片实现折叠效果 使用AppBarLayout 布局包含CollapsingToolbarLayout
3. CollapsingToolbarLayout作用是提供了一个**可以折叠的Toolbar**，它继承至FrameLayout ,给它设置**layout_scrollFlags**，它可以控制包含在CollapsingToolbarLayout中的控件(如：ImageView、Toolbar)在**响应layout_behavior事件时作出相应的scrollFlags滚动事件(移除屏幕或固定在屏幕顶端)。**<br>**layout_scrollFlags属性值**:
	* **scroll** - 想滚动就必须设置这个。
	* **exitUntilCollapsed** - 向上滚动时收缩View，但可以固定Toolbar一直在上面
	* **enterAlways** - 实现quick return效果, 当向下移动时，立即显示View（比如Toolbar)。
	* **enterAlwaysCollapsed** - 当你的View已经设置minHeight属性又使用此标志时，你的View只能以最小高度进入，只有当滚动视图到达顶部时才扩大到完整高度。
	* **contentScrim** - 设置当完全CollapsingToolbarLayout折叠(收缩)后的背景颜色。
	* **expandedTitleMarginStart** - 设置扩张时候(还没有收缩时)title向左填充的距离。
	#####ImageView属性 layout_collapseMode (折叠模式) - 有两个值:：
	* **pin** -  设置为这个模式时，当CollapsingToolbarLayout完全收缩后，Toolbar还可以保留在屏幕上。
	* **parallax** - 设置为这个模式时，在内容滚动时，CollapsingToolbarLayout中的View（比如ImageView)也可以同时滚动，实现视差滚动效果，通常和layout_collapseParallaxMultiplier(设置视差因子)搭配使用。
	* **layout_collapseParallaxMultiplier**(视差因子) - 设置视差滚动因子，值为：0~1。 值越大视差越大
	#####在Toolbar控件中：layout_collapseMode(折叠模式)：为pin。 折叠之后 toolbar保留在头部
	#####CollapsingToolbarLayout 中两个属性 setStatusBarScrim  setContentScrim
	* setStatusBarScrim 折叠之后设置状态栏为图片背景色
	* setContentScrim 折叠之后设置保留位置的背景色(可在xml内设置 也可以代码设置)

<br>4.  **给可滑动的组件**，NestedScrollView 或者Viewpager设置<pre>app:layout_behavior="@string/appbar_scrolling_view_behavior"<android.support.v4.widget.NestedScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"/><br>
    <android.support.v4.view.ViewPager
        android:id="@+id/vp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"/></pre>
**这里注意:** 
<br>当可滑动组件是viewpager +Fragment 时候，在Fragmetn内一定要用RecycleView作为滑动组件 不可用listview 不然会造成和图片伸缩滑动造成冲突，导致listview 滑动图片伸缩现象出现
<br>当你要设置的滑动组件只是recycleview时候可用NestedScrollView包裹

### 三 总结：
要有滑动伸缩效果 需要三点：<br>
1.  CoordinatorLayout 作为父容器<br>
2.  给需要滑动的组件设置<pre>app:layout_scrollFlags=”scroll|enterAlways” </pre>属性<br>
3.  给可滑动属性设置<pre>app:layout_behavior="@string/appbar_scrolling_view_behavior"属性</pre>
### 四 常见问题：
* Caused by: java.lang.IllegalStateException: This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.
<br>**解决**：
<pre>android {
   		defaultConfig {
   			vectorDrawables.useSupportLibrary = true
  		 }
</pre>
<br>或是因为不是使用的2.0.0 以上的gradle  在项目的build.gradle更改gradle为2.0.0 以上，然后再gradle-wrapper.properties 中设置<pre>distributionUrl=https\://services.gradle.org/distributions/gradle-x.xx-all.zip</pre> <br>

####Development by
<br>Developer / Author: hyr0318
