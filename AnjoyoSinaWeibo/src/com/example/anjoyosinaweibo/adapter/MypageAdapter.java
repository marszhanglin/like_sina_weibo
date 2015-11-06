package com.example.anjoyosinaweibo.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MypageAdapter extends PagerAdapter{

	
	List<View> views;
	public MypageAdapter(List<View> views){
		this.views=views;
	}
	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		if (position > 0) {
			((ViewPager) container).removeView(views.get(position));
		}
		System.out.println("销毁视图"+position);
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		System.out.println("创建视图"+position);
		try {
			((ViewPager) container).addView(views.get(position), 0);
		} catch (Exception e) {
		}
		return views.get(position);
	}

	
	
	
	
}
