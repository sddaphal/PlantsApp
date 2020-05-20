package com.example.android.plantsapp

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.intro_activity.*
import org.w3c.dom.Text

class IntroActivity: AppCompatActivity()  {

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Tomato",
                "Tomato is one of the vegetables that you can grow at your house, " +
                        " although their leaves get affected by many diseases over their growth such as: bacterial spot," +
                        ", early blight, late blight, yellow leaf curl, septoria leaf spot, and spider mites",
                R.drawable.tomatoleave
            ),
            IntroSlide(
                "Potato",
                "Potato is one of the vegetables that you can grow at your house" +
                        "although their leaves get affected by many diseases over their growth such as: early blight" +
                        ", and late blight",
                R.drawable.potatoleave
            ),
            IntroSlide(
                "Corn",
                "Corn is one of the vegetables that you can grow at your house" +
                        "although their leaves get affected by many diseases over their growth such as: northern leaf blight" +
                        ", and common rust",
                R.drawable.cornleave
            ),
            IntroSlide(
                "Pepper",
                "Pepper is one of the vegetables that you can grow at your house" +
                        "although their leaves get affected by many diseases over their growth such as: bell bacterial spot",
                R.drawable.pepperleave
            )

        )

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)

            introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)
        introSliderViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        buttonNext.setOnClickListener{
            if(introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount){
                introSliderViewPager.currentItem  +=1
            }
            else{
                Intent(applicationContext, MainActivity::class.java).also {
                    startActivity(it)
                    finish()
                }

            }
        }
        textSkipIntro.setOnClickListener{
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
        }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
       layoutParams.setMargins(8, 0, 8,0)
       for(i in indicators.indices )
       {
           indicators[i]= ImageView(applicationContext)
           indicators[i].apply {
               this?.setImageDrawable(
                   ContextCompat.getDrawable(
                       applicationContext,
                       R.drawable.indicator_inactive
                   )
               )
               this?.layoutParams= layoutParams
           }
           indicatorsContainer.addView(indicators[i])
       }
    }

    private fun setCurrentIndicator(index: Int){
        val childcount=indicatorsContainer.childCount
        for(i in 0 until childcount)
        {
            val imageView = indicatorsContainer[i] as ImageView
            if(i==index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }
            else
            {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

}
