package com.tech.spftest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment


class LoginFrag : Fragment() {


    var et_uname: EditText? = null
    var et_pass: EditText? = null
    var btn_login: Button? = null
    var btn_register: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.login_frag, container, false)


        et_uname = view.findViewById(R.id.et_uname_login)
        et_pass = view.findViewById(R.id.et_pass_login)
        btn_login = view.findViewById(R.id.btn_login)
        btn_register = view.findViewById(R.id.btn_register)


        var spf =
            activity!!.getSharedPreferences("techsum", Context.MODE_PRIVATE)//get the object oif spf


        var uid = spf.getString("uname", et_uname?.text.toString().trim())
        var password = spf.getString("pass", et_pass?.text.toString().trim())

        Toast.makeText(activity, uid + "   " + password, Toast.LENGTH_SHORT).show()


        btn_login?.setOnClickListener {

            if (uid.equals(et_uname?.text.toString()) && password.equals(et_pass?.text.toString())) {
                var fMananger = activity!!.supportFragmentManager
                var tx = fMananger.beginTransaction()
                tx.add(R.id.my_frame, WelcomeFrag())
                tx.commit()
            } else {
                Toast.makeText(activity, "invalid credentials", Toast.LENGTH_SHORT).show()
            }

        }
        btn_register?.setOnClickListener {
            var FragmentManager = activity!!.supportFragmentManager
            var tx = fragmentManager?.beginTransaction()
            tx?.replace(R.id.my_frame, RegisterFrag())
            tx?.commit()

        }


        return view
    }

}