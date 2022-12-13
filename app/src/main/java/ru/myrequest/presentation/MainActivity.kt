package ru.myrequest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.myrequest.R
import ru.myrequest.data.RequestListRepImplementation

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var requestListAdapter: RequestListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRCView()
//        val item = RequestListRepImplementation.getRequestItem(11)
//        Log.d("MyLog", item.toString())
        viewModel =ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.requestList.observe(this){
            requestListAdapter.submitList(it)
        }


    }

    private fun setupRCView(){
        val rcRequestList =findViewById<RecyclerView>(R.id.rv_shop_list)
        with(rcRequestList){
            requestListAdapter = RequestListAdapter()
            adapter = requestListAdapter
        }

    }
}