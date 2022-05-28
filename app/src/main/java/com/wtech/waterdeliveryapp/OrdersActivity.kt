package com.wtech.waterdeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wtech.waterdeliveryapp.databinding.ActivityOrdersBinding

class OrdersActivity : DrawerActivity() {
    private lateinit var  ordersBinding: ActivityOrdersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       ordersBinding=ActivityOrdersBinding.inflate(layoutInflater)

        setContentView(ordersBinding.root)
        getActivityTittle("Orders")
    }
}