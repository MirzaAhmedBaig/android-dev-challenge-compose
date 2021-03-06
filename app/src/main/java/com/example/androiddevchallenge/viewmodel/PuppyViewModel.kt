package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androiddevchallenge.data.models.PuppyInfo
import com.example.androiddevchallenge.data.repository.DataRepository

class PuppyViewModel {
    val puppyInfoList: LiveData<List<PuppyInfo>> = MutableLiveData(DataRepository.puppiesInfoList)

    fun findPuppy(id: Int) = puppyInfoList.value?.find { it.id == id }
}