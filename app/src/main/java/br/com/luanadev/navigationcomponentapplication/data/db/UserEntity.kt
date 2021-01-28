package br.com.luanadev.navigationcomponentapplication.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.luanadev.navigationcomponentapplication.data.model.User
import br.com.luanadev.navigationcomponentapplication.ui.registration.RegistrationsViewParams


@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Long = 0,
    val name: String,
    val bio: String,
    val username: String,
    val password: String
)

fun RegistrationsViewParams.toUserEntity(): UserEntity {
    return with(this) {
        UserEntity(
            name = this.name,
            bio = this.bio,
            username = this.username,
            password = this.password
        )
    }
}

fun UserEntity.toUser(): User {
    return User(
        id = this.id.toString(),
        name = this.name,
        bio = this.bio
    )
}