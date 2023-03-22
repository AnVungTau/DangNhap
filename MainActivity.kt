package com.example.sharepreferenceandalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        submit = findViewById(R.id.submit)

        submit.setOnClickListener(object : OnClickListener{
            override fun onClick(v: View?) {
                var textEmail = email.text.toString()
                var textPass = pass.text.toString()


                if (textEmail.isNullOrEmpty() || textPass.isNullOrEmpty()) {
                    Toast.makeText(this@MainActivity, "Ban chua nhap day du", Toast.LENGTH_SHORT)
                        .show()
                    return
                }

                if (textEmail == "anduy123" && textPass == "123"){
                    Toast.makeText(this@MainActivity,"dang nhap thanh cong", Toast.LENGTH_SHORT).show()
                    return
                }


            }
        })
    }

}
