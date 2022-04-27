package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.ViewModel.MyViewModel

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SenderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SenderFragment : Fragment() {
//    private var param1: String? = null
//    private var param2: String? = null

    lateinit var btn: Button

    // to write message
    lateinit var name: EditText
    lateinit var phone: EditText
    lateinit var mail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // reference for button and EditText
        btn = view.findViewById(R.id.btn)
        name = view.findViewById(R.id.name)
        phone = view.findViewById(R.id.number)
        mail = view.findViewById(R.id.mail)
        // create object of SharedViewModel
        val model = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        // call function "sendMessage" defined in SharedVieModel
        // to store the value in message.
        btn.setOnClickListener { model.setData(name.text.toString(), phone.text.toString(), mail.text.toString())

        }
    }

    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment SenderFragment.
//         */

//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            SenderFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}