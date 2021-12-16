package com.sumanta.loincompose.ui.retrofit.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumanta.loincompose.ui.retrofit.repo.MainRepo
import com.sumanta.loincompose.ui.retrofit.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val mainRepo: MainRepo): ViewModel() {

    val response: MutableState<ApiState> = mutableStateOf(ApiState.Empty)

    init {
        getPost()
    }

  fun getPost() = viewModelScope.launch {
      mainRepo.getPost()
          .onStart {
              response.value = ApiState.Loading
          }.catch { it->
              response.value = ApiState.Failure(it)
          }.collect { it->
              response.value = ApiState.Success(it)
          }
  }


}