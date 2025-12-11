package com.example.dsgavs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dsgavs.model.UserModel
import com.example.dsgavs.repository.UserRepo

class UserViewModel(val repo: UserRepo): ViewModel() {

    fun login(
        email: String, password: String,
        callback: (Boolean, String) -> Unit
    ) {
        repo.login(email, password, callback)
    }

    fun register(
        email: String, password: String,
        callback: (Boolean, String, String) -> Unit
    ) {
        repo.register(email, password, callback)
    }

    fun addUserToDatabase(
        userId: String, model: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        repo.addUserToDatabase(userId, model, callback)
    }

    fun forgetPassword(
        email: String,
        callback: (Boolean, String) -> Unit
    ) {
        repo.forgotPassword(email, callback)
    }

    private val _users = MutableLiveData<UserModel?>()
    val users: MutableLiveData<UserModel?>
        get() = _users

    private val _allUsers = MutableLiveData<List<UserModel>?>()
    val allUsers: MutableLiveData<List<UserModel>?>
        get() = _allUsers

    private val _loading = MutableLiveData<Boolean>()
    val loading: MutableLiveData<Boolean>
        get() = _loading

    fun getAllUsers() {
        _loading.postValue(true)
        repo.getAllUsers { success, msg, data ->
            if (success) {
                _allUsers.postValue(data)
                _loading.postValue(false)
            }
            _loading.postValue(false)
        }
    }

    fun editProfile(userId: String, model: UserModel, callback: (Boolean, String) -> Unit) {
        repo.editProfile(userId, model, callback)
    }

    fun deleteAccount(userId: String, callback: (Boolean, String) -> Unit) {
        repo.deleteAccount(userId, callback)
    }

}