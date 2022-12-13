package ru.myrequest.domain

data class RequestItem (
    val city: String,
    val street: String,
    val home: String,
    val flat: String,
    val phone_number: String,
    val breakdown: String,
    val what_down: String,
    val date: String,
    var id: Int = DEFAULT_ID
    ){
    companion object{
        const val DEFAULT_ID = -1
    }
}