package izijia.ccpress.com.jpushdemo.bean.news;

import java.util.List;

/**
 * Created by Admin on 2017/12/19.
 */

public class HomeTabBean{

    public DataBeanX data;

    @Override
    public String toString() {
        return "HomeTabBean{" +
                "data=" + data +
                '}';
    }

    public static class DataBeanX {
        @Override
        public String toString() {
            return "DataBeanX{" +
                    "has_more=" + has_more +
                    ", tip='" + tip + '\'' +
                    ", has_new_message=" + has_new_message +
                    ", max_time=" + max_time +
                    ", min_time=" + min_time +
                    ", data=" + data +
                    '}';
        }

        public boolean has_more;
        public String tip;
        public boolean has_new_message;
        public int max_time;
        public int min_time;
        public List<DataBean> data;

        public static class DataBean {
            @Override
            public String toString() {
                return "DataBean{" +
                        "group=" + group +
                        ", type=" + type +
                        ", display_time=" + display_time +
                        ", online_time=" + online_time +
                        ", comments=" + comments +
                        '}';
            }

            public GroupBean group;
            public int type;
            public int display_time;
            public int online_time;
            public List<?> comments;

            public static class GroupBean {
                public String video_id;
                public String mp4_url;
                public String text;
                public int category_activity_start_time;

                @Override
                public String toString() {
                    return "GroupBean{" +
                            "video_id='" + video_id + '\'' +
                            ", mp4_url='" + mp4_url + '\'' +
                            ", text='" + text + '\'' +
                            ", category_activity_start_time=" + category_activity_start_time +
                            ", digg_count=" + digg_count +
                            ", duration=" + duration +
                            ", create_time=" + create_time +
                            ", share_url='" + share_url + '\'' +
                            ", go_detail_count=" + go_detail_count +
                            ", keywords='" + keywords + '\'' +
                            ", id=" + id +
                            ", favorite_count=" + favorite_count +
                            ", danmaku_attrs=" + danmaku_attrs +
                            ", m3u8_url='" + m3u8_url + '\'' +
                            ", large_cover=" + large_cover +
                            ", video_wh_ratio=" + video_wh_ratio +
                            ", category_activity_schema_url='" + category_activity_schema_url + '\'' +
                            ", user_favorite=" + user_favorite +
                            ", share_type=" + share_type +
                            ", title='" + title + '\'' +
                            ", category_activity_text='" + category_activity_text + '\'' +
                            ", user=" + user +
                            ", is_can_share=" + is_can_share +
                            ", category_type=" + category_type +
                            ", download_url='" + download_url + '\'' +
                            ", label=" + label +
                            ", content='" + content + '\'' +
                            ", video_height=" + video_height +
                            ", comment_count=" + comment_count +
                            ", id_str='" + id_str + '\'' +
                            ", media_type=" + media_type +
                            ", share_count=" + share_count +
                            ", type=" + type +
                            ", category_id=" + category_id +
                            ", status=" + status +
                            ", has_comments=" + has_comments +
                            ", publish_time='" + publish_time + '\'' +
                            ", user_bury=" + user_bury +
                            ", origin_video=" + origin_video +
                            ", activity=" + activity +
                            ", status_desc='" + status_desc + '\'' +
                            ", neihan_hot_start_time='" + neihan_hot_start_time + '\'' +
                            ", play_count=" + play_count +
                            ", user_repin=" + user_repin +
                            ", quick_comment=" + quick_comment +
                            ", category_activity_end_time=" + category_activity_end_time +
                            ", medium_cover=" + medium_cover +
                            ", neihan_hot_end_time='" + neihan_hot_end_time + '\'' +
                            ", user_digg=" + user_digg +
                            ", video_width=" + video_width +
                            ", online_time=" + online_time +
                            ", category_name='" + category_name + '\'' +
                            ", flash_url='" + flash_url + '\'' +
                            ", category_visible=" + category_visible +
                            ", bury_count=" + bury_count +
                            ", is_anonymous=" + is_anonymous +
                            ", repin_count=" + repin_count +
                            ", is_neihan_hot=" + is_neihan_hot +
                            ", uri='" + uri + '\'' +
                            ", is_public_url=" + is_public_url +
                            ", has_hot_comments=" + has_hot_comments +
                            ", category_show_ranking=" + category_show_ranking +
                            ", cover_image_uri='" + cover_image_uri + '\'' +
                            ", category_is_activity=" + category_is_activity +
                            ", cover_image_url='" + cover_image_url + '\'' +
                            ", neihan_hot_link=" + neihan_hot_link +
                            ", group_id=" + group_id +
                            ", is_video=" + is_video +
                            ", allow_dislike=" + allow_dislike +
                            ", display_type=" + display_type +
                            ", dislike_reason=" + dislike_reason +
                            '}';
                }

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
                public int video_wh_ratio;
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
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/1513674232.51/?video_id=77eecfc3b33740d9816dd7a314381ba2&quality=360p&line=0&is_gif=0&device_platform=android"},{"url":"http://ic.snssdk.com/neihan/video/playback/1513674232.51/?video_id=77eecfc3b33740d9816dd7a314381ba2&quality=360p&line=1&is_gif=0&device_platform=android"}]
                     * uri : 360p/77eecfc3b33740d9816dd7a314381ba2
                     * height : 854
                     */

                    public int width;
                    public String uri;
                    public int height;
                    public List<UrlListBean> url_list;

                    public static class UrlListBean {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/1513674232.51/?video_id=77eecfc3b33740d9816dd7a314381ba2&quality=360p&line=0&is_gif=0&device_platform=android
                         */

                        public String url;
                    }
                }

                public static class _$720pVideoBean {
                    /**
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/1513674232.51/?video_id=77eecfc3b33740d9816dd7a314381ba2&quality=720p&line=0&is_gif=0&device_platform=android"},{"url":"http://ic.snssdk.com/neihan/video/playback/1513674232.51/?video_id=77eecfc3b33740d9816dd7a314381ba2&quality=720p&line=1&is_gif=0&device_platform=android"}]
                     * uri : 720p/77eecfc3b33740d9816dd7a314381ba2
                     * height : 854
                     */

                    public int width;
                    public String uri;
                    public int height;
                    public List<UrlListBeanX> url_list;

                    public static class UrlListBeanX {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/1513674232.51/?video_id=77eecfc3b33740d9816dd7a314381ba2&quality=720p&line=0&is_gif=0&device_platform=android
                         */

                        public String url;
                    }
                }

                public static class _$480pVideoBean {
                    /**
                     * width : 480
                     * url_list : [{"url":"http://ic.snssdk.com/neihan/video/playback/1513674232.51/?video_id=77eecfc3b33740d9816dd7a314381ba2&quality=480p&line=0&is_gif=0&device_platform=android"},{"url":"http://ic.snssdk.com/neihan/video/playback/1513674232.51/?video_id=77eecfc3b33740d9816dd7a314381ba2&quality=480p&line=1&is_gif=0&device_platform=android"}]
                     * uri : 480p/77eecfc3b33740d9816dd7a314381ba2
                     * height : 854
                     */

                    public int width;
                    public String uri;
                    public int height;
                    public List<UrlListBeanXX> url_list;

                    public static class UrlListBeanXX {
                        /**
                         * url : http://ic.snssdk.com/neihan/video/playback/1513674232.51/?video_id=77eecfc3b33740d9816dd7a314381ba2&quality=480p&line=0&is_gif=0&device_platform=android
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
                     * url_list : [{"url":"http://p3.pstatp.com/large/4f3f0010d14ff3bc33ce.webp"},{"url":"http://pb9.pstatp.com/large/4f3f0010d14ff3bc33ce.webp"},{"url":"http://pb1.pstatp.com/large/4f3f0010d14ff3bc33ce.webp"}]
                     * uri : large/4f3f0010d14ff3bc33ce
                     */

                    public String uri;
                    public List<UrlListBeanXXX> url_list;

                    public static class UrlListBeanXXX {
                        /**
                         * url : http://p3.pstatp.com/large/4f3f0010d14ff3bc33ce.webp
                         */

                        public String url;
                    }
                }

                public static class UserBean {
                    /**
                     * is_living : false
                     * user_id : 5993911386
                     * name : 情感段子许哥丫
                     * followings : 0
                     * user_verified : false
                     * ugc_count : 261
                     * avatar_url : http://p1.pstatp.com/medium/3e800015a9e734db3806
                     * followers : 9208
                     * is_following : false
                     * is_pro_user : false
                     * medals : [{"count":148,"icon_url":"http://p1.pstatp.com/obj/3b630009fc5cacb7c73e","name":"hot_content","small_icon_url":"http://p1.pstatp.com/obj/3b680001625ef138a4a3"}]
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
                         * count : 148
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
}
