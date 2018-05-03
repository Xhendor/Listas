package com.uabc.edu.listas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.uabc.edu.listas.adaptador.Adaptador
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),AdapterView.OnItemClickListener {

    var datos= arrayListOf<String>("http://google.com","http://uabc.mx","http://boveda.appsw.mx")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         var adaptador=Adaptador(applicationContext,this.layoutInflater,datos);
        mylista.adapter=adaptador;
        mylista.onItemClickListener=this
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        var intent=Intent(applicationContext,BrowserActivity::class.java)
        intent.putExtra("url",datos.get(p2))
        startActivity(intent)

    }
}



