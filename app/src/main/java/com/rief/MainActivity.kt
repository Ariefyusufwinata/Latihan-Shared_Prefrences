package com.rief

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rief.dataStore.PrefrenceDataStore
import com.rief.databinding.ActivityMainBinding
import com.rief.helper.Constant

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedpref : PrefrenceDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedpref = PrefrenceDataStore(this@MainActivity)

        binding.apply {
            btnLogin.setOnClickListener {
                if(edtUsername.text.isNotEmpty() && edtPassword.text.isNotEmpty()) {
                    sharedpref.put(Constant.PREFS_LOGIN, true)
                    sharedpref.put(Constant.PREFS_USERNAME, edtUsername.text.toString())
                    sharedpref.put(Constant.PREFS_PASSWORD, edtPassword.text.toString())

                    Toast.makeText(this@MainActivity, "Session Is True", Toast.LENGTH_LONG).show()

                    startActivity(Intent(this@MainActivity, SecondaryActivity::class.java))
                    finish()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(sharedpref.getBoolean(Constant.PREFS_LOGIN)) {
            startActivity(Intent(this, SecondaryActivity::class.java))
            finish()
        }
    }
}