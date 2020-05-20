package com.example.android.plantsapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class InfoActivity : AppCompatActivity(), View.OnClickListener {
    private var tomatoCard: CardView? = null
    private var pepperCard: CardView? = null
    private var potatoCard: CardView? = null
    private var cornCard: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_activity)

        tomatoCard = findViewById<View>(R.id.tomatocardId) as CardView
        pepperCard = findViewById<View>(R.id.peppercardId) as CardView
        potatoCard = findViewById<View>(R.id.potatocardId) as CardView
        cornCard = findViewById<View>(R.id.corncardId) as CardView
        tomatoCard!!.setOnClickListener(this)
        pepperCard!!.setOnClickListener(this)
        potatoCard!!.setOnClickListener(this)
        cornCard!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val i: Intent
        when (v.id) {
            R.id.tomatocardId -> {
                i = Intent(this, Tomato::class.java)
                startActivity(i)
            }
            R.id.peppercardId -> {
                i = Intent(this, Pepper::class.java)
                startActivity(i)
            }
            R.id.potatocardId -> {
                i = Intent(this, Potato::class.java)
                startActivity(i)
            }
            R.id.corncardId -> {
                i = Intent(this, Corn::class.java)
                startActivity(i)
            }
            else -> {
            }
        }
    }
}