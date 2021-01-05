package com.tech.spftest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_frag.*
import kotlinx.android.synthetic.main.welocme_frag.*

class WelcomeFrag: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var inflater=LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.welocme_frag,container,false)


        var spf =
            activity!!.getSharedPreferences("techsum", Context.MODE_PRIVATE)//get the object oif spf


       var uname= spf.getString("uname",et_uname_login.text.toString())

        textView.text="welcome here  $uname"

        return view
    }

}