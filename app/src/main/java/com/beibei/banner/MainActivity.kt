package com.beibei.banner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mBannerList = ArrayList<NewsBean>()//banner集合

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fresco.initialize(this)
        initData()
    }

    private fun initData() {
        mBannerList.clear()
        mBannerList.add(NewsBean(0, "", "", "res:///" + R.mipmap.banner1))
        mBannerList.add(NewsBean(0, "", "", "res:///" + R.mipmap.banner2))
        mBannerList.add(NewsBean(0, "", "", "res:///" + R.mipmap.banner3))
        mBannerList.add(NewsBean(0, "", "", "res:///" + R.mipmap.banner4))
        if (mBannerList.size == 0) {//无数据，显示一张背景图，不翻页
            mBannerList.add(NewsBean(0, "", "", "res:///" + R.mipmap.bg_banner))
            banner.stopTurning()
        } else {
            banner.setOnItemClickListener { position ->
                if (mBannerList[position].newsUrl.isNullOrEmpty()) {
                    Toast.makeText(this@MainActivity, "该新闻链接为空", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "跳转WebView", Toast.LENGTH_SHORT).show()
                }
            }
            banner.startTurning(1500)
        }

        initBanner()
    }

    private fun initBanner() {
        banner.setPageTransformer(ScaleTransformer())
        banner.setPageMargin(-20)
        banner.setPages({ BannerHolderView() }, (mBannerList as ArrayList<Nothing>?)!!)
                .setPageIndicator(intArrayOf(R.drawable.shape_banner_line_normal, R.drawable.shape_banner_line_select))//小圆点
                //设置指示器的方向
                .setPageIndicatorAlign(MyConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
    }

    override fun onResume() {
        super.onResume()
        //开始自动翻页
        if (mBannerList.size > 1) {
            banner.startTurning(1500)
        } else {
            banner.stopTurning()
        }
    }

    override fun onPause() {
        super.onPause()
        //停止翻页
        banner.stopTurning()
    }
}
