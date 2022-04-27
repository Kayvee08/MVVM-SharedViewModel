package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.ViewModel.MyViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ReceiverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReceiverFragment : Fragment() {


    var name: TextView ?= null
    var phone: TextView?= null
    var mail: TextView?= null
    var btn: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name=view.findViewById(R.id.name)
        phone=view.findViewById(R.id.phone)
        mail=view.findViewById(R.id.email)
        btn= view.findViewById(R.id.finish)

        // create object of SharedViewModel
        val model = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        model.name.observe(viewLifecycleOwner, Observer {
            name?.text = it
        })
        model.phone.observe(viewLifecycleOwner, Observer {
            phone?.text = it
        })
        model.mail.observe(viewLifecycleOwner, Observer {
            mail?.text = it
        })
        btn?.setOnClickListener {
            activity?.finish()
        }
    }

    companion object {

    }
}