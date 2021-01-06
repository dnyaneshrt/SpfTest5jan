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


class RegisterFrag: Fragment() {

   private var et_uid:EditText?=null
 private var et_pass:EditText?=null

    var btn_reg: Button?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var inflater=LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.register_frag,container,false)

        et_uid=view.findViewById(R.id.et_uname_register)
        et_pass=view.findViewById(R.id.et_pass_register)
       btn_reg=view.findViewById(R.id.btn_register_register)


        var spf= activity!!.getSharedPreferences("techsum", Context.MODE_PRIVATE)//get the object oif spf

        var editor= spf.edit()


        btn_reg?.setOnClickListener{
            editor.putString("uname",et_uid?.text.toString())
            editor.putString("pass",et_pass?.text.toString())
            editor.commit()

            Toast.makeText(activity,"registerd successfully",Toast.LENGTH_SHORT).show()

            var fMananger=activity!!.supportFragmentManager
            var tx=fMananger.beginTransaction()
            tx.add(R.id.my_frame,LoginFrag())
            tx.commit()


        }



        return view
    }

}