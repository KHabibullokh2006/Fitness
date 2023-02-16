package uz.itschool.fitness

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager.LayoutParams.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var logo:ImageView
    private lateinit var anim:Animation
    private var splashtime:Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)

        initUI()

        logo.startAnimation(anim)

        val handler = Handler()
        handler.postDelayed({
            Log.d("TAG", "onCreate: ")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        },splashtime)
    }

    @SuppressLint("ResourceType")
    fun initUI(){
        logo = findViewById(R.id.logo)
        anim = AnimationUtils.loadAnimation(this,R.anim.splash_anim)
    }
}


