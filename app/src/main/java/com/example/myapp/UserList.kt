package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class UserList : AppCompatActivity() {
    private lateinit var dbref :DatabaseReference
     private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        userRecyclerView=findViewById(R.id.recyclerview)
        userRecyclerView.layoutManager=LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList= arrayListOf<User>()
        getUserData()


    }

    private fun getUserData() {
        dbref=FirebaseDatabase.getInstance().getReference("Users")
        dbref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val user=userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)
                    }//end
                    userRecyclerView.adapter=UserAdapter(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }




}