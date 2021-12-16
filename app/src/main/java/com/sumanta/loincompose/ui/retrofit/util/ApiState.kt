package com.sumanta.loincompose.ui.retrofit.util

import com.sumanta.loincompose.ui.retrofit.data.Post

sealed class ApiState{
    class Success(val data:List<Post>): ApiState()
    class Failure(val msg: Throwable): ApiState()
    object Loading: ApiState()
    object Empty: ApiState()
}
