package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.CommentAdapter
import com.example.myapplication.adapter.FinishAdapter
import com.example.myapplication.data.Comment
import com.example.myapplication.data.NotgetGood
import com.example.myapplication.databinding.ActivityAllcommentBinding

class AllcommentActivity : AppCompatActivity() {
    private val commentList = ArrayList<Comment>()
    private lateinit var binding: ActivityAllcommentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAllcommentBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        initComment()
        val layoutManager = LinearLayoutManager(this)
        binding.commentrecycleview.layoutManager = layoutManager
        val adapter = CommentAdapter(commentList,this)
        binding.commentrecycleview.adapter = adapter

        adapter.setOnItemClickListener {
            val intent= Intent(this, Commentdetail::class.java)
            intent.putExtra("comment", commentList.get(it))//强转
            startActivity(intent)
        }
    }

    private fun initComment() {
        commentList.add(Comment(66,15435,65456,1515,"宝贝不错，喜欢喜欢","2023.5.1",5,false,"","http://dummyimage.com/400x400","doudou12354","豆豆","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg"))
        commentList.add(Comment(5436,1888885,65456,1515,"发货速度很快，好评","2023.5.1",4,false,"","http://dummyimage.com/400x400","doudou12354","傻猫","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg"))
        commentList.add(Comment(45123,14531,65456,1515,"客服态度很差！","2023.5.1",1,false,"","http://dummyimage.com/400x400","doudou12354","库罗迷","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg"))
        commentList.add(Comment(778645,1523785,65456,1515,"默认好评！","2023.5.1",5,false,"","http://dummyimage.com/400x400","doudou12354","奥奥","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg"))
    }
}