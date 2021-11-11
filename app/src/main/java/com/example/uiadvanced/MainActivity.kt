package com.example.uiadvanced

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var newRecycler: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemsViewModel>

    //private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var imageId: Array<Int>
    lateinit var textId: Array<String>
    lateinit var pipeId: Array<Int>
    lateinit var daysleftId: Array<String>
    lateinit var dateId: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagesList = listOf(
            R.drawable.imageone,
            R.drawable.imagetwo,
            R.drawable.viewpager_image_one,
            R.drawable.viewpager_imagetwo,
        )


        //Recycler information


        val adapter = ViewPagerAdapter(imagesList)
        viewPager2 = findViewById(R.id.viewPager)
        viewPager2.adapter = adapter

        imageId = arrayOf(
            R.drawable.recycler_imageone,
            R.drawable.recycler_imagetwo,
            R.drawable.recyler_imagefour
        )

        textId = arrayOf(
            "Egbosi cosmas",
            "Dennis odalonu",
            "Macovenni buhari"

        )

        pipeId = arrayOf(
            R.drawable.pipe,
            R.drawable.pipe,
            R.drawable.pipe

        )


        daysleftId = arrayOf(
            "40 days left",
            "20 days left",
            "25 days left",
        )

        dateId = arrayOf(
            "2010 20",
            "2010 12",
            "2012 10"
        )
        // getting the recyclerview by its id
        newRecycler = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        newRecycler.layoutManager = LinearLayoutManager(this)
        newRecycler.setHasFixedSize(true)
        newArrayList = arrayListOf<ItemsViewModel>()
        getUserdata()

    }

    fun getUserdata() {
        for (i in imageId.indices) {
            val itemsViewModel =
                ItemsViewModel(imageId[i], textId[i], pipeId[i], daysleftId[i], dateId[i])
            newArrayList.add(itemsViewModel)
        }
        newRecycler.adapter = RecyclerAdapter(newArrayList)
    }


}






