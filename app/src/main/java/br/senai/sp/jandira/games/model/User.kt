package br.senai.sp.jandira.games.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import br.senai.sp.jandira.games.model.niveisEnum

@Entity(tableName = "tbl_user") class User {

    @PrimaryKey var codigo = 0
    var nome = ""
    var email = ""
    var senha = ""
    var cidade = ""
    var sexo = 'I'
    var nivel = niveisEnum.BASICO

}