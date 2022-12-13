package ru.myrequest.domain

class DeleteRequestItemUseCase(private val requestListRepository: RequestListRepository) {

    fun deleteRequestItem(requestItem: RequestItem){
        requestListRepository.deleteRequestItem(requestItem)
    }
}