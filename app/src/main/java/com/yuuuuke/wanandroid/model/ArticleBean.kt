package com.yuuuuke.wanandroid.model

import android.text.TextUtils
import com.chad.library.adapter.base.entity.MultiItemEntity
import java.io.Serializable

/**
 * description:文章
 *
 * @author zwp
 * @since 2021/3/10
 */
data class ArticleBean(
    var appLink: String,
    var audit: Int,
    var author: String,
    var canEdit: Boolean,
    var chapterId: Int,
    var chapterName: String,
    var collect: Boolean,
    var courseId: Int,
    var desc: String,
    var descMd: String,
    var envelopePic: String,
    var fresh: Boolean,
    var id: Int,
    var link: String,
    var niceDate: String,
    var niceShareDate: String,
    var origin: String,
    var prefix: String,
    var projectLink: String,
    var publishTime: Long,
    var realSuperChapterId: Int,
    var selfVisible: Int,
    var shareDate: Long,
    var shareUser: String,
    var superChapterId: Int,
    var superChapterName: String,
    var title: String,
    var type: Int,
    var userId: Int,
    var visible: Int,
    var zan: Int,
    var tags: List<Tags>,
    var isTop:Boolean
) : MultiItemEntity,Serializable {

    override var itemType: Int = 0

    fun setType(){
        itemType = if(TextUtils.isEmpty(envelopePic)){
            0
        }else{
            1
        }
    }

    data class Tags(
        var name: String,
        var url: String
    ):Serializable
}