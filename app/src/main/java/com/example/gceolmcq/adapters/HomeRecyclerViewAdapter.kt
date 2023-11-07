package com.example.gceolmcq.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.CustomCountDownTimer
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.R
import com.example.gceolmcq.datamodels.SubjectPackageData


class HomeRecyclerViewAdapter(
    private val context: Context,
    private var subjectPackageDataList: ArrayList<SubjectPackageData>,
    private val onHomeRecyclerItemClickListener: OnHomeRecyclerItemClickListener,
    private val onCheckPackageExpiryListener: OnCheckPackageExpiryListener,
    private val onActivateTrialButtonClickListener: OnActivateTrialButtonClickListener
//    private val onSubscribeButtonClickListener: OnSubscribeButtonClickListener

) : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvSubjectName: TextView = view.findViewById(R.id.subjectTitleTv)
        val tvSubjectStatus: TextView = view.findViewById(R.id.tvSubjectStatus)
        val btnSubscribe: Button = view.findViewById(R.id.btnSubscribe)
        val tvPackageType: TextView = view.findViewById(R.id.tvPackageType)
        val activatedOnTv: TextView = view.findViewById(R.id.activatedOnTv)
        val expiresOnTv: TextView = view.findViewById(R.id.expiresOnTv)
        val btnActivateTrial: Button = view.findViewById(R.id.activateButton)
        val activateButtonLo: LinearLayout = view.findViewById(R.id.activateButtonLo)

        private val layoutSubjectItem: CardView = view.findViewById(R.id.layoutSubjectNavItem)
//

        init {

            layoutSubjectItem.setOnClickListener {
                if(subjectPackageDataList.isNotEmpty()){
                    onHomeRecyclerItemClickListener.onSubjectItemClicked(
                        this.adapterPosition,
                        subjectPackageDataList[adapterPosition].isPackageActive,
                        subjectPackageDataList[adapterPosition].packageName
                    )

                }

            }
//            btnSubjectPackageDetails.setOnClickListener {
//                onHomeRecyclerItemClickListener.onPackageDetailsButtonClicked(this.adapterPosition)
//            }
            btnSubscribe.setOnClickListener {
                onHomeRecyclerItemClickListener.onSubscribeButtonClicked(adapterPosition, subjectPackageDataList[adapterPosition])
//                onSubscribeButtonClickListener.onSubscribeButtonClicked(adapterPosition)
            }

            btnActivateTrial.setOnClickListener {
                onActivateTrialButtonClickListener.onActivateTrialButtonClicked(adapterPosition, subjectPackageDataList[adapterPosition].subjectName!!)
            }

        }

    }

    fun upSubjectPackageData(subjectPackageDataList: ArrayList<SubjectPackageData>){
        this.subjectPackageDataList = subjectPackageDataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.subject_item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(subjectPackageDataList.isNotEmpty()){
            holder.tvSubjectName.text = subjectPackageDataList[position].subjectName
            holder.tvPackageType.text = subjectPackageDataList[position].packageName
            holder.activatedOnTv.text = subjectPackageDataList[position].activatedOn
            holder.expiresOnTv.text = subjectPackageDataList[position].expiresOn
            if(subjectPackageDataList[position].isPackageActive != null){
                holder.activateButtonLo.visibility = View.GONE
                if ((subjectPackageDataList[position].isPackageActive!!)){
                    onCheckPackageExpiryListener.onCheckPackageExpiry(position)
                    holder.tvSubjectStatus.text = context.resources.getString(R.string.active)
                    holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.color_green))
                    holder.btnSubscribe.isEnabled = false


                } else{
                    holder.tvSubjectStatus.text = context.resources.getString(R.string.expired)
                    holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.color_red))
                    holder.btnSubscribe.isEnabled = true
                }
            }else{
                holder.tvSubjectStatus.text = MCQConstants.NA
                holder.btnSubscribe.isEnabled = false
            }
//            if ((subjectPackageDataList[position].isPackageActive!!)){
//                onCheckPackageExpiryListener.onCheckPackageExpiry(position)
//                holder.tvSubjectStatus.text = context.resources.getString(R.string.active)
//                holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.color_green))
//                holder.btnSubscribe.isEnabled = false
//
//            } else{
//                holder.tvSubjectStatus.text = context.resources.getString(R.string.expired)
//                holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.color_red))
//                holder.btnSubscribe.isEnabled = true
//            }


            if(subjectPackageDataList[position].packageName == context.resources.getString(R.string.trial)){
                holder.btnSubscribe.isEnabled = true
            }
        }


    }

    override fun getItemCount(): Int {
        return subjectPackageDataList.size
    }

    interface OnHomeRecyclerItemClickListener {
        fun onSubjectItemClicked(position: Int, isPackageActive: Boolean?, packageName: String?)
        fun onSubscribeButtonClicked(position: Int, subjectPackageData: SubjectPackageData)

    }
    interface OnSubscribeButtonClickListener{
        fun onSubscribeButtonClicked(position: Int)
    }
    interface OnCheckPackageExpiryListener{
        fun onCheckPackageExpiry(position: Int)
    }
    interface OnActivateTrialButtonClickListener{
        fun onActivateTrialButtonClicked(position: Int, subjectName: String)
    }
}