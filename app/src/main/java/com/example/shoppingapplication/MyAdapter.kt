package com.example.shoppingapplication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter (val context: Activity, val productList: List<Product>  ):RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {

    //if layout manager fails to create view for some data this method is called
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)

    return MyViewHolder(itemView)
    }


//Populate data in the View
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
      val currentItem = productList[position]

    holder.title.text = currentItem.title
    //show image as well
    //to put image links into view we use a 3rd party dependency called picasso

    Picasso.get().load(currentItem.thumbnail).into(holder.image);


}

    //return size of the list

    override fun getItemCount(): Int {
  return productList.size
    }



    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var image:ShapeableImageView
        var title:TextView

        init{

            image = itemView.findViewById(R.id.productImage)
            title = itemView.findViewById(R.id.productName)

        }

    }
}


