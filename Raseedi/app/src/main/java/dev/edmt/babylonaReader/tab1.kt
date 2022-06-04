package dev.edmt.babylonaReader

/**
 * Created by Mohammed on 24/04/2018.
 */

//import android.content.ClipData
import android.Manifest
import android.content.Context
//import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
//import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.*
import android.widget.*
import dev.edmt.babylonaReader.R.attr.layout
import kotlinx.android.synthetic.main.image.*
import kotlin.concurrent.timer

//import dev.edmt.androidcamerarecognitiontext.zain.zain
//import kotlinx.android.synthetic.main.tab1.view.*




class tab1 : Fragment() {

    //lateinit var titlee: TextView
    lateinit var tap11: ImageView
    lateinit var tap22: ImageView
    lateinit var tap33: ImageView
    lateinit var tap44: ImageView
    lateinit var labe:TextView
    lateinit var sharedp: SharedPreferences
    var myfile="dev.edmt.androidcamerarecognitiontext.myfile"
    private val REQUEST_CALL=1



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.tab1, container, false)





        //listView = rootView.findViewById(R.id.newItem) as ListView
        tap11= rootView.findViewById(R.id.image_sec1zain) as ImageView
        tap22= rootView.findViewById(R.id.image_sec2zain) as ImageView
        tap33= rootView.findViewById(R.id.image_sec3zain) as ImageView
        tap44= rootView.findViewById(R.id.newsim) as ImageView
        labe= rootView.findViewById(R.id.newsimlabel) as TextView





        //var list = mutableListOf<comp_name>()

        sharedp= this.activity!!.getSharedPreferences(myfile, Context.MODE_PRIVATE)

        /*var comp_name=sharedp.getString("comp_name","null")

        list.add(comp_name(comp_name  ))
        val adapter = simAdapter(rootView.context,R.layout.sim,list)
        listView.adapter = adapter*/

        /*val sp=this.activity.getSharedPreferences("sa", Context.MODE_PRIVATE)
        val comp=sp.getString("compo","not found")
        val cod=sp.getString("email","not found")
        val supp=sp.getString("email","not found")*/






        tap11.setOnClickListener{

            var prefedit:SharedPreferences.Editor
            prefedit=sharedp.edit()
            prefedit.putString("ecompname","zain")
            prefedit.apply()

            Toast.makeText(context, "Zain selected", Toast.LENGTH_LONG).show()

           // tt.text="زين عراق"

        }

        tap22.setOnClickListener{

            var prefedit:SharedPreferences.Editor
            prefedit=sharedp.edit()
            prefedit.putString("ecompname","asia")
            prefedit.apply()
            Toast.makeText(context, "Asia selected", Toast.LENGTH_LONG).show()        }

        tap33.setOnClickListener{

            var prefedit:SharedPreferences.Editor
            prefedit=sharedp.edit()
            prefedit.putString("ecompname","korek")
            prefedit.apply()
            Toast.makeText(context, "Korek selected", Toast.LENGTH_LONG).show()
           // titlee.text="Korek"
        }

        var ecompname=sharedp.getString("comp_name","null")
        if (ecompname!=="null"){
            tap44.setImageResource(R.drawable.sim)
            labe.text=ecompname
        }
        tap44.setOnClickListener{

            var prefedit:SharedPreferences.Editor
            prefedit=sharedp.edit()
            prefedit.putString("ecompname","comp_name")
            prefedit.apply()
            var ecompname=sharedp.getString("comp_name","null")
            Toast.makeText(context, ecompname+" selected", Toast.LENGTH_LONG).show()

           // titlee.text=ecompname
        }


        return rootView
    }












}