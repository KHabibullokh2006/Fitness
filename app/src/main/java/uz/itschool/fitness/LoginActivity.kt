package uz.itschool.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    var signIn:Button = findViewById(R.id.signin)
    var signUp:Button = findViewById(R.id.signup)
    var username:EditText = findViewById(R.id.username)
    var password:EditText = findViewById(R.id.password)
    var forgot:Button = findViewById(R.id.forgotpassword)

    var users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signUp.setOnClickListener {
            var intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }

        signIn.setOnClickListener {
            for (user in users) {
                if (username.toString() == user.username && password.toString() == user.password){
                    var intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }

}