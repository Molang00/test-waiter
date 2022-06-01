package com.molang.testwaiter.order

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.molang.testwaiter.R
import kotlinx.android.synthetic.main.activity_order.*
import java.util.*

val TABLE_NUMBER = "table_number"

class OrderActivity: AppCompatActivity() {
    var tableNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        tableNumber = intent.getIntExtra(TABLE_NUMBER, tableNumber)

        initUI()
    }

    private fun initUI() {
        setInitValues()
        setOrderListRecyclerView()
        setOrderAction()
    }

    private fun setInitValues() {
        tv_table_number.text = tableNumber.toString()
    }

    val orderItemList = ArrayList<OrderItem>()
    val initialOrderItem = ArrayList<OrderItem>()

    lateinit var orderListAdapter: OrderListAdapter
    private fun setOrderListRecyclerView() {
        initialOrderItem.add(
            OrderItem(
                menu = "닭칼국수"
            )
        )
        initialOrderItem.add(
            OrderItem(
                menu = "비빔국수"
            )
        )
        initialOrderItem.add(
            OrderItem(
                menu = "콩국수"
            )
        )
        initialOrderItem.add(
            OrderItem(
                menu = "만두"
            )
        )

        orderItemList.clear()
        orderItemList.addAll(initialOrderItem)

        orderListAdapter = OrderListAdapter(
            act = this,
            orderList = orderItemList
        )

        rv_order_list.adapter = orderListAdapter
    }

    private fun setOrderAction() {
        tv_order.setOnClickListener {

            finish()
        }
    }
}