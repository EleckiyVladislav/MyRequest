package ru.myrequest.domain

class AddRequestItemUseCase(private val requestListRepository: RequestListRepository) {

    fun addRequestItem(requestItem: RequestItem){
        requestListRepository.addRequestItem(requestItem)
    }
}