package com.example.gceolmcq.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.R
//import com.example.gceolmcq.fragments.OnSectionAnsweredListener

class SectionNavigationRecyclerViewAdapter(
    private val context: Context,
    private val listSections: Array<String>,
    private val listener: OnRecyclerItemClickListener,
    private val sectionsAnswered: List<Boolean>
) :
    RecyclerView.Adapter<SectionNavigationRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvSectionNavItem: TextView = view.findViewById(R.id.tvSectionNavItem)
        val sectionNavItemLayout: LinearLayout = view.findViewById(R.id.sectionNavItemLayout)
        val imgSectionAnsweredCheck: ImageView = view.findViewById(R.id.imgSectionAnsweredCheck)

        init{
            sectionNavItemLayout.setOnClickListener{
                listener.onRecyclerItemClick(this.adapterPosition)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.section_nav_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.sectionNavItemLayout.setOnClickListener{
//            listener.onRecyclerItemClick(position)
//        }
        holder.tvSectionNavItem.text = listSections[position]

        if(sectionsAnswered[position]){
            holder.tvSectionNavItem.setTextColor(context.resources.getColor(R.color.color_primary_dark))
            holder.imgSectionAnsweredCheck.visibility = View.VISIBLE
//            holder.sectionNavItemLayout.isEnabled = false

        }else{
            holder.imgSectionAnsweredCheck.visibility = View.GONE
        }


    }

    override fun getItemCount(): Int {
        return listSections.size
    }

    interface OnRecyclerItemClickListener{
        fun onRecyclerItemClick(position: Int)
    }
}