package br.com.luanadev.navigationcomponentapplication.data.repository

import br.com.luanadev.navigationcomponentapplication.data.model.User
import br.com.luanadev.navigationcomponentapplication.ui.registration.RegistrationsViewParams

interface UserRepository {

    fun reateUser(registrationViewParams: RegistrationsViewParams)

    fun getUser(id: Long): User

    fun login(username: String, password: String): Long
}