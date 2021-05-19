package com.yuuuuke.wanandroid.model

/**
 * description:用户信息
 *
 * @author zwp
 * @since 2021/5/18
 */
data class UserBean(var admin:Boolean,
                    var chapterTops:Int,
                    var coinCount:Int,
                    var collectIds:Int,
                    var email:String,
                    var icon:String,
                    var id:Int,
                    var nickname:String,
                    var password:String,
                    var publicName:String,
                    var token:String,
                    var type:Int,
                    var username:String)