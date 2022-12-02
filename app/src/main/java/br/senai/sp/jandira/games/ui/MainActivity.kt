package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.User
import jandira.sp.senai.br.games.repository.UserRepository


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var user = User()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.createAccount.setOnClickListener {

            var openSignupActivity = Intent( this, ActivitySignUp::class.java)

            startActivity(openSignupActivity)

        }

        binding.idButtonLogin.setOnClickListener {

            login()

        }

    }



    private fun login() {
//
        val email = binding.idInputEmail.text.toString()
        val pass = binding.idInputPassword.text.toString()

        val userLogin = UserRepository(this)

        val login = userLogin.login(email, pass)

        if (login != null) {

            val openGames = Intent(this, ActivityGames::class.java)
            startActivity(openGames)

        }else {
            Toast.makeText(this, "login incorreto", Toast.LENGTH_SHORT).show()
        }
    }
}