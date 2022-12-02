package br.senai.sp.jandira.games.dao

import  androidx.room.*
import br.senai.sp.jandira.games.model.Game

@Dao interface GamesDao {

    @Insert fun save(game: Game): Long

    @Delete fun delete(game: Game): Int
}