package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.NopayAdapter
import com.example.myapplication.adapter.NotGetAdapter
import com.example.myapplication.data.NotgetGood
import com.example.myapplication.databinding.ActivityNopayBinding

class NopayActivity : AppCompatActivity() {
    private val notpayList = ArrayList<NotgetGood>()
    private lateinit var binding: ActivityNopayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNopayBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        initNotpayGood()
        val layoutManager = LinearLayoutManager(this)
        binding.nopayrecycleview.layoutManager = layoutManager
        val adapter = NopayAdapter(this,notpayList)
        binding.nopayrecycleview.adapter = adapter
        adapter.setOnItemClickListener {
            val intent= Intent(this, Notpaydetail::class.java)
            intent.putExtra("notpay", notpayList.get(it))//强转
            startActivity(intent)
        }

    }

    private fun initNotpayGood() {
        notpayList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","圆神","出元神","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","25314","empty"))
        notpayList.add(NotgetGood(123,666,444,5,"已发货",200f,"2022.5","2022.5","csgo","出csgo","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","666","小怪兽游戏屋"))
        notpayList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","女神异闻录","出女神5","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","777","潮玩旗舰店"))
        notpayList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","圆神","出老头环","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","25314","empty"))
        notpayList.add(NotgetGood(123,666,444,5,"已发货",200f,"2022.5","2022.5","csgo","出csgo","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","666","小怪兽游戏屋"))
        notpayList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","女神异闻录","出女神5皇家版","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","777","潮玩旗舰店"))

    }
}