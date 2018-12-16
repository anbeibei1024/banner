package com.beibei.banner

data class NewsBean(
        var newsId: Int,
        var summary: String = "",
        var title: String = "",
        var fileUrl: String = "",
        var newsUrl: String = "",
        var newsShareUrl: String = "",
        var publishTimeStr: String = "",
        var author: String = ""
)