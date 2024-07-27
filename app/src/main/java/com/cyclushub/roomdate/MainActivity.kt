package com.cyclushub.roomdate

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.cyclushub.roomdate.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var database: ContactDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insert(Contact(0, "vishal", "9873638535353", Date()))
        }

        binding.getData.setOnClickListener {

            database.contactDao().getContact().observe(this) {
//                binding.getData.text = it[0].id.toString()
                Log.d("database", "onCreate: $it")
            }
        }

    }


} 