package com.sumanta.loincompose.ui.retrofit.repo

import com.sumanta.loincompose.ui.retrofit.data.Post
import com.sumanta.loincompose.ui.retrofit.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepo
@Inject
constructor(private val apiService: ApiService){

    fun getPost():Flow<List<Post>> = flow {
        emit(apiService.getPost())
    }.flowOn(Dispatchers.IO)

}