package com.example.lab5
import android.content.Context
import com.example.lab5.Post
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object JsonReader {

    fun readPosts(context: Context): List<Post> {
        val json: String = try {
            val inputStream: InputStream = context.assets.open("post.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            return emptyList()
        }

        val listType = object : TypeToken<List<Post>>() {}.type
        return Gson().fromJson(json, listType)
    }


}