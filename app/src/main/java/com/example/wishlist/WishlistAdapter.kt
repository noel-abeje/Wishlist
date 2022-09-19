package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishlist: List<Wishlist>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            senderTextView = itemView.findViewById(R.id.item)
            titleTextView = itemView.findViewById(R.id.price)
            summaryTextView = itemView.findViewById(R.id.store)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = wishlist.get(position)
        // Set item views based on views and data model
        holder.senderTextView.text = email.item
        holder.titleTextView.text = email.price
        holder.summaryTextView.text = email.store
    }

    override fun getItemCount(): Int {
        return wishlist.size
    }
}