package uz.itschool.fitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    var singIn:Button = findViewById(R.id.singin)
    var username:EditText = findViewById(R.id.username)
    var password:EditText = findViewById(R.id.password)
    var forgot:Button = findViewById(R.id.forgotpassword)

    var users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



    }


}