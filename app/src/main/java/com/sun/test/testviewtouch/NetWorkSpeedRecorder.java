package com.sun.test.testviewtouch;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class NetWorkSpeedRecorder {

    private static final String TAG = "NetWorkUtil";

    static Context context;
    static boolean currentApp;
    static long lastTime;
    static long[] lastBytes;
    static TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (context != null) {
                long[] currentBytes = getCurrentBytes(context);
                long currentTimeMillis = System.currentTimeMillis();

                float period = 1.0F * (currentTimeMillis - lastTime) / 1000;
                long rxSpeed = (long) (1.0F * (currentBytes[0] - lastBytes[0]) / 1024 / period);
                long txSpeed = (long) (1.0F * (currentBytes[1] - lastBytes[1]) / 1024 / period);

                Log.i(TAG, "------NetWorkUtil------run");
                Log.i(TAG, getInfo(getAPNType(context), rxSpeed, txSpeed));

                lastBytes = currentBytes;
                lastTime = currentTimeMillis;
            }
        }
    };

    public static void start(Context context, boolean currentApp) {
        NetWorkSpeedRecorder.context = context;
        NetWorkSpeedRecorder.currentApp = currentApp;
        lastBytes = getCurrentBytes(context);
        lastTime = System.currentTimeMillis();
        new Timer().schedule(task, 0, 1000);
    }

    static String getInfo(String state, long rx, long tx) {
        return String.format("网络类型:%s\n"
                + "下载速度:%d kb/s\n"
                + "上传速度:%d kb/s\n", state, rx, tx);
    }

    private static long[] getCurrentBytes(Context context) {
        int uid = context.getApplicationInfo().uid;
        long uidRxBytes =
                currentApp ? TrafficStats.getUidRxBytes(uid) : TrafficStats.getTotalRxBytes();
        long uidTxBytes =
                currentApp ? TrafficStats.getUidTxBytes(uid) : TrafficStats.getTotalTxBytes();

        return uidRxBytes == -1 || uidTxBytes == -1
                ? getTotalBytesManual(uid)
                : new long[]{uidRxBytes, uidTxBytes};
    }

    private static long[] getTotalBytesManual(int localUid) {
        File dir = new File("/proc/uid_stat/");
        String[] children = dir.list();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < children.length; i++) {
            stringBuffer.append(children[i]);
            stringBuffer.append("   ");
        }
        if (!Arrays.asList(children).contains(String.valueOf(localUid))) {
            return new long[]{0, 0};
        }
        File uidFileDir = new File("/proc/uid_stat/" + String.valueOf(localUid));
        File uidActualFileReceived = new File(uidFileDir, "tcp_rcv");
        File uidActualFileSent = new File(uidFileDir, "tcp_snd");
        String textReceived = "0";
        String textSent = "0";
        try {
            BufferedReader brReceived = new BufferedReader(new FileReader(uidActualFileReceived));
            BufferedReader brSent = new BufferedReader(new FileReader(uidActualFileSent));
            String receivedLine;
            String sentLine;

            if ((receivedLine = brReceived.readLine()) != null) {
                textReceived = receivedLine;
            }
            if ((sentLine = brSent.readLine()) != null) {
                textSent = sentLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new long[]{Long.valueOf(textReceived).longValue(),
                Long.valueOf(textSent).longValue()};
    }

    public static String getAPNType(Context context) {
        //结果返回值
        String stateStr = "无网络";
        int netType = 0;
        //获取手机所有连接管理对象
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取NetworkInfo对象
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        //NetworkInfo对象为空 则代表没有网络
        if (networkInfo == null) {
            return stateStr;
        }
        //否则 NetworkInfo对象不为空 则获取该networkInfo的类型
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_WIFI) {
            //WIFI
            netType = 1;
        } else if (nType == ConnectivityManager.TYPE_MOBILE) {
            int nSubType = networkInfo.getSubtype();
            TelephonyManager telephonyManager = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            //3G   联通的3G为UMTS或HSDPA 电信的3G为EVDO
            if (nSubType == TelephonyManager.NETWORK_TYPE_LTE
                    && !telephonyManager.isNetworkRoaming()) {
                netType = 4;
            } else if (nSubType == TelephonyManager.NETWORK_TYPE_UMTS
                    || nSubType == TelephonyManager.NETWORK_TYPE_HSDPA
                    || nSubType == TelephonyManager.NETWORK_TYPE_EVDO_0
                    && !telephonyManager.isNetworkRoaming()) {
                netType = 3;
                //2G 移动和联通的2G为GPRS或EGDE，电信的2G为CDMA
            } else if (nSubType == TelephonyManager.NETWORK_TYPE_GPRS
                    || nSubType == TelephonyManager.NETWORK_TYPE_EDGE
                    || nSubType == TelephonyManager.NETWORK_TYPE_CDMA
                    && !telephonyManager.isNetworkRoaming()) {
                netType = 2;
            } else {
                netType = 2;
            }
        }
        switch (netType) {
            case 4:
                stateStr = "4G";
                break;
            case 3:
                stateStr = "3G";
                break;
            case 2:
                stateStr = "2G";
                break;
            case 1:
                stateStr = "WIFI";
                break;
            default:
                break;
        }
        return stateStr;
    }
}
