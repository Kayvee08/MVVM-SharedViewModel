package com.example.myapplication.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    var name: MutableLiveData<String> = MutableLiveData<String>()
    var phone: MutableLiveData<String> = MutableLiveData<String>()
    var mail: MutableLiveData<String> = MutableLiveData<String>()
    var switch:MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)


    //Set data in ViewModel
    fun setData(name:String, phone:String, mail:String){
        this.name.value = name
        this.mail.value = mail
        this.phone.value = phone
        switch.value = true
    }

}
