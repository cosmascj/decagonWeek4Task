package com.example.uiadvanced

import android.content.Intent
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.graphics.Insets.add
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.OneShotPreDrawListener.add
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var newRecycler: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemsViewModel>

    private lateinit var imageId: Array<Int>
    lateinit var textId: Array<String>
    lateinit var pipeId: Array<Int>
    lateinit var daysleftId: Array<String>
    lateinit var dateId: Array<String>
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Find Images for the view page below
        val imagesList = listOf(
            R.drawable.imageone,
            R.drawable.imagetwo,
            R.drawable.viewpager_imagethree,
            R.drawable.viewpager_image_one,
            R.drawable.viewpager_imagetwo,
            R.drawable.viewpager_imagesfive
        )

        val adapter = ViewPagerAdapter(imagesList)
        viewPager2 = findViewById(R.id.viewPager)
        viewPager2.adapter = adapter

        // setting the viewpager image transformation

        viewPager2.setPadding(110, 0, 110, 0)
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
        val viewPageTransformer = CompositePageTransformer()
        viewPageTransformer.addTransformer(MarginPageTransformer(10))
        viewPageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        viewPager2.setPageTransformer(viewPageTransformer)

        //Recycler information

        imageId = arrayOf(
            R.drawable.recycler_imageone,
            R.drawable.recycler_imagetwo,
            R.drawable.recyler_imagefour,
            R.drawable.recycler_imagetwo,
            R.drawable.recycler_imagetwo,
            R.drawable.recycler_imageone,
            R.drawable.recyler_imagefour,
            R.drawable.recycler_imagetwo


        )

        textId = arrayOf(
            "Egbosi Akpan",
            "Dennis Buhari",
            "Macovenni buhari",
            "osibanjo Ruth",
            "Dennis Buhari",
            "Ify Asemota",
            "Macovenni buhari",
            "osibanjo Ruth",


            )

        pipeId = arrayOf(
            R.drawable.pipe,
            R.drawable.red_pipe_icon,
            R.drawable.pipe,
            R.drawable.green_pipe_icon,
            R.drawable.pipe,
            R.drawable.red_pipe_icon,
            R.drawable.pipe,
            R.drawable.green_pipe_icon,
        )


        daysleftId = arrayOf(
            "40 days left",
            "20 days left",
            "25 days left",
            "20 days left",
            "40 days left",
            "20 days left",
            "25 days left",
            "20 days left",
        )

        dateId = arrayOf(
            "2010 20",
            "2010 12",
            "2012 10",
            "2010 11",
            "2010 12",
            "2012 10",
            "2012 10",
            "2010 11"
        )
        // getting the recyclerview by its id
        newRecycler = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        newRecycler.layoutManager = LinearLayoutManager(this)
        newRecycler.setHasFixedSize(true)
        newArrayList = arrayListOf()
        getUserdata()

    }

    // This function will iterate througn the array to get the index of each component
    private fun getUserdata() {
        for (i in imageId.indices) {
            val itemsViewModel =
                ItemsViewModel(imageId[i], textId[i], pipeId[i], daysleftId[i], dateId[i])
            newArrayList.add(itemsViewModel)
        }
        newRecycler.adapter = RecyclerAdapter(newArrayList)
    }


}







