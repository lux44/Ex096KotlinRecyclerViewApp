package com.lux.ex096kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemActivity : AppCompatActivity() {

    val iv:ImageView by lazy { findViewById(R.id.iv) }
    //val tv by lazy { findViewById(R.id.tv) as TextView }
    val tv by lazy { findViewById<TextView>(R.id.tv) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        //넘어온 intent 에게 데이터들 받기
        val title=intent.getStringExtra("title")
        val message=intent.getStringExtra("msg")
        val img=intent.getIntExtra("img",R.drawable.soil)

        //title 은 제목줄에 표시
        supportActionBar?.title=title
        tv.text=message
        iv.setImageResource(img)

        //iv 가 전환효과의 대상이 되도록 별칭을 설정
        iv.transitionName="zzz"  //아답터에서 설정했던 별칭과 같은 별칭을 지정

      //up 버튼 보이기
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    //up 버튼 클릭시에 '백버튼' 누른 것처럼
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}