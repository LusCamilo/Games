package br.senai.sp.jandira.games.adapter

import android.content.Context
import br.senai.sp.jandira.games.dao.UserDB
import br.senai.sp.jandira.games.model.User

class GamesAdapter(context: Context) {

    private val db = UserDB.getDataBase(context).UserDao()

    fun save(user: User): Long {

        return db.save(user)

    }
}