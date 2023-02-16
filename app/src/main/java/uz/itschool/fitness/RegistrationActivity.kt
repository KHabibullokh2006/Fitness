package uz.itschool.fitness

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RegistrationActivity : AppCompatActivity() {

    lateinit var reg:Button
    lateinit var name:TextInputEditText
    lateinit var username:TextInputEditText
    lateinit var phone:TextInputEditText
    lateinit var email:TextInputEditText
    lateinit var password:TextInputEditText
    lateinit var rep_password:TextInputEditText

    private lateinit var userList:MutableList<User>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val shared:SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val edit = shared.edit()
        val gson = Gson()
        val convert = object : TypeToken<List<User>>(){}.type

         initUI()

        reg.setOnClickListener {
            validate()
            val users = shared.getString("users","")
            if (users==""){
                userList = mutableListOf()
            }
            else{
                userList=gson.fromJson(users,convert)
            }

            userList.add(User(name,username,phone,email,password))

            val str = gson.toJson(userList)
            edit.putString("users", str).apply()


            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initUI(){
        reg = findViewById(R.id.signup_reg)
        name = findViewById(R.id.name)
        username = findViewById(R.id.username)
        phone = findViewById(R.id.phone)
        email = findViewById(R.id.mail)
        password = findViewById(R.id.password)
        rep_password = findViewById(R.id.rep_password)
    }
    private fun validate(){
        if(name.equals("")|| username.equals("") || phone.equals("") || email.equals("") || password.equals("") || rep_password.equals("")){
            Toast.makeText(this,"Fill the form fully", Toast.LENGTH_SHORT).show()
        }
        for (i in userList.indices){
            if (username.toString().equals(userList[i].username)){
                Toast.makeText(this,"User with this username already registered", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
