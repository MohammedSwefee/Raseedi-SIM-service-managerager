package dev.edmt.babylonaReader.zain

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.*
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer
import dev.edmt.babylonaReader.R
import java.io.IOException

class zain : AppCompatActivity() {

    var myfile="dev.edmt.androidcamerarecognitiontext.myfile"
    lateinit var sharedp: SharedPreferences
    internal lateinit var cameraViewcar: SurfaceView
    internal lateinit var textViewcar: TextView
    internal lateinit var wwcar: EditText
    internal lateinit var last_reading: TextView
    //internal lateinit var zz: TextView
    internal lateinit var cameraSource: CameraSource
    internal val RequestCameraPermissionID: Int = 1001
    lateinit var checkcar: Button
    lateinit var readcar: Button
    lateinit var call: ImageView
    private val REQUEST_CALL = 1


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            RequestCameraPermissionID -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return

                    }
                    cameraViewcar = findViewById(R.id.surface_viewcar) as SurfaceView
                    try {
                        cameraSource.start(cameraViewcar.holder)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            }
        }

        /*if (requestCode == REQUEST_CALL) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                call()
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show()
            }
*/    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zain)

        sharedp=getSharedPreferences(myfile, Context.MODE_PRIVATE)
        var ecompname=sharedp.getString("ecompname","null")
        var cod=sharedp.getString("cod","null")

        cameraViewcar = findViewById(R.id.surface_viewcar) as SurfaceView
        readcar = findViewById(R.id.readcar) as Button
        textViewcar = findViewById(R.id.text_viewcar) as TextView
        wwcar = findViewById(R.id.wwcar) as EditText
        call = findViewById(R.id.call) as ImageView

        call.setOnClickListener {

            if (ecompname=="zain"){call("*101#","","")}
            else if (ecompname=="asia"){call("*133*","","")}
            else if (ecompname=="korek"){call("*221*","","")}
            else if (ecompname=="comp_name"){call(cod,"","")}


        }


        readcar.setOnClickListener {
            wwcar.text = null
            var length = textViewcar.text.length
            var min = 0
            for (i in 0..length) {
                var max = min + 1
                if (max < length) {
                    var dd = textViewcar.text.subSequence(startIndex = min, endIndex = max).toString()
                    try {
                        var ii = Integer.parseInt(dd.replace("[\\D]".toRegex(), ""))
                        var y = wwcar.text
                        wwcar.setText(y.toString() + ii.toString())
                        min = min + 1
                    } catch (e: NumberFormatException) {
                        min = min + 1
                    }
                }
            }
        }


        val textRecognizer = TextRecognizer.Builder(applicationContext).build()
        if (!textRecognizer.isOperational) {
            Log.w("MainActivity", "Detector dependencies are not yet available")
        } else {

            cameraSource = CameraSource.Builder(applicationContext, textRecognizer)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(1280, 1024)
                    .setRequestedFps(2.0f)
                    .setAutoFocusEnabled(true)
                    .build()

            cameraViewcar.holder.addCallback(object : SurfaceHolder.Callback {
                override fun surfaceCreated(surfaceHolder: SurfaceHolder) {

                    try {
                        if (ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions(this@zain,
                                    arrayOf(Manifest.permission.CAMERA),
                                    RequestCameraPermissionID)
                            return
                        }
                        cameraSource.start(cameraViewcar.holder)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }

                override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {}

                override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
                    cameraSource.stop()
                }
            })

            textRecognizer.setProcessor(object : Detector.Processor<TextBlock> {
                override fun release() {}

                override fun receiveDetections(detections: Detector.Detections<TextBlock>) {

                    val items = detections.detectedItems
                    if (items.size() != 0) {
                        textViewcar.post {
                            val stringBuilder = StringBuilder()
                            for (i in 0 until items.size()) {
                                val item = items.valueAt(i)
                                stringBuilder.append(item.value)
                            }
                            textViewcar.text = stringBuilder.toString()

                        }

                    }
                }
            })
        }


    }


    @SuppressLint("MissingPermission")
    private fun call(a:String, ba:String, c:String ) {

        val b=wwcar.text.toString()

        val sbb = StringBuilder(a)

        var test=""
        var len= a.length
        if (len==5){  test =a[4].toString()}
        var cod=""
        var hash =Uri.encode("#")
        if(test == "#"){
            sbb.deleteCharAt(4)
             cod = sbb.toString()


        }

        else if(test=="*"){ cod =a ;hash=""}


         var number=cod+hash+b+Uri.encode("#")
        Toast.makeText(this, a+b+"#", Toast.LENGTH_LONG).show()

        if (number.trim { it <= ' ' }.length > 0) {

            if (ContextCompat.checkSelfPermission(this@zain,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this@zain,
                        arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CALL)
            } else {

                val dial = "tel:$number"
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))

            }

        } else {
            Toast.makeText(this@zain, "Enter Phone Number", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }


}