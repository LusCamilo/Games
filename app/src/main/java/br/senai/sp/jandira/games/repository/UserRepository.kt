package jandira.sp.senai.br.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.UserDB
import br.senai.sp.jandira.games.dao.UserDao
import br.senai.sp.jandira.games.model.User

class UserRepository(context: Context) {

    private val db = UserDB.getDataBase(context).UserDao()

    fun save(user: User): Long {

        return db.save(user)

    }
    fun login(email: String, pass: String): User {

        return db.getUser(email, pass)

    }
}