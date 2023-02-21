package com.example.gceolmcq.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.R
import com.example.gceolmcq.datamodels.SubjectPackageExpiryStatusData
import com.example.gceolmcq.fragments.HomeFragment


class HomeRecyclerViewAdapter(
    private val context: Context,
//    private val subjectPackageExpiryStatusList: List<SubjectPackageExpiryStatusData>,
    private val onHomeRecyclerItemClickListener: OnHomeRecyclerItemClickListener

) : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {
    private var subjectPackageExpiryStatusList: ArrayList<SubjectPackageExpiryStatusData> = ArrayList()


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvSubjectName = view.findViewById(R.id.tvSubjectNavItem) as TextView
        val tvSubjectStatus = view.findViewById(R.id.tvSubjectStatus) as TextView
        val btnSubjectPackageDetails = view.findViewById(R.id.btnPackage) as Button
        val btnSubscribe = view.findViewById(R.id.btnSubscribe) as Button

        private val layoutSubjectItem = view.findViewById(R.id.layoutSubjectNavItem) as LinearLayout
//

        init {

            layoutSubjectItem.setOnClickListener {
                onHomeRecyclerItemClickListener.onSubjectItemClicked(
                    this.adapterPosition,
                    subjectPackageExpiryStatusList[this.adapterPosition].status
                )
            }
            btnSubjectPackageDetails.setOnClickListener {
                onHomeRecyclerItemClickListener.onPackageDetailsButtonClicked(this.adapterPosition)
            }
            btnSubscribe.setOnClickListener {
                onHomeRecyclerItemClickListener.onSubscribeButtonClicked(this.adapterPosition)
            }


        }

    }

    fun setSubjectPackageExpiryStatusList(subjectPackageExpiryStatusList: ArrayList<SubjectPackageExpiryStatusData>){
        this.subjectPackageExpiryStatusList = subjectPackageExpiryStatusList
    }

    fun updateSubjectPackageExpiryStatusListAt(position: Int, subjectPackageExpiryStatus: SubjectPackageExpiryStatusData){

        this.subjectPackageExpiryStatusList[position] = subjectPackageExpiryStatus
    }

    fun updateExpiryStatusAt(position: Int, status: Boolean){
        this.subjectPackageExpiryStatusList[position].status = status
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.subject_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvSubjectName.text = subjectPackageExpiryStatusList[position].subject
        holder.btnSubjectPackageDetails.text = subjectPackageExpiryStatusList[position].packageName

        if (subjectPackageExpiryStatusList[position].status){
            holder.tvSubjectStatus.text = context.resources.getString(
                R.string.active
            )
            holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.correct_answer))
            holder.btnSubscribe.isEnabled = false

        } else{
            holder.tvSubjectStatus.text = context.resources.getString(
                R.string.expired
            )
            holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.wrong_answer))
            holder.btnSubscribe.isEnabled = true
        }

        if(subjectPackageExpiryStatusList[position].packageName == context.resources.getString(R.string.trial)){
            holder.btnSubscribe.isEnabled = true
        }

    }

    override fun getItemCount(): Int {
//        println(subjectPackageExpiryStatusList.size)
        return subjectPackageExpiryStatusList.size
    }

    interface OnHomeRecyclerItemClickListener {
        fun onSubjectItemClicked(position: Int, isPackageActive: Boolean)
        fun onSubscribeButtonClicked(position: Int)
        fun onPackageDetailsButtonClicked(position: Int)

    }
}