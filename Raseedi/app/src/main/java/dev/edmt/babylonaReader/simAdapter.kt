/*
package dev.edmt.androidcamerarecognitiontext


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by Mohammed on 25/04/2018.
 */
class simAdapter (var mCtx: Context, var resource:Int, var items:List<comp_name>)
    : ArrayAdapter<comp_name>( mCtx , resource , items ) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        var textView : TextView = view.findViewById(R.id.mySim) as TextView

        var comp_name : comp_name = items[position]
        textView.text = comp_name.comp

        return view

    }


}
        */