package com.request.luis.requestapp.datacloud

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by kotlin on 27/03/2018.
 */
object DataAccess {

    fun getData(context: Context, url: String, receivedData: (List<User>) -> Unit) {
        val cola = Volley.newRequestQueue(context)

        val request: JsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    Log.i("DATA_ACCESS", response.toString())
                },
                Response.ErrorListener { error ->
                    Log.e("DATA_ACCESS", error.toString())
                })
        cola.add(request)
    }

    private fun convertToUsers(data:JSONArray):List<User> {
        var users = mutableListOf<User>()

        for (i in 0..data.length()-1) {
            val item = data.get(i) as JSONObject
            val user = User(item.getString("name"), item.getString("email"), item.getString("phone"))
            users.add(user)
        }
        return users
    }
}