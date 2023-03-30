package com.nativemobilebits.loginuiapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nativemobilebits.loginuiapp.R

class MainActivity : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var tvValues: TextView

    lateinit var result :String

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        Log.d(TAG,"Inside onCreate")

        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvValues = findViewById(R.id.tvValues)

        checkForSavedValueInBundle(savedInstanceState)
        setupClickListeners()

    }

    private fun checkForSavedValueInBundle(savedInstanceState: Bundle?) {
        savedInstanceState?.also {
            result =  it.getString("result")?:""
            if(result.isNullOrEmpty()){
                tvValues.visibility = View.GONE
            }else{
                tvValues.apply {
                    this.visibility = View.VISIBLE
                    text = result
                }
            }
        }
    }

    private fun setupClickListeners() {
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()


            Log.d(TAG,"Inside_setupClickListeners email = $email")
            Log.d(TAG,"Inside_setupClickListeners password = $password")


            result = "${getString(R.string.values_entered_by_user)} \n Email= $email\n Password= $password"

            tvValues.apply {
                this.visibility = View.VISIBLE
                this.text = result
            }
        }
    }

    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"Inside onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"Inside onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"Inside onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"Inside onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"Inside onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Inside onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"Inside onSaveInstanceState")
        if(result.isNullOrEmpty()) return
        outState.putString("result",result)
    }

}