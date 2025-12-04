package com.example.dsgavs.repository

import com.example.dsgavs.model.UserModel

class UserRepoImpl : UserRepo{
    override fun login(
        email: String,
        password: String,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun register(
        email: String,
        password: String,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun addUserToDatabase(
        userId: String,
        model: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun forgotPassword(
        email: String,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getUserByGender(
        gender: String,
        callback: (Boolean, String, List<UserModel>) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getUserByID(
        userId: String,
        callback: (Boolean, UserModel) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(callback: (Boolean, String, List<UserModel>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun editProfile(
        userId: String,
        model: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun deleteAccount(
        userId: String,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }


}