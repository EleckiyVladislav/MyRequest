package ru.myrequest.domain

class EditRequestItemUseCase(private val requestListRepository: RequestListRepository) {

    fun editRequestItem(requestItem: RequestItem){
        requestListRepository.editRequestItem(requestItem)
    }
}