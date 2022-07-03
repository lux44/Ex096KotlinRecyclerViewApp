package com.lux.ex096kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //늦은 초기화  - val 전용 : by lazy
    val recycler:RecyclerView by lazy { findViewById(R.id.recycler) }

    //대량의 데이터들 리스트 참조변수
    var items= mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //대량의 데이터들을 추가
        items.add(Item("sam","hello",R.drawable.newyork))
        items.add(Item("hong","hi",R.drawable.soil))
        items.add(Item("robin","bye",R.drawable.paris))
        items.add(Item("robin","bye",R.drawable.sydney))
        items.add(Item("sam","hello",R.drawable.newyork))
        items.add(Item("hong","hi",R.drawable.soil))
        items.add(Item("robin","bye",R.drawable.paris))
        items.add(Item("robin","bye",R.drawable.sydney))
        
        //코틀린은 set~~, get~~ 를 그냥 .xxx = 변수로 사용하는 방식을 권장함.
        recycler.adapter=MyAdapter(this, items)
        
        //리사이클러뷰의 레이아웃 매니저 설정하기
        recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun onResume() {
        super.onResume()
        //리사이클러뷰가 보여줄 데이터가 변경되어 화면갱신이 필요할때 
        recycler.adapter?.notifyDataSetChanged()    //adapter 는 nullable
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //MenuInflater 는 액티비티의 멤버로 존재함 getMenu..    하지마
        //set,,get,, 는 그냥 .xxx= 로 사용
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_aa-> Toast.makeText(this, "aaa", Toast.LENGTH_SHORT).show()
            R.id.menu_bb-> Toast.makeText(this, "bbb", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}