package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapp.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener{
            val name=binding.name.text.toString().trim()
            val sport=binding.sport.text.toString().trim()

            database= FirebaseDatabase.getInstance().getReference("Users")
            val User=User(name,sport)
            database.child(name).setValue(User).addOnSuccessListener{
                binding.name.text?.clear()
                binding.sport.text?.clear()
                Toast.makeText(this,"successful saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"try again", Toast.LENGTH_SHORT).show()
            }

        }

    }
}