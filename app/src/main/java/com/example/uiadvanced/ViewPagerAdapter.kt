package com.example.uiadvanced

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    val myImages: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val currentImage = myImages[position]
        holder.bind(currentImage)
    }

    override fun getItemCount(): Int {
        return myImages.size
    }

    class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val SliderImage = itemView.findViewById<ImageView>(R.id.SliderImage)


        fun bind(currentImage: Int) {
            SliderImage.setImageResource(currentImage)
        }
    }
}
