package com.rief

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rief.dataStore.PrefrenceDataStore
import com.rief.databinding.ActivityMainBinding
import com.rief.helper.Constant

class MainActivity : AppCompatActivity() {

    private lateinit var sharedpref : PrefrenceDataStore
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedpref = PrefrenceDataStore(this)

//        binding.apply {
//            button.set
//            editTextTextPersonName.
//        }

        if(sharedpref.getBoolean(Constant.PREFS_LOGIN) == true) {
            startActivity(Intent(this, SecondaryActivity::class.java))
            finish()
        }
    }
}