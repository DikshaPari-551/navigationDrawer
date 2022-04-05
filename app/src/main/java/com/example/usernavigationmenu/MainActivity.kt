package com.example.usernavigationmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.system.Os.open
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.usernavigationmenu.R.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(id.drawerLayout)
        val navView: NavigationView = findViewById(id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            drawerLayout.closeDrawer(GravityCompat.START)
            when (it.itemId) {
                R.id.nav_home ->  supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, BlankFragment1())
                        .commit()

                R.id.nav_message->  supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment,Message())
                    .commit()

                R.id.nav_setting->  supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment,SettingFragment())
                    .commit()

//                    Toast.makeText(
//                    applicationContext,
//                    "Clicked Home",
//                    Toast.LENGTH_SHORT
//                ).show()
//                R.id.nav_message -> Toast.makeText(
//                    applicationContext,
//                    "Clicked message",
//                    Toast.LENGTH_SHORT
//                ).show()
//                R.id.nav_setting -> Toast.makeText(
//                    applicationContext,
//                    "Clicked setting",
//                    Toast.LENGTH_SHORT
//                ).show()
//                R.id.nav_share -> Toast.makeText(
//                    applicationContext,
//                    "Clicked share",
//                    Toast.LENGTH_SHORT
//                ).show()

            }
            true

        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}