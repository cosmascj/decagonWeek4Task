package com.example.uiadvanced

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

open class RecyclerAdapter(private var mList: List<ItemsViewModel>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem  = mList[position]
        holder.shapedView.setImageResource(currentItem.shapedView)
        holder.textView.text = currentItem.text
        holder.pipeView.setImageResource(currentItem.pipe)
        holder.daysleftView.text = currentItem.daysleft
        holder.dateView.text = currentItem.date

        // sets the text to the textview from our itemHolder class

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val shapedView: ShapeableImageView = itemView.findViewById(R.id.shapedImage)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val pipeView: ImageView = itemView.findViewById(R.id.pipe_icon)
        val daysleftView: TextView = itemView.findViewById(R.id.daysRemaining)
        val dateView: TextView = itemView.findViewById(R.id.dateText)
    }


    }

