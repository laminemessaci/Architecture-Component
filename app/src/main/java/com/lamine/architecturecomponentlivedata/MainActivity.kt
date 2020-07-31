package com.lamine.architecturecomponentlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val counter = MutableLiveData<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counter.value = 0

       button2.setOnClickListener {
           counter.value = counter.value!! +1
           Log.i("MainActivity", "Button")
       }

       // val observer: Observer<Int> = object: Observer<Int>{
       //     override fun onChanged(t: Int?) {
       //         Log.i("MainActivity", "New counter value = $t")
       //     }
//
       // }
        val observer: Observer<Int> = object : Observer<Int> {
            override fun onChanged(it: Int) {
                Log.i("MainActivity", "New counter value = $it")
            }
        }
       counter.observe(this, observer)
    }
}