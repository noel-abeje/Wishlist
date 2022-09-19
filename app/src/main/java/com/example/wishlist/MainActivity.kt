package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var wishlist = ArrayList<Wishlist>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)

        var et_item = findViewById<EditText>(R.id.et_item)
        var et_price = findViewById<EditText>(R.id.et_price)
        var et_store = findViewById<EditText>(R.id.et_store)


        button.setOnClickListener {

            val thing = Wishlist(et_item.text.toString(), et_price.text.toString(), et_store.text.toString())
            wishlist.add(thing)

            val adapter =WishlistAdapter(wishlist)
            wishlistRv.adapter = adapter

            wishlistRv.layoutManager = LinearLayoutManager(this)

        }

    }
}
