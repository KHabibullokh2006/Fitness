package uz.itschool.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signIn:Button = findViewById(R.id.signin)
        val signUp:Button = findViewById(R.id.signup)
        val username:TextInputEditText = findViewById(R.id.username)
        val password:TextInputEditText = findViewById(R.id.password)
        var forgot:Button = findViewById(R.id.forgotpassword)

        var userList = mutableListOf<User>()
        val shared = getSharedPreferences("login", MODE_PRIVATE)
        val gson = Gson()
        val convert = object : TypeToken<List<User>>(){}.type
        val users = shared.getString("users","")



        signUp.setOnClickListener {
            var intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }

        signIn.setOnClickListener {
            if (users==""){
                userList = gson.fromJson(users, convert)
                Toast.makeText(this,"R", Toast.LENGTH_SHORT).show()
            }
            else {
                Log.d("AAA", "onCreate: ")
                userList = gson.fromJson(users, convert)
                for (user in userList) {
                    if (username.toString().equals(user.username) && password.toString().equals(user.password)){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}