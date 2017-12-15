package com.zhangboshu.demo.rxJavaTest;

import java.util.List;

/**
 * Created by zhangboshu on 2017/12/15.
 */

public class BaseBean {

    /**
     * count : 1
     * start : 0
     * total : 564
     * books : [{"rating":{"max":10,"numRaters":85,"average":"8.6","min":0},"subtitle":"","author":["秦修容"],"pubdate":"1998-3-1","tags":[{"count":56,"name":"金瓶梅","title":"金瓶梅"},{"count":20,"name":"中国古代名著","title":"中国古代名著"},{"count":19,"name":"古典文学","title":"古典文学"},{"count":13,"name":"经典","title":"经典"},{"count":12,"name":"小说","title":"小说"},{"count":11,"name":"金瓶梅(上中下)","title":"金瓶梅(上中下)"},{"count":10,"name":"古典小说","title":"古典小说"},{"count":9,"name":"古典","title":"古典"}],"origin_title":"","image":"https://img1.doubanio.com/mpic/s1278508.jpg","binding":"精装(无盘)","translator":[],"catalog":"一、前面的话\n二、整理说明\n三、目录\n四、正文\n五、附录\n六、校勘记","pages":"2420","images":{"small":"https://img1.doubanio.com/spic/s1278508.jpg","large":"https://img1.doubanio.com/lpic/s1278508.jpg","medium":"https://img1.doubanio.com/mpic/s1278508.jpg"},"alt":"https://book.douban.com/subject/1204862/","id":"1204862","publisher":"中华书局","isbn10":"7101014232","isbn13":"9787101014235","title":"金瓶梅（全三册）","url":"https://api.douban.com/v2/book/1204862","alt_title":"","author_intro":"","summary":"《会评会校金瓶梅》以中华书局藏张竹坡评本为底本，会校明万历本《金瓶梅词话》和日本内阁文库藏明刊本《新镌绣像批评原本金瓶梅》，撰有详细的较勘记，置于全书之后，是为会校。凡是《金瓶梅》诸本中的各类评语均收入书中，是为会评。这是目前汇辑《金瓶梅》资料最完整全面的一部整理本，为读者与研究者提供极大的方便。","price":"268.00"}]
     */

    private int count;
    private int start;
    private int total;
    private List<BooksBean> books;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean {
        /**
         * rating : {"max":10,"numRaters":85,"average":"8.6","min":0}
         * subtitle :
         * author : ["秦修容"]
         * pubdate : 1998-3-1
         * tags : [{"count":56,"name":"金瓶梅","title":"金瓶梅"},{"count":20,"name":"中国古代名著","title":"中国古代名著"},{"count":19,"name":"古典文学","title":"古典文学"},{"count":13,"name":"经典","title":"经典"},{"count":12,"name":"小说","title":"小说"},{"count":11,"name":"金瓶梅(上中下)","title":"金瓶梅(上中下)"},{"count":10,"name":"古典小说","title":"古典小说"},{"count":9,"name":"古典","title":"古典"}]
         * origin_title :
         * image : https://img1.doubanio.com/mpic/s1278508.jpg
         * binding : 精装(无盘)
         * translator : []
         * catalog : 一、前面的话
         二、整理说明
         三、目录
         四、正文
         五、附录
         六、校勘记
         * pages : 2420
         * images : {"small":"https://img1.doubanio.com/spic/s1278508.jpg","large":"https://img1.doubanio.com/lpic/s1278508.jpg","medium":"https://img1.doubanio.com/mpic/s1278508.jpg"}
         * alt : https://book.douban.com/subject/1204862/
         * id : 1204862
         * publisher : 中华书局
         * isbn10 : 7101014232
         * isbn13 : 9787101014235
         * title : 金瓶梅（全三册）
         * url : https://api.douban.com/v2/book/1204862
         * alt_title :
         * author_intro :
         * summary : 《会评会校金瓶梅》以中华书局藏张竹坡评本为底本，会校明万历本《金瓶梅词话》和日本内阁文库藏明刊本《新镌绣像批评原本金瓶梅》，撰有详细的较勘记，置于全书之后，是为会校。凡是《金瓶梅》诸本中的各类评语均收入书中，是为会评。这是目前汇辑《金瓶梅》资料最完整全面的一部整理本，为读者与研究者提供极大的方便。
         * price : 268.00
         */

        private RatingBean rating;
        private String subtitle;
        private String pubdate;
        private String origin_title;
        private String image;
        private String binding;
        private String catalog;
        private String pages;
        private ImagesBean images;
        private String alt;
        private String id;
        private String publisher;
        private String isbn10;
        private String isbn13;
        private String title;
        private String url;
        private String alt_title;
        private String author_intro;
        private String summary;
        private String price;
        private List<String> author;
        private List<TagsBean> tags;
        private List<?> translator;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getOrigin_title() {
            return origin_title;
        }

        public void setOrigin_title(String origin_title) {
            this.origin_title = origin_title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBinding() {
            return binding;
        }

        public void setBinding(String binding) {
            this.binding = binding;
        }

        public String getCatalog() {
            return catalog;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getIsbn10() {
            return isbn10;
        }

        public void setIsbn10(String isbn10) {
            this.isbn10 = isbn10;
        }

        public String getIsbn13() {
            return isbn13;
        }

        public void setIsbn13(String isbn13) {
            this.isbn13 = isbn13;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAlt_title() {
            return alt_title;
        }

        public void setAlt_title(String alt_title) {
            this.alt_title = alt_title;
        }

        public String getAuthor_intro() {
            return author_intro;
        }

        public void setAuthor_intro(String author_intro) {
            this.author_intro = author_intro;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<?> getTranslator() {
            return translator;
        }

        public void setTranslator(List<?> translator) {
            this.translator = translator;
        }

        public static class RatingBean {
            /**
             * max : 10
             * numRaters : 85
             * average : 8.6
             * min : 0
             */

            private int max;
            private int numRaters;
            private String average;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getNumRaters() {
                return numRaters;
            }

            public void setNumRaters(int numRaters) {
                this.numRaters = numRaters;
            }

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img1.doubanio.com/spic/s1278508.jpg
             * large : https://img1.doubanio.com/lpic/s1278508.jpg
             * medium : https://img1.doubanio.com/mpic/s1278508.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class TagsBean {
            /**
             * count : 56
             * name : 金瓶梅
             * title : 金瓶梅
             */

            private int count;
            private String name;
            private String title;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
