package ru.myrequest.domain

import androidx.lifecycle.LiveData

interface RequestListRepository {

    fun addRequestItem(requestItem: RequestItem)

    fun deleteRequestItem(requestItem: RequestItem)

    fun editRequestItem(requestItem: RequestItem)

    fun getRequestItem(requestItemId: Int): RequestItem

    fun getRequestList(): LiveData<List<RequestItem>>

}