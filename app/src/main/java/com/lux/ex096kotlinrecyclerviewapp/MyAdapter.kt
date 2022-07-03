package com.lux.ex096kotlinrecyclerviewapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context:Context, var items:MutableList<Item>) : RecyclerView.Adapter<MyAdapter.VH>() {
    inner class VH (itemView:View): RecyclerView.ViewHolder(itemView){
        val tvTitle:TextView by lazy { itemView.findViewById(R.id.tv_title) }
        val tvMsg:TextView by lazy { itemView.findViewById(R.id.tv_msg) }
        val iv:ImageView by lazy { itemView.findViewById(R.id.iv) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater:LayoutInflater = LayoutInflater.from(context)
        val itemView:View=inflater.inflate(R.layout.recycler_item,parent,false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val  item=items.get(position)
        holder.tvTitle.setText(item.title)
        holder.tvMsg.text=item.msg  //코틀린은 set~~, get~~을 선호하지 않음
        holder.iv.setImageResource(item.img)

        //아이템뷰가 클릭되었을때 반응하기
        holder.itemView.setOnClickListener {
            //ItemActivity 를 실행하면서 클릭한 Item 의 정보를 넘겨주기
            val intent:Intent= Intent(context,ItemActivity::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("msg", item.msg)
            intent.putExtra("img", item.img)


            //화면 전환시에 연관된 뷰들의 전환 효과 적용하기
            val optionsCompat:ActivityOptionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(context as MainActivity,
                Pair(holder.iv,"zzz") //애니메이션을 적용할 뷰에 별칭을 적용
            )
            context.startActivity(intent,optionsCompat.toBundle())

        }
    }

    //함수의 리턴값을 할당 연산자로 줄여 쓸 수 있다.
    override fun getItemCount(): Int =items.size
}