package dateprovider.model;

/**
 * Created by Uphie on 2015/9/10.
 * Email: uphie7@gmail.com
 */
public class OneArticle {
    public Article getContentEntity() {
        return contentEntity;
    }

    public void setContentEntity(Article contentEntity) {
        this.contentEntity = contentEntity;
    }

    private Article contentEntity;

    public class Article {
        public String getStrLastUpdateDate() {
            return strLastUpdateDate;
        }

        public void setStrLastUpdateDate(String strLastUpdateDate) {
            this.strLastUpdateDate = strLastUpdateDate;
        }

        public String getStrDayDiffer() {
            return strDayDiffer;
        }

        public void setStrDayDiffer(String strDayDiffer) {
            this.strDayDiffer = strDayDiffer;
        }

        public String getStrHpId() {
            return strHpId;
        }

        public void setStrHpId(String strHpId) {
            this.strHpId = strHpId;
        }

        public String getStrThumbnailUrl() {
            return strThumbnailUrl;
        }

        public void setStrThumbnailUrl(String strThumbnailUrl) {
            this.strThumbnailUrl = strThumbnailUrl;
        }

        public String getStrHpTitle() {
            return strHpTitle;
        }

        public void setStrHpTitle(String strHpTitle) {
            this.strHpTitle = strHpTitle;
        }

        public String getStrOriginalImgUrl() {
            return strOriginalImgUrl;
        }

        public void setStrOriginalImgUrl(String strOriginalImgUrl) {
            this.strOriginalImgUrl = strOriginalImgUrl;
        }

        public String getStrAuthor() {
            return strAuthor;
        }

        public void setStrAuthor(String strAuthor) {
            this.strAuthor = strAuthor;
        }

        public String getStrContent() {
            return strContent;
        }

        public void setStrContent(String strContent) {
            this.strContent = strContent;
        }

        public String getStrMarketTime() {
            return strMarketTime;
        }

        public void setStrMarketTime(String strMarketTime) {
            this.strMarketTime = strMarketTime;
        }

        public String getsWebLk() {
            return sWebLk;
        }

        public void setsWebLk(String sWebLk) {
            this.sWebLk = sWebLk;
        }

        public String getStrPn() {
            return strPn;
        }

        public void setStrPn(String strPn) {
            this.strPn = strPn;
        }

        public String getwImgUrl() {
            return wImgUrl;
        }

        public void setwImgUrl(String wImgUrl) {
            this.wImgUrl = wImgUrl;
        }

        //最近更新时间
        private String strLastUpdateDate;
        //???
        private String strDayDiffer;
        //id
        private String strHpId;
        //标题
        private String strHpTitle;
        //缩略图地址
        private String strThumbnailUrl;
        //原图地址
        private String strOriginalImgUrl;
        //作者
        private String strAuthor;
        //内容
        private String strContent;
        //上架时间
        private String strMarketTime;
        //网页版链接
        private String sWebLk;
        //喜欢的数量
        private String strPn;
        //原文生成的图片
        private String wImgUrl;
    }


}
