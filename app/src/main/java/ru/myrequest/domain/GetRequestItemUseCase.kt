package ru.myrequest.domain

class GetRequestItemUseCase(private val requestListRepository: RequestListRepository) {

    fun getRequestItem(requestItemId: Int): RequestItem {
        return requestListRepository.getRequestItem(requestItemId)
    }
}