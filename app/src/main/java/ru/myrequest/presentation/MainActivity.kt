package ru.myrequest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.myrequest.R
import ru.myrequest.data.RequestListRepImplementation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val item = RequestListRepImplementation.getRequestItem(11)
        Log.d("MyLog", item.toString())
    }
}