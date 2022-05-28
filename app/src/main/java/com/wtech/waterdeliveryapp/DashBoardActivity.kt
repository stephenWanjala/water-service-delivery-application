package com.wtech.waterdeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wtech.waterdeliveryapp.databinding.ActivityDashBoardBinding

class DashBoardActivity : DrawerActivity() {
    private lateinit var dashBoardBinding: ActivityDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashBoardBinding=ActivityDashBoardBinding.inflate(
            layoutInflater
        )
        setContentView(dashBoardBinding.root)
        getActivityTittle("DashBoard")
    }
}