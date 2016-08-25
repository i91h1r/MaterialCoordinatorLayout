#MaterialCoordinatorLayout + Fragment+viewpager 滑动折叠image,toolbar
=============================
----------
<br>[![TypeScript](https://badges.frapsoft.com/typescript/version/typescript-v18.svg?v=101)](https://github.com/hyr0318/MaterialCoordinatorlayout/)  [![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.png?v=103)](https://github.com/hyr0318/MaterialCoordinatorlayout/)    
# 一 介绍：
    Material Design + Fragment +Viewpager 上滑 头部image 隐藏，Toolbar 固定在顶部位置 5.0 系统以上实现图片状态栏沉浸式

#####截图：
![image](https://github.com/hyr0318/MaterialCoordinatorLayout/image/2.gif)



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


### 三 常见问题：
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
