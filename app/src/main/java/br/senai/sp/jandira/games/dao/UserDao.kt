package br.senai.sp.jandira.games.dao

import  androidx.room.Dao
import  androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.games.model.User


@Dao interface UserDao {

    @Insert fun save(user: User): Long

    @Query("select * from tbl_user where email = :email and senha = :senha") fun getUser(email: String, senha: String): User

}