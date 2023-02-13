package uz.itschool.fitness

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RegistrationActivity : AppCompatActivity() {

//    lateinit var reg
//    lateinit var name
//    lateinit var username
//    lateinit var phone
//    lateinit var email
//    lateinit var password
//    lateinit var rep_password
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        var userList:MutableList<User>
        val shared = getSharedPreferences("login", MODE_PRIVATE)
        val edit = shared.edit()
        val gson = Gson()
        val convert = object : TypeToken<List<User>>(){}.type

         var reg:Button = findViewById(R.id.signup_reg)
         var name:TextInputEditText = findViewById(R.id.name)
         var username:TextInputEditText = findViewById(R.id.username)
         var phone:TextInputEditText = findViewById(R.id.phone)
         var email:TextInputEditText = findViewById(R.id.mail)
         var password:TextInputEditText = findViewById(R.id.password)
         var rep_password:TextInputEditText = findViewById(R.id.rep_password)

        reg.setOnClickListener {
            validate()
            val users = shared.getString("users","")
            if (users==""){
                userList = mutableListOf()
            }else{
                userList=gson.fromJson(users,convert)
            }
            userList.add(User(name,username,phone,email,password))

            val str = gson.toJson(userList)
            edit.putString("users", str).apply()


            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun initUI(){

    }
    private fun validate(){
        if(){

        }
    }
}