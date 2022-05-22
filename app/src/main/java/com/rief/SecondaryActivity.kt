package com.rief

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rief.dataStore.PrefrenceDataStore
import com.rief.databinding.ActivitySecondaryBinding
import com.rief.helper.Constant

class SecondaryActivity : AppCompatActivity() {

    private lateinit var sharedPrefs : PrefrenceDataStore
    private lateinit var binding : ActivitySecondaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = PrefrenceDataStore(this@SecondaryActivity)

        binding.apply {
            tvName.text = sharedPrefs.getString(Constant.PREFS_USERNAME)

            btnLogout.setOnClickListener {
                sharedPrefs.clear()

                Toast.makeText(this@SecondaryActivity, "Logout", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this@SecondaryActivity, MainActivity::class.java))
                finish()
            }
        }
    }
}