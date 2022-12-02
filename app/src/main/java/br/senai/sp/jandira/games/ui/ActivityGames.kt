package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.dao.UserDao
import br.senai.sp.jandira.games.databinding.ActivityGamesBinding
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.User

class ActivityGames : AppCompatActivity() {
    lateinit var binding: ActivityGamesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        binding = ActivityGamesBinding.inflate(layoutInflater)


        setContentView(binding.root)



        binding.idUserName.text = User().nome
        binding.idUserEmail.text = User().email
        binding.idNivel.text = User().nivel.toString()
    }
}