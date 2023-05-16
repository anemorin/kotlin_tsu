package com.example.myfirstapplication
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.zhpan.indicator.IndicatorView
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle


class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val data = listOf(
            DataPage(R.drawable.page_one,
                getString(R.string.welcome_title_one),
                getString(R.string.welcome_text)),
            DataPage(R.drawable.page_two,
                getString(R.string.welcome_title_two),
                getString(R.string.welcome_text)),
            DataPage(R.drawable.page_three,
                getString(R.string.welcome_title_three),
                getString(R.string.welcome_text)))

        val adapter = ViewPagerAdapter(data)
        var viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter

        val indicatorView = findViewById<IndicatorView>(R.id.indicatorView)
        indicatorView.apply {
            setSliderColor(Color.LTGRAY, Color.rgb(238, 150, 23))
            setSliderWidth(
                resources.getDimension(R.dimen.default_6dp),
                resources.getDimension(R.dimen.default_16dp)
            )
            setSliderHeight(resources.getDimension(R.dimen.default_6dp))
            setSlideMode(IndicatorSlideMode.SCALE)
            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setPageSize(viewPager.adapter!!.itemCount)
            notifyDataChanged()
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                indicatorView.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicatorView.onPageSelected(position)

                when (position) {
                    2 -> {
                        findViewById<Button>(R.id.button2).text = "Let's Start!"
                    }

                    else -> {
                        findViewById<Button>(R.id.button2).text = "Next"
                    }
                }
            }

        })

        fun getItem(i: Int): Int {
            return viewPager.getCurrentItem() + i
        }

        val yourButton = findViewById<View>(R.id.button2) as Button
        yourButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if (getItem(1) != 3)
                    viewPager.setCurrentItem(getItem(1), true)
                else {
                    val intent = Intent(this@StartActivity, SignUpActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }
}
