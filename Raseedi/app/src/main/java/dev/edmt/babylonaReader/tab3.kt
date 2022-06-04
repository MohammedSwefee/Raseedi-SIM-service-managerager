package dev.edmt.babylonaReader

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView

import android.content.SharedPreferences




/**
 * Created by Mohammed on 24/04/2018.
 */
class tab3 : Fragment() {


    lateinit var sharedp: SharedPreferences
    var myfile="dev.edmt.androidcamerarecognitiontext.myfile"
    lateinit var tap11: ImageView
    lateinit var comp: EditText
    lateinit var supp: EditText
    lateinit var cod: EditText
    lateinit var balance: EditText


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.tab3, container, false)



        sharedp=this.activity!!.getSharedPreferences(myfile, Context.MODE_PRIVATE)
        tap11= rootView.findViewById(R.id.imageadd) as ImageView
        comp= rootView.findViewById(R.id.company) as EditText
        supp= rootView.findViewById(R.id.supportno) as EditText
        cod= rootView.findViewById(R.id.card_code) as EditText
        balance= rootView.findViewById(R.id.balance) as EditText





        tap11.setOnClickListener {

            var comp=comp.text.toString()
            var supp=supp.text.toString()
            var cod=cod.text.toString()
            var balance=balance.text.toString()

            var prefedit:SharedPreferences.Editor

            prefedit=sharedp.edit()

            prefedit.putString("comp_name",comp)
            prefedit.putString("supp",supp)
            prefedit.putString("cod",cod)
            prefedit.putString("balance",balance)
            prefedit.apply()

            Snackbar.make(rootView, "Card added successfully", Snackbar.LENGTH_LONG) .show()



        }




        /*tap11.setOnClickListener{
            val myIntent = Intent(rootView.context, zain::class.java)
            startActivity(myIntent)
            Snackbar.make(rootView, "get serial number", Snackbar.LENGTH_LONG)//.context.startActivity(Intent(this, zain::class.java))
                    .setAction("Dissmiss", null).show()*/



        //var backgroundtask:backgroundtask




        return rootView
    }


}