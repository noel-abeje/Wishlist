package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wishlist: List<Wishlist>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        var item = findViewById<TextView>(R.id.item)
        var price = findViewById<TextView>(R.id.price)
        var store = findViewById<TextView>(R.id.store)
        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)

        var et_item = findViewById<EditText>(R.id.et_item)
        var et_price = findViewById<EditText>(R.id.et_price)
        var et_store = findViewById<EditText>(R.id.et_store)

        button.setOnClickListener {
            val wishlist = Wishlist(item.toString(), price.toString(), store.toString())
        }
    }
}