package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.User


@Database(entities = [User::class],  version = 1)
abstract class UserDB: RoomDatabase() {

    abstract fun  UserDao(): UserDao

    companion object {

        private lateinit var instance: UserDB

        fun getDataBase(context: Context): UserDB{

            if (!::instance.isInitialized) {

                instance = Room.databaseBuilder(context, UserDB::class.java, "db_agenda").allowMainThreadQueries().build()

            }
            return  instance
        }
    }

}