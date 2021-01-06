package com.tech.spftest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment


class WelcomeFrag : Fragment() {
    var tv: TextView? = null
    var et:EditText?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.welocme_frag, container, false)

        tv = view.findViewById(R.id.textView)
        et=view.findViewById(R.id.et_uname_login)

        var spf =
            activity!!.getSharedPreferences("techsum", Context.MODE_PRIVATE)//get the object oif spf


        var uname = spf.getString("uname", et?.text.toString())

        tv?.text = "welcome here  $uname"

        return view
    }

}