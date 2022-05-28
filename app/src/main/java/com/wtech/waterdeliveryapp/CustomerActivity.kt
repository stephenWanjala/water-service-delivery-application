package com.wtech.waterdeliveryapp

import android.os.Bundle
import com.wtech.waterdeliveryapp.databinding.ActivityCustomerBinding

class CustomerActivity : DrawerActivity() {
    private lateinit var customerBinding: ActivityCustomerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        customerBinding = ActivityCustomerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(customerBinding.root)
        getActivityTittle("Customers")
    }
}