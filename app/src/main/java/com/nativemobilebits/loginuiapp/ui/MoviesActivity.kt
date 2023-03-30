package com.nativemobilebits.loginuiapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.nativemobilebits.loginuiapp.R
import com.nativemobilebits.loginuiapp.entities.MoviesList
import com.nativemobilebits.loginuiapp.ui.adapter.MoviesAdapter
import com.nativemobilebits.loginuiapp.utilities.Utility

class MoviesActivity : AppCompatActivity() {

    lateinit var rvMovies :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        initViews()
        setupMoviesLayout()
    }

    private fun initViews() {
        rvMovies = findViewById(R.id.rvMovies)
    }


    private fun setupMoviesLayout() {

        val response = Utility.loadJSONFromAsset(this)
        val movieList = Gson().fromJson(response, MoviesList::class.java)


        rvMovies.apply {
            this.adapter = MoviesAdapter(movieList)
            this.layoutManager = LinearLayoutManager(this@MoviesActivity)
        }



    }

    companion object{
        private val TAG = MoviesActivity::class.java.simpleName
    }

}