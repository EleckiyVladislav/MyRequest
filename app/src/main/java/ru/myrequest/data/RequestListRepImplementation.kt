package ru.myrequest.data

import ru.myrequest.domain.RequestItem

object RequestListRepImplementation {

    private val requestList = Mutabl

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = RequestItem(
                "Москва",
                "5",
                "ул.Мира",
                "12",
                "8-999-999-99-99",
                "Не включается",
                "Диагностика",
                "01.01.2020"
            )
            addShopItem(item)
        }
    }

    private fun addShopItem(requestItem: RequestItem) {
        if(requestItem.id == RequestItem.DEFAULT_ID){
            requestItem.id = autoIncrementId++
        }
        requestList.
    }
}