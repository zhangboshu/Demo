package com.zhangboshu.demo.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by ZhangBoshu on 2017/2/20.
 */

public class NetWorkStateReceiver extends BroadcastReceiver {


    private NetStateInterface n;

    @Override
    public void onReceive(Context context, Intent intent) {
        //检测API是不是小于23，因为到了API23之后getNetworkInfo(int networkType)方法被弃用
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {

            //获得ConnectivityManager对象
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            //获取ConnectivityManager对象对应的NetworkInfo对象
            //获取WIFI连接的信息
            NetworkInfo wifiNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            //获取移动数据连接的信息
            NetworkInfo dataNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifiNetworkInfo.isConnected() && dataNetworkInfo.isConnected()) {
                n.getNetwork("WIFI");
            } else if (wifiNetworkInfo.isConnected() && !dataNetworkInfo.isConnected()) {
                n.getNetwork("WIFI");
            } else if (!wifiNetworkInfo.isConnected() && dataNetworkInfo.isConnected()) {
                n.getNetwork("MOBILE");
            } else {
                n.getNetwork("NO");
            }
            //API大于23时使用下面的方式进行网络监听
        }else {
            //获得ConnectivityManager对象
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            //获取所有网络连接的信息
            Network[] networks = connMgr.getAllNetworks();
            //通过循环将网络信息逐个取出来
            if (networks.length != 0){
                for (int i=0; i < networks.length; i++){
                    //获取ConnectivityManager对象对应的NetworkInfo对象
                    NetworkInfo networkInfo = connMgr.getNetworkInfo(networks[i]);
                    n.getNetwork(networkInfo.getTypeName());
                    if (networkInfo.getTypeName().equals("WIFI")){
                        break;
                    }
                }
            }else{
                n.getNetwork("NO");
            }
        }
    }

    public void getNetState(NetStateInterface n){
        this.n = n;
    }

    public interface NetStateInterface{
        void getNetwork(String netState);
    }

}
