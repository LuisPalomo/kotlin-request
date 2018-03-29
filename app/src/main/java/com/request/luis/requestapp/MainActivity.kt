package com.request.luis.requestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.request.luis.requestapp.datacloud.DataAccess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataAccess.getData(this, "https://jsonplaceholder.typicode.com/users") { userList ->
            for (user in userList) {
                Log.i("USER_INFO", user.name)
            }
        }
    }
}
