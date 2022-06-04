/*


package dev.edmt.androidcamerarecognitiontext

import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dev.edmt.androidcamerarecognitiontext.zain.zain

import kotlinx.android.synthetic.main.activity_view.*
import kotlinx.android.synthetic.main.fragment_view.*
import kotlinx.android.synthetic.main.fragment_view.view.*
import kotlinx.android.synthetic.main.zain.*
import dev.edmt.androidcamerarecognitiontext.view
import android.app.Activity



class view : AppCompatActivity() {


    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        fab.setOnClickListener { view ->
            val myIntent = Intent(this, zain::class.java)
            startActivity(myIntent)
           // Snackbar.make(view, "insert code", Snackbar.LENGTH_LONG).context.startActivity(Intent(this, zain::class.java))
                   // .setAction("Dissmiss", null).show()




            var im =findViewById(R.id.image_v)
            var qq="sec"+section_label.text


           // var e=im.section_label
            im.setOnClickListener{
                view ->
                if(qq=="sec1"){
                val myIntent = Intent(this, zain::class.java)
                startActivity(myIntent)
            }
            }
        }

    }







    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu) //****************************************
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //myp=position+1
            return PlaceholderFragment.newInstance(position +1)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        var img="ss"
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_view, container, false)
            rootView.section_label.text = arguments.getInt(ARG_SECTION_NUMBER).toString()
               // var a=arguments.getInt(ARG_SECTION_NUMBER)
              img="sec"+arguments.getInt(ARG_SECTION_NUMBER).toString()
            var q=resources.getIdentifier(img,"drawable", context?.packageName)







            rootView.image_v.setImageResource(q)
            //img=rootView.image_v.resources.toString()

            //rootView.image_v.setImageResource(R.drawable.yy)
            return rootView

        }


        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"



            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }

        }


    }
}


        */