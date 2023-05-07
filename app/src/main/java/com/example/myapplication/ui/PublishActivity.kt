package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.NotGetAdapter
import com.example.myapplication.adapter.PublishAdapter
import com.example.myapplication.data.NotgetGood
import com.example.myapplication.databinding.ActivityPublishBinding

class PublishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPublishBinding
    private val publishList = ArrayList<NotgetGood>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPublishBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        initPublishGood()
        val layoutManager = LinearLayoutManager(this)
        binding.publishrecycleview.layoutManager = layoutManager
        val adapter = PublishAdapter(publishList,this)
        binding.publishrecycleview.adapter = adapter

        adapter.setOnItemClickListener() {
            val intent= Intent(this, PublishDetail::class.java)
            intent.putExtra("publish", publishList.get(it))//强转
            startActivity(intent)
        }
        adapter.setOnCprice {
            val intent= Intent(this, CpriceActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initPublishGood() {
        publishList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","圆神","出元神","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","25314","empty"))
        publishList.add(NotgetGood(123,666,444,5,"已发货",200f,"2022.5","2022.5","csgo","出csgo","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","666","小怪兽游戏屋"))
        publishList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","女神异闻录","出女神5","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","777","潮玩旗舰店"))
        publishList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","圆神","出老头环","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","25314","empty"))
        publishList.add(NotgetGood(123,666,444,5,"已发货",200f,"2022.5","2022.5","csgo","出csgo","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","666","小怪兽游戏屋"))
        publishList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","女神异闻录","出女神5皇家版","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","777","潮玩旗舰店"))

    }
}