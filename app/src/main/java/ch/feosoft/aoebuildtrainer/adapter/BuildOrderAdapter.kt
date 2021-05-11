package ch.feosoft.aoebuildtrainer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.feosoft.aoebuildtrainer.R
import ch.feosoft.aoebuildtrainer.model.BuildOrder

class BuildOrderAdapter(private val dataSet: List<BuildOrder>) : RecyclerView.Adapter<BuildOrderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.build_order_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].name
        holder.imgView.setImageResource(dataSet[position].iconResourceId)
        holder.subtitleView.text = dataSet[position].subtitle
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.list_item_title_view)
        val imgView: ImageView = view.findViewById(R.id.list_item_icon)
        val subtitleView: TextView = view.findViewById(R.id.list_item_description_view)
    }
}