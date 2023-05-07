package com.example.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.GoodAdapter
import com.example.myapplication.data.Good
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.GoodDteil

class HomeFragment : Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!

    val goods= mutableListOf<Good>(Good(1,56782,0,"原神","白菜价出","装备齐全哈","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg", 500F),Good(1,1,0,"原神","白菜价出","装备齐全哈","http://dummyimage.com/400x400", 500F),
            Good(1,2333,0,"老头环","白菜价出","装备齐全哈","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg", 500F),Good(1,905444,0,"王者荣耀","白菜价出","装备齐全哈","http://dummyimage.com/400x400", 500F),
        Good(1,666,0,"奥比岛","白菜价出","装备齐全哈","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg", 500F),Good(1,867755,0,"光遇","白菜价出","装备齐全哈","http://dummyimage.com/400x400", 500F),
        Good(1,8765,0,"奇迹暖暖","白菜价出","装备齐全哈","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg", 500F),Good(1,22540,0,"csgo","白菜价出","装备齐全哈","http://dummyimage.com/400x400", 500F),
        Good(1,4435,0,"吃鸡","白菜价出","装备齐全哈","http://dmimg.5054399.com/allimg/shiyan/djy/2.jpg", 500F),Good(1,83445,0,"女神异闻录5","白菜价出","装备齐全哈","http://dummyimage.com/400x400", 500F))
    val goodsList=ArrayList<Good>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        val view = binding.root
         return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGoods()
        val layoutManager = GridLayoutManager(context, 2)//
        binding.recyclerView.layoutManager = layoutManager
        val adapter =GoodAdapter(this, goodsList)
        binding.recyclerView.adapter=adapter

            adapter.setOnItemClickListener() {
                val intent= Intent(activity, GoodDteil::class.java)
                intent.putExtra("good", goodsList.get(it))//强转
                startActivity(intent)
            }

    }

    private fun initGoods() {
        goodsList.clear()
        repeat(50){
            val index = (0 until goods.size).random()
            goodsList.add(goods[index])
        }
    }


}