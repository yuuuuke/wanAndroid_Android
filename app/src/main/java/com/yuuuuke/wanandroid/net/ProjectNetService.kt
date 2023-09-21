package com.yuuuuke.wanandroid.net

import com.yuuuuke.wanandroid.base.BaseBean
import com.yuuuuke.wanandroid.model.KnowledgeSystemBean
import com.yuuuuke.wanandroid.model.ProjectDetailListBean
import com.yuuuuke.wanandroid.model.ProjectTreeBean
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ProjectNetService {

    @GET("/project/tree/json")
    suspend fun getProjectTree(): BaseBean<ArrayList<ProjectTreeBean>>


    @GET("/project/list/{page}/json")
    suspend fun getProjectDetail(
        @Path("page") page: Int,
        @Query("cid") cid: Int
    ): BaseBean<ProjectDetailListBean>

    /**
     * 获取知识体系
     */
    @GET("/tree/json")
    suspend fun getKnowledgeTree(): BaseBean<ArrayList<KnowledgeSystemBean>>
}