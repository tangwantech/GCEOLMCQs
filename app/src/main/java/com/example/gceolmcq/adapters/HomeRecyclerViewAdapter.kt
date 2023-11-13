package com.example.gceolmcq.adapters

import android.content.Context
import android.text.format.Time
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.CustomCountDownTimer
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.R
import com.example.gceolmcq.datamodels.SubjectPackageData


class HomeRecyclerViewAdapter(
    private val context: Context,
    private var subjectPackageDataList: ArrayList<SubjectPackageData>,
    private val onHomeRecyclerItemClickListener: OnHomeRecyclerItemClickListener,
    private val onActivateTrialButtonClickListener: OnActivateTrialButtonClickListener,

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
        val expiresInTv: TextView = view.findViewById(R.id.expiresInTv)
        val expireInLo: LinearLayout = view.findViewById(R.id.expireInLo)

        private val layoutSubjectItem: CardView = view.findViewById(R.id.layoutSubjectNavItem)
//

        init {

            layoutSubjectItem.setOnClickListener {
                if(subjectPackageDataList.isNotEmpty()){
                    val packageStatus = ActivationExpiryDatesGenerator().apply{}.checkExpiry(
                        subjectPackageDataList[adapterPosition].activatedOn!!,
                        subjectPackageDataList[adapterPosition].expiresOn!!
                    )
                    onHomeRecyclerItemClickListener.onSubjectItemClicked(
                        this.adapterPosition,
                        packageStatus,
                        subjectPackageDataList[adapterPosition].packageName
                    )

                }

            }

            btnSubscribe.setOnClickListener {
                onHomeRecyclerItemClickListener.onSubscribeButtonClicked(adapterPosition, subjectPackageDataList[adapterPosition])
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
        val tempPosition = position
        if(subjectPackageDataList.isNotEmpty()){
            holder.tvSubjectName.text = subjectPackageDataList[position].subjectName
            holder.tvPackageType.text = subjectPackageDataList[position].packageName
            holder.activatedOnTv.text = subjectPackageDataList[position].activatedOn
            holder.expiresOnTv.text = subjectPackageDataList[position].expiresOn

            if(subjectPackageDataList[position].isPackageActive != null){
                holder.activateButtonLo.visibility = View.GONE
                holder.expireInLo.visibility = View.VISIBLE
                if (subjectPackageDataList[position].isPackageActive!!){
                    holder.tvSubjectStatus.text = context.resources.getString(R.string.active)
                    holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.color_green))
                    holder.btnSubscribe.isEnabled = false
                    val timeLeft = ActivationExpiryDatesGenerator.getTimeRemaining(
                        subjectPackageDataList[position].activatedOn!!,
                        subjectPackageDataList[position].expiresOn!!
                    )

                    CustomCountDownTimer(tempPosition).apply {
                        startTimer(timeLeft, object : CustomCountDownTimer.OnTimeRemainingListener{
                            override fun onTimeRemaining(expiresIn: String) {
                                holder.expiresInTv.text = expiresIn
                            }
                            override fun onExpired() {
                                holder.expireInLo.visibility = View.GONE
                                holder.tvSubjectStatus.text = context.resources.getString(R.string.expired)
                                holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.color_red))
                                holder.btnSubscribe.isEnabled = true
                            }
                        })
                    }


                } else{
                    holder.expireInLo.visibility = View.GONE
                    holder.tvSubjectStatus.text = context.resources.getString(R.string.expired)
                    holder.tvSubjectStatus.setTextColor(context.resources.getColor(R.color.color_red))
                    holder.btnSubscribe.isEnabled = true
                }
            }else{
                holder.tvSubjectStatus.text = MCQConstants.NA
                holder.btnSubscribe.isEnabled = false
            }
            if(subjectPackageDataList[position].packageName == context.resources.getString(R.string.trial)){
                holder.btnSubscribe.isEnabled = !subjectPackageDataList[position].isPackageActive!!

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

    interface OnActivateTrialButtonClickListener{
        fun onActivateTrialButtonClicked(position: Int, subjectName: String)
    }
}