package com.example.week3.ui.select.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.week3.R
import com.example.week3.model.login.LoginData
import com.example.week3.model.select.Data
import com.example.week3.model.select.Select
import com.example.week3.utils.onItemClickListener
import kotlinx.android.synthetic.main.item_select.view.*

class InterestAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var interest : Select = Select()
    private var data: MutableList<Data> = arrayListOf()
    private var itemChecked = false
    private var checkedPosition: MutableList<Int> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyInterestViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_select,
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MyInterestViewHolder -> {
                val myData = data[position]
                holder.bind(myData)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun itemCheck(checkbox: CheckBox){
        itemChecked = checkbox.isChecked
    }

    fun getItemChecked(): Boolean{
        return itemChecked
    }

    var itemClick: onItemClickListener?= null

    fun setItemClickListener(clickListener: onItemClickListener?) {
        itemClick = clickListener
    }

    inner class MyInterestViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val interestTitle: TextView = view.tv_item_interest_text
        private val interestCheckbox: CheckBox = view.interest_item_checkbox
        private val image: ImageView = view.item_of_interest

        fun bind(interestData: Data){
            interestTitle.text = interestData.title

            val imageUrl1 = interestData.photos?.url?.original
            val obj1 = RoundedCorners(8)
            val options1 = RequestOptions().transform(obj1)
            Glide.with(view.context.applicationContext ?: return)
                .load(imageUrl1)
                .apply(options1)
                .into(image)

            view.setOnClickListener{
                interestCheckbox.isChecked = !interestCheckbox.isChecked
                if (interestCheckbox.isChecked) {
                    checkedPosition.add(adapterPosition)
                } else {
                    for (i in 0 until checkedPosition.size){
                        if (checkedPosition[i] == adapterPosition) {
                            checkedPosition.removeAt(i)
                            break
                        }
                    }
                }
                itemCheck(interestCheckbox)
                itemClick?.onItemInterestClick(interestData)
            }

            if (interestCheckbox.isChecked && adapterPosition !in checkedPosition){
                interestCheckbox.isChecked = false
            }

            if (!interestCheckbox.isChecked && adapterPosition in checkedPosition){
                interestCheckbox.isChecked = true
            }
        }
    }

    fun setInterest(selectData: Select) {
        interest.apply { interest = selectData }

        data.apply {
            interest.selectData?.let { data.addAll(it) }
        }
        notifyDataSetChanged()
    }

}