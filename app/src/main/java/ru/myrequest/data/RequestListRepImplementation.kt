package ru.myrequest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.myrequest.domain.RequestItem
import ru.myrequest.domain.RequestListRepository
import kotlin.random.Random

object RequestListRepImplementation: RequestListRepository {

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
                "Samsung",
                "01.01.2020",
                Random.nextBoolean()
            )
            addRequestItem(requestItem)
        }
    }

    override fun addRequestItem(requestItem: RequestItem) {
        if(requestItem.id == RequestItem.DEFAULT_ID){
            requestItem.id = autoIncrementId++
        }
        requestList.add(requestItem)
        updateLD()
    }

    override fun deleteRequestItem(requestItem: RequestItem) {
        requestList.remove(requestItem)
        updateLD()
    }

    override fun editRequestItem(requestItem: RequestItem) {
        val old_item = getRequestItem(requestItem.id)
        requestList.remove(old_item)
        addRequestItem(requestItem)
    }

    override fun getRequestItem(requestItemId: Int): RequestItem {
        return requestList.find {
            it.id == requestItemId
        } ?: throw RuntimeException("Element with id $requestItemId not found")
    }

    override fun getRequestList(): LiveData<List<RequestItem>> {
        return requestListLD
    }


    private fun updateLD(){
        requestListLD.value = requestList
    }


}