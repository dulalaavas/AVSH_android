package com.example.dsgavs.repository

import com.example.dsgavs.model.UserModel

interface UserRepo {
//    {
//        "Success": true,
//        "Message": "User logged in successfully"
//    }


    fun login(
        email: String, password: String,
        callback: (Boolean, String) -> Unit
    )

    fun register(
        email: String, password: String,
        callback: (Boolean, String, String) -> Unit
    )

    fun addUserToDatabase(
        userId: String, model: UserModel,
        callback: (Boolean, String) -> Unit

    )

    fun forgotPassword(
        email: String,
        callback: (Boolean, String) -> Unit
    )

    fun getUserByGender(
        gender: String,
        callback: (Boolean, String, List<UserModel>) -> Unit
    )

    fun getUserByID(
        userId: String,
        callback: (Boolean, String, UserModel?) -> Unit
    )

    fun getAllUsers(
        callback: (Boolean, String, List<UserModel>) -> Unit
    )

    fun editProfile(
        userId: String, model: UserModel,
        callback: (Boolean, String) -> Unit
    )

    fun deleteAccount(
        userId: String,
        callback: (Boolean, String) -> Unit
    )
}