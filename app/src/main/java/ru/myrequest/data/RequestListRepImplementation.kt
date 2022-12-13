package ru.myrequest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.myrequest.domain.RequestItem

object RequestListRepImplementation {

    private var requestListLD = MutableLiveData<List<RequestItem>>()
    private val requestList = mutableListOf<RequestItem>()

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val requestItem = RequestItem(
                "Москва",
                "5",
                "ул.Мира",
                "12",
                "8-999-999-99-99",
                "Не включается",
                "Диагностика",
                "01.01.2020"
            )
            addRequestItem(requestItem)
        }
    }

    private fun addRequestItem(requestItem: RequestItem) {
        if(requestItem.id == RequestItem.DEFAULT_ID){
            requestItem.id = autoIncrementId++
        }
        requestList.add(requestItem)
        updateLD()
    }

    private fun deleteRequestItem(requestItem: RequestItem){
        requestList.remove(requestItem)
        updateLD()
    }

    private fun editRequestItem(requestItem: RequestItem){
        val old_item = getRequestItem(requestItem.id)
        requestList.remove(old_item)
        addRequestItem(requestItem)
    }

    private fun getRequestItem(requestItemId: Int): RequestItem{
        return requestList.find {
            it.id == requestItemId
        } ?: throw RuntimeException("Element with id $requestItemId not found")
    }

    private fun getRequestList(): LiveData<List<RequestItem>>{
        return requestListLD
    }

    private fun updateLD(){
        requestListLD.value = requestList
    }


}