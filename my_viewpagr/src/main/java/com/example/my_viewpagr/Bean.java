package com.example.my_viewpagr;

import java.util.List;

/**
 * Created by lenovo on 2017/12/8.
 */

public class Bean {

    /**
     * message : success
     * data : {"pc_feed_focus":[{"title":"澳大利亚议会通过同性婚姻合法化法案 议员\u201c开心到飞起\u201d","display_url":"/group/6496711064934154765/","has_video":false,"image_url":"//p3.pstatp.com/origin/4ad0000305ba6e2134c3","has_image":true,"group_id":6496711064934154765,"media_url":"http://toutiao.com/m5784742177"},{"title":"杭州迎最美季节 空中俯瞰色彩斑斓宛如画卷","display_url":"/group/6496728268413075981/","has_video":false,"image_url":"//p9.pstatp.com/origin/4acc0016452338bb26d4","has_image":true,"group_id":6496728268413075981,"media_url":"http://toutiao.com/m5739097906"},{"title":"章子怡穿了这件浅粉色薄纱裙 简直就是仙女本尊","display_url":"/group/6496371152875684365/","has_video":false,"image_url":"//p3.pstatp.com/origin/4ace000b0ebb33bc526d","has_image":true,"group_id":6496371152875684365,"media_url":"http://toutiao.com/m5738017030"},{"title":"断腿天才卢克-肖，拼尽了全力打动穆帅把自己留在场上","display_url":"/group/6496265579341545997/","has_video":false,"image_url":"//p3.pstatp.com/origin/4ace000b0eb01eeb10da","has_image":true,"group_id":6496265579341545997,"media_url":"http://toutiao.com/m6675759548"},{"title":"用混凝土造军舰究竟会不会沉？美国一百年前就曾经尝试过","display_url":"/group/6495831904921584141/","has_video":false,"image_url":"//p1.pstatp.com/origin/46c5001a4602b825704d","has_image":false,"group_id":6495831904921584141,"media_url":"http://toutiao.com/m3995104383"},{"title":"小栗旬出席《银魂》发布会显沧桑 网友：还我童年","display_url":"/group/6496369832215183886/","has_video":false,"image_url":"//p3.pstatp.com/origin/4ad100008c58e27c554e","has_image":true,"group_id":6496369832215183886,"media_url":"http://toutiao.com/m5738017030"},{"title":"解放军三军仪仗队列队欢迎加拿大总理贾斯廷-特鲁多访华","display_url":"/group/6495865698324054542/","has_video":false,"image_url":"//p3.pstatp.com/origin/46c6001c15e78fe75f9c","has_image":true,"group_id":6495865698324054542,"media_url":"http://toutiao.com/m5739097906"},{"title":"一大波\u201c黑社会\u201d被押到淡村市场 地上摆满刀枪","display_url":"/group/6496639275382080014/","has_video":false,"image_url":"//p1.pstatp.com/origin/4acb0013e33e1987ec04","has_image":true,"group_id":6496639275382080014,"media_url":"http://toutiao.com/m5739097906"},{"title":"普京宣布参加2018年俄罗斯总统选举","display_url":"/group/6496450190717747726/","has_video":false,"image_url":"//p3.pstatp.com/origin/4ace000b0e9bed258b3a","has_image":true,"group_id":6496450190717747726,"media_url":"http://toutiao.com/m5784742177"},{"title":"三峡库区首批最大货运\u201c标箱船\u201d即将试水！已进入最后打理阶段","display_url":"/group/6495971492902208013/","has_video":false,"image_url":"//p9.pstatp.com/origin/4acc00112bd0bc3a5d46","has_image":true,"group_id":6495971492902208013,"media_url":"http://toutiao.com/m5739097906"}]}
     */

    private String message;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<PcFeedFocusBean> pc_feed_focus;

        public List<PcFeedFocusBean> getPc_feed_focus() {
            return pc_feed_focus;
        }

        public void setPc_feed_focus(List<PcFeedFocusBean> pc_feed_focus) {
            this.pc_feed_focus = pc_feed_focus;
        }

        public static class PcFeedFocusBean {
            /**
             * title : 澳大利亚议会通过同性婚姻合法化法案 议员“开心到飞起”
             * display_url : /group/6496711064934154765/
             * has_video : false
             * image_url : //p3.pstatp.com/origin/4ad0000305ba6e2134c3
             * has_image : true
             * group_id : 6496711064934154765
             * media_url : http://toutiao.com/m5784742177
             */

            private String title;
            private String display_url;
            private boolean has_video;
            private String image_url;
            private boolean has_image;
            private long group_id;
            private String media_url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDisplay_url() {
                return display_url;
            }

            public void setDisplay_url(String display_url) {
                this.display_url = display_url;
            }

            public boolean isHas_video() {
                return has_video;
            }

            public void setHas_video(boolean has_video) {
                this.has_video = has_video;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public boolean isHas_image() {
                return has_image;
            }

            public void setHas_image(boolean has_image) {
                this.has_image = has_image;
            }

            public long getGroup_id() {
                return group_id;
            }

            public void setGroup_id(long group_id) {
                this.group_id = group_id;
            }

            public String getMedia_url() {
                return media_url;
            }

            public void setMedia_url(String media_url) {
                this.media_url = media_url;
            }
        }
    }
}
