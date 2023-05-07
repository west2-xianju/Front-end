package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.FinishAdapter
import com.example.myapplication.adapter.FinishAdapter2
import com.example.myapplication.data.NotgetGood
import com.example.myapplication.databinding.ActivityFinish2Binding

class Finish2Activity : AppCompatActivity() {
    private val finishList = ArrayList<NotgetGood>()
    private lateinit var binding: ActivityFinish2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFinish2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        initFinishGood()
        val layoutManager = LinearLayoutManager(this)
        binding.finishrecycleview.layoutManager = layoutManager
        val adapter = FinishAdapter2(this,finishList)
        binding.finishrecycleview.adapter = adapter
        adapter.setOnItemClickListener {
            val intent= Intent(this,FinishDtail2::class.java)
            intent.putExtra("finish", finishList.get(it))//强转
            startActivity(intent)
        }
    }

    private fun initFinishGood() {
        finishList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","圆神","出元神","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","25314","empty"))
        finishList.add(NotgetGood(123,666,444,5,"已发货",200f,"2022.5","2022.5","csgo","出csgo","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","666","小怪兽游戏屋"))
        finishList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","女神异闻录","出女神5","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","777","潮玩旗舰店"))

    }
}