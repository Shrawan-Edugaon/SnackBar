package com.example.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mSimpleSnackBar:Button
    private lateinit var mCallbackSnackBar:Button
    private lateinit var mCustomSnackBar:Button
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSimpleSnackBar = findViewById(R.id.SimpleSnackbar)
        mCallbackSnackBar = findViewById(R.id.CallBackSnackbar)
        mCustomSnackBar = findViewById(R.id.CustomSnackbar)
        linearLayout = findViewById(R.id.coordinatorContainer)

        mSimpleSnackBar.setOnClickListener {
            val snackbar:Snackbar = Snackbar.make(linearLayout,"This is Simple Snackbar...",Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        mCallbackSnackBar.setOnClickListener {
            val snackbar1 :Snackbar = Snackbar.make(linearLayout,"Deleted Message...",Snackbar.LENGTH_LONG)
                .setAction("UNDO",{
                    val snackbar2:Snackbar = Snackbar.make(linearLayout,"Restored Message...",Snackbar.LENGTH_LONG)
                    snackbar2.show()
                })
            snackbar1.show()
        }
        mCustomSnackBar.setOnClickListener {
            val snackbar:Snackbar = Snackbar.make(linearLayout,"This is Custom Snackbar...",Snackbar.LENGTH_LONG)
                .setAction("RETRY",{})
            snackbar.setActionTextColor(Color.MAGENTA)

            val snackbarView:View = snackbar.view
            val txtView:TextView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text)
            txtView.setTextColor(Color.RED)
            snackbar.show()
        }
    }
}