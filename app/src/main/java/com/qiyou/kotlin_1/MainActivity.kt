package com.qiyou.kotlin_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: MutableList<String> = ArrayList()
    private lateinit var adapter: RvAdpter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = getList()
        adapter = RvAdpter(list, this)
        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_test.layoutManager = linearLayoutManager
        rv_test.adapter = adapter
        adapter.setOnItemClick(object : RvAdpter.OnItemClickListener {
            override fun OnItemClick(view: View, position: Int) {
                Toast.makeText(this@MainActivity, position.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }


    fun getList(): MutableList<String> {

        for (i in 1..10) {
            list.add(i.toString())
        }
        return list
    }


}

