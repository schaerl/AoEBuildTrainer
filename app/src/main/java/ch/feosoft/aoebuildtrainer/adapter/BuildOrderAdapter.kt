package ch.feosoft.aoebuildtrainer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.feosoft.aoebuildtrainer.R
import ch.feosoft.aoebuildtrainer.service.BuildOrderService

class BuildOrderAdapter : RecyclerView.Adapter<BuildOrderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_build_order, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Replace call to buildOrderService with a reference to the list, or similar. So we don't have to
        //  constantly reload like we do now
        holder.textView.text = BuildOrderService.getAllBuildOrders()[position].name
        holder.imgView.setImageResource(BuildOrderService.getAllBuildOrders()[position].iconResourceId)
        holder.subtitleView.text = BuildOrderService.getAllBuildOrders()[position].subtitle
    }

    override fun getItemCount(): Int {
        return BuildOrderService.getAllBuildOrders().size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.list_item_title_view)
        val imgView: ImageView = view.findViewById(R.id.list_item_icon)
        val subtitleView: TextView = view.findViewById(R.id.list_item_description_view)
    }
}