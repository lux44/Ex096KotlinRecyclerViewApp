package com.lux.ex096kotlinrecyclerviewapp

//주생성자의 파라미터에 var 키워드를 넣으면, 멤버변수가 됨.
data class Item constructor(var title:String,var msg:String,var img:Int)
//클래스 내용이 없으면 {} 도 생략가능함.