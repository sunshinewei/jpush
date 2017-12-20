package izijia.ccpress.com.jpushdemo.bean.news;

import java.util.List;

/**
 * Created by Admin on 2017/12/19.
 */

public class HomeTabBean{


//        public boolean has_more;
//        public String tip;
//        public boolean has_new_message;
//        public int max_time;
//        public int min_time;
//        public List<DataBean> data;

        public static class DataBean {

            public GroupBean group;
            public int type;
            public int display_time;
            public int online_time;


            public static class GroupBean {

                public String video_id;

                public String mp4_url;
                public String text;
                public int category_activity_start_time;

                public int digg_count;
                public double duration;

                public int create_time;
                public String share_url;
                public int go_detail_count;
                public String keywords;
                public long id;
                public int favorite_count;
                public DanmakuAttrsBean danmaku_attrs;
                public String m3u8_url;
                public LargeCoverBean large_cover;
                public String category_activity_schema_url;
                public int user_favorite;
                public int share_type;
                public String title;
                public String category_activity_text;
                public UserBean user;
                public int is_can_share;
                public int category_type;
                public String download_url;
                public int label;
                public String content;
                public int video_height;
                public int comment_count;
                public String id_str;
                public int media_type;
                public int share_count;
                public int type;
                public int category_id;
                public int status;
                public int has_comments;
                public String publish_time;
                public int user_bury;
                public OriginVideoBean origin_video;
                public ActivityBean activity;
                public String status_desc;
                public String neihan_hot_start_time;
                public int play_count;
                public int user_repin;
                public boolean quick_comment;
                public int category_activity_end_time;
                public MediumCoverBean medium_cover;
                public String neihan_hot_end_time;
                public int user_digg;
                public int video_width;
                public int online_time;
                public String category_name;
                public String flash_url;
                public boolean category_visible;
                public int bury_count;
                public boolean is_anonymous;
                public int repin_count;
                public boolean is_neihan_hot;
                public String uri;
                public int is_public_url;
                public int has_hot_comments;
                public int category_show_ranking;
                public String cover_image_uri;
                public int category_is_activity;
                public String cover_image_url;
                public NeihanHotLinkBean neihan_hot_link;
                public long group_id;
                public int is_video;
                public boolean allow_dislike;
                public int display_type;
                public List<DislikeReasonBean> dislike_reason;

                public static class _$360pVideoBean {
                    /**
                     * width : 640
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/1513756724.49/?video_id=134f993c3baf4e1db22fb21ebc26014a&quality=360p&line=0&is_gif=0&device_platform=android"},{"url":"http://ic.snssdk.com/neihan/video/playback/1513756724.49/?video_id=134f993c3baf4e1db22fb21ebc26014a&quality=360p&line=1&is_gif=0&device_platform=android"}]
                     * uri : 360p/134f993c3baf4e1db22fb21ebc26014a
                     * height : 360
                     */

                    public int width;
                    public String uri;
                    public int height;
                    public List<UrlListBean> url_list;

                    public static class UrlListBean {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/1513756724.49/?video_id=134f993c3baf4e1db22fb21ebc26014a&quality=360p&line=0&is_gif=0&device_platform=android
                         */

                        public String url;
                    }
                }

                public static class _$720pVideoBean {
                    /**
                     * width : 640
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/1513756724.49/?video_id=134f993c3baf4e1db22fb21ebc26014a&quality=720p&line=0&is_gif=0&device_platform=android"},{"url":"http://ic.snssdk.com/neihan/video/playback/1513756724.49/?video_id=134f993c3baf4e1db22fb21ebc26014a&quality=720p&line=1&is_gif=0&device_platform=android"}]
                     * uri : 720p/134f993c3baf4e1db22fb21ebc26014a
                     * height : 360
                     */

                    public int width;
                    public String uri;
                    public int height;
                    public List<UrlListBeanX> url_list;

                    public static class UrlListBeanX {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/1513756724.49/?video_id=134f993c3baf4e1db22fb21ebc26014a&quality=720p&line=0&is_gif=0&device_platform=android
                         */

                        public String url;
                    }
                }

                public static class _$480pVideoBean {
                    /**
                     * width : 640
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/1513756724.49/?video_id=134f993c3baf4e1db22fb21ebc26014a&quality=480p&line=0&is_gif=0&device_platform=android"},{"url":"http://ic.snssdk.com/neihan/video/playback/1513756724.49/?video_id=134f993c3baf4e1db22fb21ebc26014a&quality=480p&line=1&is_gif=0&device_platform=android"}]
                     * uri : 480p/134f993c3baf4e1db22fb21ebc26014a
                     * height : 360
                     */

                    public int width;
                    public String uri;
                    public int height;
                    public List<UrlListBeanXX> url_list;

                    public static class UrlListBeanXX {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/1513756724.49/?video_id=134f993c3baf4e1db22fb21ebc26014a&quality=480p&line=0&is_gif=0&device_platform=android
                         */

                        public String url;
                    }
                }

                public static class DanmakuAttrsBean {
                    /**
                     * allow_show_danmaku : 1
                     * allow_send_danmaku : 1
                     */

                    public int allow_show_danmaku;
                    public int allow_send_danmaku;
                }

                public static class LargeCoverBean {
                    /**
                     * url_list : [{"url":"http://p9.pstatp.com/large/4f67000e4580ba1d1118.webp"},{"url":"http://pb1.pstatp.com/large/4f67000e4580ba1d1118.webp"},{"url":"http://pb3.pstatp.com/large/4f67000e4580ba1d1118.webp"}]
                     * uri : large/4f67000e4580ba1d1118
                     */

                    public String uri;
                    public List<UrlListBeanXXX> url_list;

                    public static class UrlListBeanXXX {
                        /**
                         * url : http://p9.pstatp.com/large/4f67000e4580ba1d1118.webp
                         */

                        public String url;
                    }
                }

                public static class UserBean {
                    /**
                     * is_living : false
                     * user_id : 12157344015
                     * name : 六月201154813
                     * followings : 0
                     * user_verified : false
                     * ugc_count : 12
                     * avatar_url : http://p3.pstatp.com/medium/36410004e29baf8ad86e
                     * followers : 5
                     * is_following : false
                     * is_pro_user : false
                     * medals : [{"count":2,"icon_url":"http://p1.pstatp.com/obj/3b630009fc5cacb7c73e","name":"hot_content","small_icon_url":"http://p1.pstatp.com/obj/3b680001625ef138a4a3"}]
                     */

                    public boolean is_living;
                    public long user_id;
                    public String name;
                    public int followings;
                    public boolean user_verified;
                    public int ugc_count;
                    public String avatar_url;
                    public int followers;
                    public boolean is_following;
                    public boolean is_pro_user;
                    public List<MedalsBean> medals;

                    public static class MedalsBean {
                        /**
                         * count : 2
                         * icon_url : http://p1.pstatp.com/obj/3b630009fc5cacb7c73e
                         * name : hot_content
                         * small_icon_url : http://p1.pstatp.com/obj/3b680001625ef138a4a3
                         */

                        public int count;
                        public String icon_url;
                        public String name;
                        public String small_icon_url;
                    }
                }

                public static class OriginVideoBean {
                    public static class UrlListBeanXXXX {
                    }
                }

                public static class ActivityBean {
                }

                public static class MediumCoverBean {
                    public static class UrlListBeanXXXXX {
                    }
                }

                public static class NeihanHotLinkBean {
                }

                public static class DislikeReasonBean {
                    /**
                     * type : 1
                     * id : 386
                     * title : 情感
                     */

                    public int type;
                    public int id;
                    public String title;
                }
            }
        }
    }
