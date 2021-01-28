package br.com.luanadev.navigationcomponentapplication.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.luanadev.navigationcomponentapplication.data.db.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUser(id: Long): UserEntity

    @Query("SELECT id From user WHERE username = :username and password = :password ")
    fun login(username: String, password: String): Long
}