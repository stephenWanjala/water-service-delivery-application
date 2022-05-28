package com.wtech.waterdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

open class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout:DrawerLayout
    override fun setContentView(view: View?) {
        drawerLayout= layoutInflater.inflate(
            R.layout.activity_drawer,
            null
        ) as DrawerLayout
        val containerFrameLayout:FrameLayout=drawerLayout.findViewById(R.id.container)
        containerFrameLayout.addView(view)
        super.setContentView(drawerLayout)
        val toolbar: Toolbar =drawerLayout.findViewById(R.id.contentToolbar)
        setSupportActionBar(toolbar)
        val navigationView:NavigationView=drawerLayout.findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)
        val toggle:ActionBarDrawerToggle= ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.menu_drawerOpen,
            R.string.menu_drawerClose
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        when(item.itemId){
            R.id.nav_customers->{
                startActivity(Intent(this@DrawerActivity,CustomerActivity::class.java))
                overridePendingTransition(0 ,0)
            }
            R.id.nav_orders->{
                startActivity(Intent(this@DrawerActivity,OrdersActivity::class.java))
                overridePendingTransition(0 ,0)
            }
        }
        return false
    }
    fun getActivityTittle(tittleString: String){
       if (supportActionBar!=null){
           supportActionBar!!.title=tittleString
       }
    }

}