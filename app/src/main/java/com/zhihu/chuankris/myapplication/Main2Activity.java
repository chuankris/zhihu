package com.zhihu.chuankris.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dateprovider.model.LatestNews;
import dateprovider.model.NewsBefore;
import dateprovider.model.NewsDetail;
import dateprovider.model.NewsLongComment;
import dateprovider.model.NewsShortComment;
import dateprovider.model.StartPicture;
import dateprovider.retrofit.RetrolfitProvider;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.bt_getpicture)
    Button mbtGetpicture;
    @Bind(R.id.bt_getdetailnews)
    Button mbtGetNewsDetail;
    @Bind(R.id.bt_getdetailnewsbefore)
    Button mbtGetNewsBefore;
    @Bind(R.id.bt_getlatestnews)
    Button mbtLatestNews;
    @Bind(R.id.bt_long_comment)
    Button mbtGetComment;
    @Bind(R.id.bt_shot_comment)
    Button mbtShortComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.bt_getlatestnews)
    void getlatestnews() {
        RetrolfitProvider.getInstance().getZhihuApi().getLatestNews().observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(new Observer<LatestNews>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LatestNews oneArticle) {
            }
        });
    }

    @OnClick(R.id.bt_getdetailnewsbefore)
    void getnewsbefore() {
        RetrolfitProvider.getInstance().getZhihuApi().getNewsDetailBefore("20131119").observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(new Observer<NewsBefore>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsBefore oneArticle) {
            }
        });
    }

    @OnClick(R.id.bt_getdetailnews)
    void getDetailNews() {
        RetrolfitProvider.getInstance().getZhihuApi().getNewsDetail("3892357").observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(new Observer<NewsDetail>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsDetail oneArticle) {
            }
        });

    }

    @OnClick(R.id.bt_shot_comment)
    void getShot() {
        RetrolfitProvider.getInstance().getZhihuApi().getNewsShortComment("3892357").observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(new Observer<NewsShortComment>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsShortComment oneArticle) {
            }
        });
    }

    @OnClick(R.id.bt_long_comment)
    void getLong() {
        RetrolfitProvider.getInstance().getZhihuApi().getNewsLongComment("3892357").observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(new Observer<NewsLongComment>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsLongComment oneArticle) {
            }
        });
    }

    @OnClick(R.id.bt_getpicture)
    void getPicture() {
        RetrolfitProvider.getInstance().getZhihuApi().getStartPicture("1080*1776").observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(new Observer<StartPicture>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(StartPicture oneArticle) {
            }
        });
    }

}
