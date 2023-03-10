package com.example.gceolmcq.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.R
import com.example.gceolmcq.datamodels.SubjectPackageData


class HomeRecyclerViewAdapter(
    private val context: Context,
    private var subjectPackageDataList: ArrayList<SubjectPackageData>,
    private val onHomeRecyclerItemClickListener: OnHomeRecyclerItemClickListener,
    private val onCheckPackageExpiryListener: OnCheckPackageExpiryListener

) : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvSubjectName: TextView = view.findViewById(R.id.tvSubjectNavItem)
        val tvSubjectStatus: TextView = view.findViewById(R.id.tvSubjectStatus)
        val btnSubjectPackageDetails: Button = view.findViewById(R.id.btnPackage)
        val btnSubscribe: Button = view.findViewById(R.id.btnSubscribe)

        private val layoutSubjectItem: LinearLayout = view.findViewById(R.id.layoutSubjectNavItem)
//

        init {

            layoutSubjectItem.setOnClickListener {
                if(subjectPackageDataList.isNotEmpty()){
                    onHomeRecyclerItemClickListener.onSubjectItemClicked(
                        this.adapterPosition,
                        subjectPackageDataList[adapterPosition].isPackageActive!!
                    )

                }

            }
            btnSubjectPackageDetails.setOnClickListener {
                onHomeRecyclerItemClickListener.onPackageDetailsButtonClicked(this.adapterPosition)
            }
            btnSubscribe.setOnClickListener {
                onHomeRecyclerItemClickListener.onSubscribeButtonClicked(this.adapterPosition)
            }

        }

    }

    fun upSubjectPackageData(subjectPackageDataList: ArrayList<SubjectPackageData>){
        this.subjectPackageDataList = subjectPackageDataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.subject_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(subjectPackageDataList.isNotEmpty()){
            holder.tvSubjectName.text = subjectPackageDataList[position].subjectName
            holder.btnSubjectPackageDetails.text = subjectPackageDataList[position].packageName

            if ((subjectPackageDataList[position].isPackageActive!!)){
                onCheckPackageExpiryListener.onCheckPackageExpiry(position)
                holder.tvSubjectStatus.text = context.resources.getString(R.string.active)
                holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.blue_color))
                holder.btnSubscribe.isEnabled = false

            } else{
                holder.tvSubjectStatus.text = context.resources.getString(R.string.expired)
                holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.red_color))
                holder.btnSubscribe.isEnabled = true
            }


            if(subjectPackageDataList[position].packageName == context.resources.getString(R.string.trial)){
                holder.btnSubscribe.isEnabled = true
            }
        }


    }

    override fun getItemCount(): Int {
        return subjectPackageDataList.size
    }

    interface OnHomeRecyclerItemClickListener {
        fun onSubjectItemClicked(position: Int, isPackageActive: Boolean)
        fun onSubscribeButtonClicked(position: Int)
        fun onPackageDetailsButtonClicked(position: Int)

    }
    interface OnCheckPackageExpiryListener{
        fun onCheckPackageExpiry(position: Int)
    }
}