package uz.itschool.fitness

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    lateinit var logo:ImageView
    lateinit var anim:Animation
    private var splashtime:Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)

        initUI()

        logo.startAnimation(anim)

        var handler = Handler()
        handler.postDelayed({
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()

        },splashtime)
    }

    @SuppressLint("ResourceType")
    fun initUI(){
        logo = findViewById(R.id.logo)
        anim = AnimationUtils.loadAnimation(this,R.anim.splash_anim)
    }
}


