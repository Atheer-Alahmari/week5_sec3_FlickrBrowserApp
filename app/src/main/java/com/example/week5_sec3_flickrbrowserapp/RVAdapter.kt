package com.example.week5_sec3_flickrbrowserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class RVAdapter(private var list_phto: ArrayList<Photo>, val activity: MainActivity): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val myPhotos = list_phto[position]

        var server = myPhotos.server
        var id = myPhotos.id
        var secret = myPhotos.secret

        holder.itemView.apply {
            textView.text = myPhotos.title

            Glide.with(this)
                .load("https://farm66.staticflickr.com/$server/${id}_${secret}.jpg")
                .centerCrop()
                .into(image_View) //يعرض الصورة في imageview

            textView.setOnClickListener {
                Glide.with(this)
                    .load("https://farm66.staticflickr.com/$server/${id}_${secret}.jpg")
                    .centerCrop()
                    .into(activity.imageView2)//يعرض الصورة في imageview2 على الشاشة كامله
                activity.imageView2.isVisible = true
                activity.linearLayout2.isVisible = false
            }

            image_View.setOnClickListener {
                Glide.with(this)
                    .load("https://farm66.staticflickr.com/$server/${id}_${secret}.jpg")
                    .centerCrop()
                    .into(activity.imageView2)//يعرض الصورة في imageview2 على الشاشة كامله
                activity.imageView2.isVisible = true
                activity.linearLayout2.isVisible = false

            }
            activity.imageView2.setOnClickListener {
                activity.imageView2.isVisible = false
                activity.linearLayout2.isVisible = true
            }
        }
    }

    override fun getItemCount() = list_phto.size


}