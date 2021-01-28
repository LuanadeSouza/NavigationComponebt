package br.com.luanadev.navigationcomponentapplication.data.repository

import br.com.luanadev.navigationcomponentapplication.data.db.dao.UserDao
import br.com.luanadev.navigationcomponentapplication.data.db.toUser
import br.com.luanadev.navigationcomponentapplication.data.db.toUserEntity
import br.com.luanadev.navigationcomponentapplication.data.model.User
import br.com.luanadev.navigationcomponentapplication.ui.registration.RegistrationsViewParams

class UserDbDataSource(private val userDao: UserDao) : UserRepository {
    override fun reateUser(registrationViewParams: RegistrationsViewParams) {
        val userEntity = registrationViewParams.toUserEntity()
        userDao.save(userEntity)
    }

    override fun getUser(id: Long): User {
        return userDao.getUser(id).toUser()
    }

    override fun login(username: String, password: String): Long {
        return userDao.login(username, password)
    }
}