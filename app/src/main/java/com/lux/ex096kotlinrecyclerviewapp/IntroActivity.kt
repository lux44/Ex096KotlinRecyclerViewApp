package com.lux.ex096kotlinrecyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class IntroActivity : AppCompatActivity() {

    //코틀린은 반드시 멤버변수는 초기화 해야 함
    var btn:Button?=null    //nullable 변수
    //late init 늦은 초기화 문법
    lateinit var btn2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        btn=findViewById(R.id.btn)
        //익명 클래스로 클릭 처리 - nullable 변수를 사용할 때는 반드시 null safe 연산자 사용
        btn?.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                //MainActivity 실행
                //Intent intent=new Intent(IntroActivity.this,MainActivity.class);
                val intent:Intent=Intent(this@IntroActivity,MainActivity::class.java)
                startActivity(intent)
            }

        })

        btn2=findViewById(R.id.btn2)
        //익명클래스보다 표기법이 간소한 SAM conversion - 람다식과 유사한 방식 [별도 수업]
        btn2.setOnClickListener {
            finish()
        }
    }
}