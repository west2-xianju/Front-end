package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.NotGetAdapter
import com.example.myapplication.adapter.NotsendAdapter
import com.example.myapplication.data.NotgetGood
import com.example.myapplication.databinding.ActivityNotsendoutBinding

class NotsendoutActivity : AppCompatActivity() {
    private val notsendList = ArrayList<NotgetGood>()
    private lateinit var binding: ActivityNotsendoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotsendoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initNotesendGood()
        val layoutManager = LinearLayoutManager(this)
        binding.notsendrecycleview.layoutManager = layoutManager
        val adapter = NotsendAdapter(this,notsendList)
        binding.notsendrecycleview.adapter = adapter
        adapter.setOnItemClickListener {
            val intent= Intent(this, Notsenddetail::class.java)
            intent.putExtra("notsend", notsendList.get(it))//强转
            startActivity(intent)
        }
    }

    private fun initNotesendGood() {
        notsendList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","圆神","出元神","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","25314","empty"))
        notsendList.add(NotgetGood(123,666,444,5,"已发货",200f,"2022.5","2022.5","csgo","出csgo","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","666","小怪兽游戏屋"))
        notsendList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","女神异闻录","出女神5","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","777","潮玩旗舰店"))
        notsendList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","圆神","出老头环","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","25314","empty"))
        notsendList.add(NotgetGood(123,666,444,5,"已发货",200f,"2022.5","2022.5","csgo","出csgo","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","666","小怪兽游戏屋"))
        notsendList.add(NotgetGood(123,666,444,5,"待发货",200f,"2022.5","2022.5","女神异闻录","出女神5皇家版","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg","777","潮玩旗舰店"))
    }
}