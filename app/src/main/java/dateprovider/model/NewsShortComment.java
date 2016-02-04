package dateprovider.model;

import java.util.List;

/**
 * Created by qiuxuechuan on 2016/2/4.
 */
public class NewsShortComment {

    /**
     * author : 每一天都在混水摸鱼
     * content : 钱会让它变的好吃
     * avatar : http://pic3.zhimg.com/0ecf2216c2612b04592126adc16affa2_im.jpg
     * time : 1413987020
     * id : 556780
     * likes : 0
     */

    private List<CommentsEntity> comments;

    public void setComments(List<CommentsEntity> comments) {
        this.comments = comments;
    }

    public List<CommentsEntity> getComments() {
        return comments;
    }

    public static class CommentsEntity {
        private String author;
        private String content;
        private String avatar;
        private int time;
        private int id;
        private int likes;

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }

        public String getAvatar() {
            return avatar;
        }

        public int getTime() {
            return time;
        }

        public int getId() {
            return id;
        }

        public int getLikes() {
            return likes;
        }
    }
}
