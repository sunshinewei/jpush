package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;

import java.io.IOException;

import izijia.ccpress.com.mylibrary.base.BaseCommonActivity;

public class MainActivity extends BaseCommonActivity {

    @Override
    public int setRootView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();
    }

    String server="127.0.0.1";
    @Override
    public void initData() {
        super.initData();
        int port=5222;
        XMPPTCPConnectionConfiguration.Builder builder = XMPPTCPConnectionConfiguration.builder();
//        builder.setServiceName(server);
        builder.setHost(server);
        builder.setPort(port);
        builder.setCompressionEnabled(false);
        builder.setSendPresence(true);
        builder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        XMPPTCPConnection connection = new XMPPTCPConnection(builder.build());

        try {
            connection.connect();
        } catch (SmackException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMPPException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
