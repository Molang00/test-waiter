package com.molang.testwaiter.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.molang.testwaiter.R

class OrderListAdapter(
    val act: OrderActivity,
    val orderList: List<OrderItem>
): RecyclerView.Adapter<OrderListAdapter.ViewHolder>() {

    inner class ViewHolder(
        view: View
    ): RecyclerView.ViewHolder(view) {
        lateinit var orderItem: OrderItem

        private val clPlus: ConstraintLayout = view.findViewById(R.id.cl_plus)
        private val tvMenuName: TextView = view.findViewById(R.id.tv_menu_name)
        private val tvCount: TextView = view.findViewById(R.id.tv_count)
        private val tvMinus: TextView = view.findViewById(R.id.tv_minus)

        fun onBind(_data: OrderItem) {
            orderItem = _data

            tvMenuName.text = orderItem.menu
            tvCount.text = orderItem.count.toString()

            clPlus.setOnClickListener {
                orderItem.count++
                tvCount.text = orderItem.count.toString()
            }
            tvMinus.setOnClickListener {
                if(orderItem.count < 1) return@setOnClickListener
                orderItem.count--
                tvCount.text = orderItem.count.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.order_item,
                parent,
                false
            )

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = orderList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(orderList[position])
    }
}