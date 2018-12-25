package com.example.behaviordemo;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.telephony.TelephonyManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by mm on 2018/5/25.
 * <p>
 * 获取设备信息
 */

public class SystemOSUtils {

//    但是仅仅对Android手机有效，并且添加权限:android.permission.READ_PHONE_STATE

    public synchronized static String getid(Context context) {
        TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_PHONE_STATE},1000);

        }
        String ID = TelephonyMgr.getDeviceId();
        return ID;
    }

    /**
     * 二、WLAN MAC Address 使用网卡地址
     * 基本上的Android设备都配备WLAN，可以通过WLAN地址来作为设备码，同理，也需要加入android.permission.ACCESS_WIFI_STATE 权限，否则返回null.
     **/

    public synchronized static String getWIFIid(Context context) {
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        String WLANMAC = wm.getConnectionInfo().getMacAddress();
        return WLANMAC;
    }

    /**
     * 三、使用蓝牙地址作为标识
     * 在有蓝牙的设备上运行。并且要加入android.permission.BLUETOOTH 权限.
     **/
    public synchronized static String getBluetoothid(Context context) {
        BluetoothAdapter mBlueth = BluetoothAdapter.getDefaultAdapter();
        String mBluethId = mBlueth.getAddress();
        return mBluethId;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }


    /**
     * Combined Device  DB1DF24E1EEC6072BD4E815CABCAD7AF
     * ID
     * 综上所述，我们一共有五种方式取得设备的唯一标识。它们中的一些可能会返回null，或者由于硬件缺失、权限问题等获取失败。但你总能获得至少一个能用。所以，最好的方法就是通过拼接，或者拼接后的计算出的MD5值来产生一个结果。
     **/

    public static String getDeviceUniqueID(Context context) {
        String szImei = null;
        String m_szWLANMAC = null;
        TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        try {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

            }
            szImei = TelephonyMgr.getDeviceId();
        }catch (Exception e){

        }
        String m_szDevIDShort = "35" + //we make this look like a valid IMEI
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +
                Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +
                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +
                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +
                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +
                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10; //13 digits

        String m_szAndroidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);

        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        try {
            m_szWLANMAC=wm.getConnectionInfo().getMacAddress();
        }catch (Exception e){

        }

        BluetoothAdapter m_BluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
         // Local Bluetooth adapter
        String m_szBTMAC = m_BluetoothAdapter.getAddress();

        String m_szLongID = szImei + m_szDevIDShort + m_szAndroidID + m_szWLANMAC + m_szBTMAC;
        // compute md5
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(m_szLongID.getBytes(), 0, m_szLongID.length());
        // get md5 bytes
        byte p_md5Data[] = m.digest();
        // create a hex string
        String m_szUniqueID = new String();
        for (int i = 0; i < p_md5Data.length; i++) {
            int b = (0xFF & p_md5Data[i]);
            // if it is a single digit, make sure it have 0 in front (proper padding)
            if (b <= 0xF)
                m_szUniqueID += "0";
            // add number to string
            m_szUniqueID += Integer.toHexString(b);
        }   // hex string to uppercase
        m_szUniqueID = m_szUniqueID.toUpperCase();
        return m_szUniqueID;
    }


}

/**
 * 该标识符无需访问设备的资源，也跟设备类型无关。这种标识符是通过在程序安装后第一次运行后生成一个ID实现的，但该标识跟设备唯一标识不一样，它会因为不同的应用程序而产生不同的ID，而不是设备唯一ID。
 * 关键代码：
 * <p>
 * 当卸载应用后重新安装，返回值与之前的值不同
 */
class Installation {
    private static String sID = null;
    private static final String INSTALLATION = "INSTALLATION";

    public synchronized static String id(Context context) {
        if (sID == null) {
            File installation = new File(context.getFilesDir(), INSTALLATION);
            try {
                if (!installation.exists())
                    writeInstallationFile(installation);
                sID = readInstallationFile(installation);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sID;
    }

    private static String readInstallationFile(File installation) throws IOException {
        RandomAccessFile f = new RandomAccessFile(installation, "r");
        byte[] bytes = new byte[(int) f.length()];
        f.readFully(bytes);
        f.close();

        return new String(bytes);
    }

    private static void writeInstallationFile(File installation) throws IOException {
        FileOutputStream out = new FileOutputStream(installation);
        String id = UUID.randomUUID().toString();
        out.write(id.getBytes());
        out.close();
    }
}