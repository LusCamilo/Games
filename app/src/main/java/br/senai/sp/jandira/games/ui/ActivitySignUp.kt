package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.model.niveisEnum
import jandira.sp.senai.br.games.repository.UserRepository


class ActivitySignUp : AppCompatActivity() {

    lateinit var  userRepository: UserRepository
    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editCity: EditText
    lateinit var editDate: EditText
    lateinit var checkBoxM: CheckBox
    lateinit var checkBoxF: CheckBox
    var user = User()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        editName = findViewById(R.id.editTextPersonName)
        editEmail = findViewById(R.id.editTextEmailAddress)
        editPassword = findViewById(R.id.editTextPassword)
        editCity = findViewById(R.id.editTextCity)
        editDate = findViewById(R.id.editTextDate)
        checkBoxM = findViewById(R.id.checkBoxM)
        checkBoxF = findViewById(R.id.checkBoxF)

        seekBar()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if(item.itemId == R.id.menu_save) {

            user.nome = editName.text.toString()
            user.email = editEmail.text.toString()
            user.senha = editPassword.text.toString()
            user.cidade = editCity.text.toString()


            userRepository = UserRepository(this)
            userRepository.save(user)


            var exitMainActivity = Intent(this, MainActivity::class.java)
            startActivity(exitMainActivity)

            true

        } else if(item.itemId == R.id.menu_exit) {

            var exitMainActivity = Intent(this, MainActivity::class.java)
            startActivity(exitMainActivity)
            true

        } else{

            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()

            true
        }

        return true

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true

    }

    private fun seekBar(){

        var seekBar: SeekBar
        var level: TextView = findViewById(R.id.level)
        seekBar = findViewById(R.id.seekBar)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {


                if (progress > 24 && progress < 50){

                    level.setText("basico")
                    user.nivel = niveisEnum.BASICO

                }else if(progress > 49 && progress < 76){

                    level.setText("intermediario")
                    user.nivel = niveisEnum.INTERMEDIARIO


                }else if (progress > 75 && progress < 101){

                    level.setText("avançado")
                    user.nivel = niveisEnum.AVANCADO

                }else
                    level.setText("casual")
                    user.nivel = niveisEnum.CASUAL
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {


            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {



            }


        })

    }

}