package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.Entity

@Entity(tableName = "tbl_game")
class Game {

    var codigo = 0
    var nome = ""
    var fabricante = ""
    var descricao = ""
    var foto: Bitmap? = null
    var anoLancamento = 0

}