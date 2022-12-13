package ru.myrequest.domain

import androidx.lifecycle.LiveData

class GetRequestListUseCase(private val requestListRepository: RequestListRepository) {

    fun getRequestList(): LiveData<List<RequestItem>>{
        return requestListRepository.getRequestList()
    }
}