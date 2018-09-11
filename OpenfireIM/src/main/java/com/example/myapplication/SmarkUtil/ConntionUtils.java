package com.example.myapplication.SmarkUtil;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.chat2.IncomingChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

import java.io.IOException;

/**
 * Created by mm on 2018/9/10.
 */

public class ConntionUtils {

    public static synchronized void getInstance(String useNmae,String password) {
        //初始化XMPPTCPConnection相关配置
        AbstractXMPPConnection connection = null;
        String server = "192.168.50.89";
        if (connection == null) {
            XMPPTCPConnectionConfiguration.Builder builder = XMPPTCPConnectionConfiguration.builder();
            //设置连接超时的最大时间
            builder.setConnectTimeout(10000);
            //设置登录openfire的用户名和密码
            builder.setUsernameAndPassword("bbb", "111111");
            //设置安全模式
            builder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);

            System.out.println("连接成功1");
            try {
                builder.setResource("Android");
                builder.setResource("SomeResource");
                builder.setXmppDomain("jabber.org");
            } catch (XmppStringprepException e) {
                e.printStackTrace();
            }
            //设置服务器名称
//            builder.setServiceName(server);
            //设置主机地址
            builder.setHost(server);
            //设置端口号
            builder.setPort(5222);
            //是否查看debug日志
            builder.setDebuggerEnabled(true);
            connection = new XMPPTCPConnection(builder.build());
            try {
                connection.connect();
                connection.login();

                System.out.println("连接成功");
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

}
