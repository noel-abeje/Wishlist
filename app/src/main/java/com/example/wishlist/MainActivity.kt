package com.example.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
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

            val thing = Wishlist(et_item.text.toString(), Integer.parseInt(et_price.toString()), et_store.text.toString())
            wishlist.add(thing)

            val adapter =WishlistAdapter(wishlist)
            wishlistRv.adapter = adapter

            wishlistRv.layoutManager = LinearLayoutManager(this)

            et_item.text.clear()
            et_item.hideKeyboard()
            et_price.text.clear()
            et_store.text.clear()

        }

    }
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
