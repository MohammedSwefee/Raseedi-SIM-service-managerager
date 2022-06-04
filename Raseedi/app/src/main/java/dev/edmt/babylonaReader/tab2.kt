package dev.edmt.babylonaReader

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import dev.edmt.babylonaReader.R.id.call
import dev.edmt.babylonaReader.zain.zain

/**
 * Created by Mohammed on 24/04/2018.
 */
class tab2 : Fragment() {



    var myfile="dev.edmt.androidcamerarecognitiontext.myfile"
    lateinit var sharedp: SharedPreferences
    lateinit var tap11: ImageView
    lateinit var tap22: ImageView
    lateinit var tap33: ImageView
    private val REQUEST_CALL=1




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.tab2, container, false)

        tap11= rootView.findViewById(R.id.image_sec1asia) as ImageView
        tap22= rootView.findViewById(R.id.image_sec2asia) as ImageView
        tap33= rootView.findViewById(R.id.image_sec3asia) as ImageView
        //var tap1=tap1.findViewById(R.id.image_sec1)


        tap11.setOnClickListener {
            sharedp= this.activity?.getSharedPreferences(myfile, Context.MODE_PRIVATE)!!
            var ecompname=sharedp.getString("ecompname","null")
            var balance=sharedp.getString("balance","null")

            if (ecompname=="zain"){call("","*200#","");Snackbar.make(rootView, "dial:  *200#", Snackbar.LENGTH_LONG) .show()}
            else if (ecompname=="asia"){call("","*133#",""); Snackbar.make(rootView, "dial:  *133#", Snackbar.LENGTH_LONG) .show()}
            else if (ecompname=="korek"){call("","*211#","");Snackbar.make(rootView, "dial:  *211#", Snackbar.LENGTH_LONG) .show()}
            else if (ecompname=="comp_name"){call("",balance,"");Snackbar.make(rootView, balance, Snackbar.LENGTH_LONG) .show()}



        }


        tap22.setOnClickListener {
            sharedp= this.activity!!.getSharedPreferences(myfile, Context.MODE_PRIVATE)
            var ecompname=sharedp.getString("ecompname","null")
            var supp=sharedp.getString("supp","null")

            if (ecompname=="zain"){call("t","","118")}
            else if (ecompname=="asia"){call("t","","333")}
            else if (ecompname=="korek"){call("t","","411")}
            else if (ecompname=="comp_name"){call("t","",supp)}
        }

        tap33.setOnClickListener{
            val myIntent = Intent(rootView.context, zain::class.java)
            startActivity(myIntent)
        }


        return rootView
    }

    @SuppressLint("MissingPermission")
    private fun call(a:String, ba:String, c:String ) {

        var ba=ba
        val sbb = StringBuilder(ba)


        var number=""
        var hash =Uri.encode("#")
        var test=""
        var len= ba.length
       if (len==5){  test =ba[4].toString()}

        if(test == "#"){ sbb.deleteCharAt(4)
            val cod = sbb.toString()
            number=cod+hash}

        if (a=="t"){number=c}



        if (number.trim { it <= ' ' }.length > 0) {

            if (ContextCompat.checkSelfPermission(this!!.context!!,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Activity(),
                        arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CALL)
            } else {

                val dial = "tel:$number"
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))

            }

        } else {
            Toast.makeText(context, "Enter Phone Number", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        /* if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
             ActivityCompat.requestPermissions(this.activity, arrayOf<String>(Manifest.permission.CALL_PHONE),REQUEST_CALL)
         }*/



        if (requestCode == REQUEST_CALL) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                call("12345","12345","12345")
            } else {
                // Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show()
            }
        }}


}