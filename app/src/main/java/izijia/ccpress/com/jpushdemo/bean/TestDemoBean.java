package izijia.ccpress.com.jpushdemo.bean;

import java.util.List;

/**
 * Created by Admin on 2017/11/22.
 */

public class TestDemoBean {

    public int code;
    public String msg;
    public DataBean data;

    public static class DataBean {


        public int id;
        public String spaceName;
        public String spaceImage;
        public String spaceGalley;
        public String spaceMoney;
        public int spaceLoadNumber;
        public int spaceSquareMetre;
        public String spaceAreaPath;
        public String spaceCover;
        public String spaceAttention;
        public int spaceStatus;
        public String spaceDesc;
        public ShareBean share;
        public String costStatement;
        public double howFar;
        public List<?> purpose;
        public List<?> facilities;
        public List<?> aqi;

        public static class ShareBean {
            /**
             * name : 12
             * url : www.baidu.com
             * info : 详细信息
             * logo : s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
             */

            public String name;
            public String url;
            public String info;
            public String logo;
        }
    }
}
