package com.molang.testwaiter

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_table_number.*
import com.molang.testwaiter.order.OrderActivity
import com.molang.testwaiter.order.TABLE_NUMBER

class TableNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_number)

        setStartingOrderAction()
    }

    private fun setStartingOrderAction() {
        tv_start_order.setOnClickListener {
            if(et_table_number.text.toString().isEmpty()) {
                val builder = AlertDialog.Builder(this)
                    .apply {
                        setPositiveButton(
                            "확인",
                            DialogInterface.OnClickListener { dialog, id ->
                            }
                        )
                        setTitle("경고")
                        setMessage("테이블 번호를 입력해주세요")
                        create()
                        show()
                    }
            } else {
                startOrderActivity(
                    et_table_number
                        .text
                        .toString()
                        .toInt()
                )
                et_table_number.text.clear()
            }
        }
    }

    private fun startOrderActivity(tableNumber: Int) {
        // You can declare your desire activity here to open after finishing splash screen. Like MainActivity
        val intent = Intent(this, OrderActivity::class.java)
            .apply {
                putExtra(TABLE_NUMBER, tableNumber)
            }
        startActivity(intent)
    }
}