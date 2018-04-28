package com.uabc.edu.listas.adaptador

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.widget.TextView
import com.uabc.edu.listas.R
import kotlinx.android.synthetic.main.row_list.view.*

class Adaptador constructor(private val context: Context,
                            private val inflater: LayoutInflater) :BaseAdapter(){

    var datos=Array<String>(1,{"http://google.com"})

    override fun getView(position: Int, convertedView: View?, parent: ViewGroup?): View {

        val view:View?
        val urlHolder:URLHolder
        if(convertedView==null){
            //Se carga el layout del Renglon
            view=inflater.inflate(R.layout.row_list,parent,false)
            //Se crear el Holder para el renglon y ahorrar memoria
             urlHolder=URLHolder(view)
            //Se agrega el holder para evitarrecrearlo
            view?.tag=urlHolder

        }else{

            view=convertedView
            urlHolder=view.tag as URLHolder
        }


        return view!!;

    }

    override fun getItem(p0: Int): Any {
        return datos.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return datos.size
    }


    private class URLHolder(row:View?){

        val url:TextView

        init {
            this.url= row!!.findViewById(R.id.direccion) as TextView
        }

    }


}