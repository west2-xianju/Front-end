package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.AllRefundAdapter
import com.example.myapplication.adapter.NotGetAdapter
import com.example.myapplication.data.NotgetGood
import com.example.myapplication.databinding.ActivityAllrefundBinding

class AllrefundActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAllrefundBinding
    private val allrefundList = ArrayList<NotgetGood>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAllrefundBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        initAllRefundGood()
        val layoutManager = LinearLayoutManager(this)
        binding.refundrecycleview.layoutManager = layoutManager
        val adapter = AllRefundAdapter(allrefundList,this)
        binding.refundrecycleview.adapter = adapter

        adapter.setOnItemClickListener {
            val intent= Intent(this, Allrefund_detial::class.java)
            intent.putExtra("allrefund", allrefundList.get(it))//强转
            startActivity(intent)
        }

    }

    private fun initAllRefundGood() {
        allrefundList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","圆神","出元神","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","25314","empty"))
        allrefundList.add(NotgetGood(123,666,444,5,"已发货",200f,"2022.5","2022.5","csgo","出csgo","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","666","小怪兽游戏屋"))
        allrefundList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","女神异闻录","出女神5","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","777","潮玩旗舰店"))
    }
}