package izijia.ccpress.com.jpushdemo.bean;

import java.util.List;

/**
 * Created by Admin on 2017/11/22.
 */

public class TestDemoBean {


    /**
     * code : 10000
     * msg : 成功
     * data : {"id":5,"spaceName":"12","spaceImage":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg","spaceGalley":"","spaceMoney":"123.00","spaceLoadNumber":123,"spaceSquareMetre":123,"spaceAreaPath":"123","spaceCover":"","spaceAttention":"","spaceStatus":1,"spaceDesc":"北方","purpose":[],"facilities":[],"share":{"name":"12","url":"www.baidu.com","info":"详细信息","logo":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg"},"aqi":[],"costStatement":"空间使用费每小时123.00元,每6分钟多少","howFar":8088.82}
     */

    public int code;
    public String msg;
    public DataBean data;

    @Override
    public String toString() {
        return "TestDemoBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * id : 5
         * spaceName : 12
         * spaceImage : s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg
         * spaceGalley :
         * spaceMoney : 123.00
         * spaceLoadNumber : 123
         * spaceSquareMetre : 123
         * spaceAreaPath : 123
         * spaceCover :
         * spaceAttention :
         * spaceStatus : 1
         * spaceDesc : 北方
         * purpose : []
         * facilities : []
         * share : {"name":"12","url":"www.baidu.com","info":"详细信息","logo":"s.east-profit.com/uploads/20170921/122537fcf2b9376afa93d148708adac6.jpg"}
         * aqi : []
         * costStatement : 空间使用费每小时123.00元,每6分钟多少
         * howFar : 8088.82
         */

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

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", spaceName='" + spaceName + '\'' +
                    ", spaceImage='" + spaceImage + '\'' +
                    ", spaceGalley='" + spaceGalley + '\'' +
                    ", spaceMoney='" + spaceMoney + '\'' +
                    ", spaceLoadNumber=" + spaceLoadNumber +
                    ", spaceSquareMetre=" + spaceSquareMetre +
                    ", spaceAreaPath='" + spaceAreaPath + '\'' +
                    ", spaceCover='" + spaceCover + '\'' +
                    ", spaceAttention='" + spaceAttention + '\'' +
                    ", spaceStatus=" + spaceStatus +
                    ", spaceDesc='" + spaceDesc + '\'' +
                    ", share=" + share +
                    ", costStatement='" + costStatement + '\'' +
                    ", howFar=" + howFar +
                    ", purpose=" + purpose +
                    ", facilities=" + facilities +
                    ", aqi=" + aqi +
                    '}';
        }

        public int getId() {
            return id;
        }

        public DataBean setId(int id) {
            this.id = id;
            return this;
        }

        public String getSpaceName() {
            return spaceName;
        }

        public DataBean setSpaceName(String spaceName) {
            this.spaceName = spaceName;
            return this;
        }

        public String getSpaceImage() {
            return spaceImage;
        }

        public DataBean setSpaceImage(String spaceImage) {
            this.spaceImage = spaceImage;
            return this;
        }

        public String getSpaceGalley() {
            return spaceGalley;
        }

        public DataBean setSpaceGalley(String spaceGalley) {
            this.spaceGalley = spaceGalley;
            return this;
        }

        public String getSpaceMoney() {
            return spaceMoney;
        }

        public DataBean setSpaceMoney(String spaceMoney) {
            this.spaceMoney = spaceMoney;
            return this;
        }

        public int getSpaceLoadNumber() {
            return spaceLoadNumber;
        }

        public DataBean setSpaceLoadNumber(int spaceLoadNumber) {
            this.spaceLoadNumber = spaceLoadNumber;
            return this;
        }

        public int getSpaceSquareMetre() {
            return spaceSquareMetre;
        }

        public DataBean setSpaceSquareMetre(int spaceSquareMetre) {
            this.spaceSquareMetre = spaceSquareMetre;
            return this;
        }

        public String getSpaceAreaPath() {
            return spaceAreaPath;
        }

        public DataBean setSpaceAreaPath(String spaceAreaPath) {
            this.spaceAreaPath = spaceAreaPath;
            return this;
        }

        public String getSpaceCover() {
            return spaceCover;
        }

        public DataBean setSpaceCover(String spaceCover) {
            this.spaceCover = spaceCover;
            return this;
        }

        public String getSpaceAttention() {
            return spaceAttention;
        }

        public DataBean setSpaceAttention(String spaceAttention) {
            this.spaceAttention = spaceAttention;
            return this;
        }

        public int getSpaceStatus() {
            return spaceStatus;
        }

        public DataBean setSpaceStatus(int spaceStatus) {
            this.spaceStatus = spaceStatus;
            return this;
        }

        public String getSpaceDesc() {
            return spaceDesc;
        }

        public DataBean setSpaceDesc(String spaceDesc) {
            this.spaceDesc = spaceDesc;
            return this;
        }

        public ShareBean getShare() {
            return share;
        }

        public DataBean setShare(ShareBean share) {
            this.share = share;
            return this;
        }

        public String getCostStatement() {
            return costStatement;
        }

        public DataBean setCostStatement(String costStatement) {
            this.costStatement = costStatement;
            return this;
        }

        public double getHowFar() {
            return howFar;
        }

        public DataBean setHowFar(double howFar) {
            this.howFar = howFar;
            return this;
        }

        public List<?> getPurpose() {
            return purpose;
        }

        public DataBean setPurpose(List<?> purpose) {
            this.purpose = purpose;
            return this;
        }

        public List<?> getFacilities() {
            return facilities;
        }

        public DataBean setFacilities(List<?> facilities) {
            this.facilities = facilities;
            return this;
        }

        public List<?> getAqi() {
            return aqi;
        }

        public DataBean setAqi(List<?> aqi) {
            this.aqi = aqi;
            return this;
        }
    }
}
