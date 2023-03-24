package com.example.sharepreferenceandalertdialog

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.SpannableStringBuilder
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.edit
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var btnLogin: Button
    private lateinit var saveEmail: TextView
    private lateinit var savePass: TextView
    private lateinit var imgDel: ImageView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var relativeView: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        displayOutput()
        eventView()
    }

    private fun initView() {
        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        checkBox = findViewById(R.id.checkbox)
        btnLogin = findViewById(R.id.submit)
        saveEmail = findViewById(R.id.saveEmail)
        savePass = findViewById(R.id.savePass)
        imgDel = findViewById(R.id.img)
        sharedPreferences = getSharedPreferences("App_cahe", MODE_PRIVATE)
        relativeView = findViewById(R.id.relativeView)
    }

    private fun eventView() {
        btnLogin.setOnClickListener { it ->

            var textEmail = email.text.toString()
            var textPass = pass.text.toString()


            if (textEmail.isEmpty() || textPass.isEmpty()) {
                Toast.makeText(this@MainActivity, "Ban chua nhap day du", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (textEmail == "anduy123" && textPass == "123") {
                Toast.makeText(this@MainActivity, "dang nhap thanh cong", Toast.LENGTH_SHORT).show()
                if (checkBox.isChecked) {
                    Toast.makeText(this@MainActivity, "Luu thanh cong", Toast.LENGTH_SHORT).show()
                    saveAccount(checkBox.isChecked,textEmail,textPass)


                }
            } else {
                Toast.makeText(this@MainActivity, "Ban nhap sai thong tin", Toast.LENGTH_SHORT)
                    .show()
            }


        }
    }

    private fun saveAccount(isSaved: Boolean, email: String, password: String) {
        if (isSaved){
            sharedPreferences.edit{
                putString("email",email)
                putString("password",password)
                putBoolean("checked",true)
                apply()
            }
        }
    }
    private fun displayOutput(){
        sharedPreferences.apply {
            val email = getString("email","")
            val password = getString("password","")
            val isSaved = getBoolean("checked",false)

            if (isSaved){
                val spanned =  SpannableStringBuilder().apply {
                    append("Email: $email")
                    append("\n")
                    append("Password: $password")
                }




            }

        }

    }
}
