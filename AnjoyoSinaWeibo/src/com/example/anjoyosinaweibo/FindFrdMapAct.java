package com.example.anjoyosinaweibo;

import android.os.Bundle;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class FindFrdMapAct extends WeiboAct{
    String key="993A3EC6FB71AA6DD6F9EDD10D022E435BE4CBB0";
    BMapManager mBMapMan=null;
    MapView mMapView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化地图管理
        mBMapMan=new BMapManager(getApplicationContext());
        mBMapMan.init(key, null);
        setContentView(R.layout.findfrdmap_layout);
        mMapView=(MapView) findViewById(R.id.bmapsView);
        mMapView.setBuiltInZoomControls(true);
      //设置启用内置的缩放控件
      MapController mMapController=mMapView.getController();
     // 得到mMapView的控制权,可以用它控制和驱动平移和缩放
     GeoPoint point =new GeoPoint((int)(39.915* 1E6),(int)(116.404* 1E6));
     //用给定的经纬度构造一个GeoPoint，单位是微度 (度 * 1E6)
     mMapController.setCenter(point);//设置地图中心点
     mMapController.setZoom(12);//设置地图zoom级别
    }
    
    
    
    @Override
    protected void onDestroy(){
            mMapView.destroy();
            if(mBMapMan!=null){
                    mBMapMan.destroy();
                    mBMapMan=null;
            }
            super.onDestroy();
    }
    @Override
    protected void onPause(){
            mMapView.onPause();
            if(mBMapMan!=null){
                    mBMapMan.stop();
            }
            super.onPause();
    }
    @Override
    protected void onResume(){
            mMapView.onResume();
            if(mBMapMan!=null){
                    mBMapMan.start();
            }
            super.onResume();
    }



}
