package com.example.berry.heckajitpai

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.filing_item.view.*

/**
 * Created by per6 on 1/31/18.
 */
class FilingsAdapter(context: Context, var filings: List<Filing>, var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<FilingsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.filing_item, parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = filings.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) = holder!!.bind(filings[position], onItemClickListener)

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(filing: Filing, listener: OnItemClickListener) = with(itemView){
            if(filing.filers[0].name == null){
                filer_name.text = "<No Name>"
            }
            else{
                filer_name.text = filing.filers[0].name
            }
//            filing_text.text = filing.text_data.substring(0,30) + "..."
            filing_text.text = filing.text_data
            date_received.text = filing.date_received.substring(0,10)
            date_posted.text = filing.date_disseminated.substring(0,10)
            itemView.setOnClickListener(object: View.OnClickListener {
                override fun onClick(p0: View?) {
                    listener.onItemClick(filing)
                }
            })
        }
    }

}