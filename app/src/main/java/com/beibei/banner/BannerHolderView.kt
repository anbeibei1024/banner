package com.beibei.banner

import android.content.Context
import android.view.View
import com.bigkoo.convenientbanner.holder.Holder
import kotlinx.android.synthetic.main.banner_home_view.view.*

class BannerHolderView : Holder<NewsBean> {
    private var mView: View? = null
    override fun createView(context: Context?): View {
        mView = View.inflate(context, R.layout.banner_home_view, null)
        return mView!!
    }

    override fun UpdateUI(context: Context?, position: Int, data: NewsBean) {
        mView!!.sdv_home_banner.setImageURI(data.fileUrl)
//        mView!!.tv_home_banner_title.text = data.title
//        mView!!.tv_home_banner_title.visibility = View.GONE
    }
}