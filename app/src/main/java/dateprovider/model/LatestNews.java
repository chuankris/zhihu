package dateprovider.model;

import java.util.List;

/**
 * Created by qiuxuechuan on 2016/2/4.
 */
public class LatestNews {


   /* URL: http://news-at.zhihu.com/api/4/news/latest
    响应实例：

    {
        date: "20140523",
                stories: [
        {
            title: "中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）",
                    ga_prefix: "052321",
                images: [
            "http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"
            ],
            type: 0,
                    id: 3930445
        },
        ...
        ],
        top_stories: [
        {
            title: "商场和很多人家里，竹制家具越来越多（多图）",
                    image: "http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg",
                ga_prefix: "052315",
                type: 0,
                id: 3930883
        },
        ...
        ]
    }
    分析：

    date : 日期
    stories : 当日新闻
    title : 新闻标题
    images : 图像地址（官方 API 使用数组形式。目前暂未有使用多张图片的情形出现，曾见无 images 属性的情况，请在使用中注意 ）
    ga_prefix : 供 Google Analytics 使用
    type : 作用未知
    id : url 与 share_url 中最后的数字（应为内容的 id）
    multipic : 消息是否包含多张图片（仅出现在包含多图的新闻中）
    top_stories : 界面顶部 ViewPager 滚动显示的显示内容（子项格式同上）*/


    /**
     * date : 20140523
     * stories : [{"title":"中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）","ga_prefix":"052321","images":["http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"],"type":0,"id":3930445},"..."]
     * top_stories : [{"title":"商场和很多人家里，竹制家具越来越多（多图）","image":"http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg","ga_prefix":"052315","type":0,"id":3930883},"..."]
     */

    private String date;
    /**
     * title : 中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）
     * ga_prefix : 052321
     * images : ["http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"]
     * type : 0
     * id : 3930445
     */

    private List<StoriesEntity> stories;
    /**
     * title : 商场和很多人家里，竹制家具越来越多（多图）
     * image : http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg
     * ga_prefix : 052315
     * type : 0
     * id : 3930883
     */

    private List<TopStoriesEntity> top_stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<StoriesEntity> stories) {
        this.stories = stories;
    }

    public void setTop_stories(List<TopStoriesEntity> top_stories) {
        this.top_stories = top_stories;
    }

    public String getDate() {
        return date;
    }

    public List<StoriesEntity> getStories() {
        return stories;
    }

    public List<TopStoriesEntity> getTop_stories() {
        return top_stories;
    }

    public static class StoriesEntity {
        private String title;
        private String ga_prefix;
        private int type;
        private int id;
        private List<String> images;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getTitle() {
            return title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public List<String> getImages() {
            return images;
        }
    }

    public static class TopStoriesEntity {
        private String title;
        private String image;
        private String ga_prefix;
        private int type;
        private int id;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }
    }
}
