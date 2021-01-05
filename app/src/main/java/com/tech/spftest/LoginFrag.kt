package com.tech.spftest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.login_frag.*

class LoginFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.login_frag, container, false)

        var spf =
            activity!!.getSharedPreferences("techsum", Context.MODE_PRIVATE)//get the object oif spf


        spf.getString("uname", et_uname_login.text.toString())
        spf.getString("pass", et_pass_login.text.toString())


        if(et_uname_login.equals("uname")&&et_pass_login.equals("pass"))
        {
            var fMananger=activity!!.supportFragmentManager
            var tx=fMananger.beginTransaction()
            tx.add(R.id.my_frame,LoginFrag())
            tx.commit()
        }else
        {
            Toast.makeText(activity,"invalid credentials",Toast.LENGTH_SHORT).show()
        }

        return view
    }

}