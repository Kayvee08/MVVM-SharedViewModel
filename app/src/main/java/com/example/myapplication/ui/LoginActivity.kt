package com.example.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.ViewModel.MyViewModel


class LoginActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.my_fragment, SenderFragment())
        ft.commit()

        mainActivityViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        mainActivityViewModel.switch.observe(this, Observer {
            if(it == true){
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.my_fragment, ReceiverFragment())
                ft.commit()
            }
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}