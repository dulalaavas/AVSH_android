package com.example.dsgavs.repository

import com.example.dsgavs.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UserRepoImpl : UserRepo {

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()

    val ref = database.getReference("User")

    override fun login(
        email: String,
        password: String,
        callback: (Boolean, String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) { //passed through view
                    callback(true, "User logged in successfully")

                } else {
                    callback(false, "${it.exception?.message}")

                }
            }
    }

    override fun register(
        email: String, password: String,
        callback: (Boolean, String, String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback(true, "User registered successfully", "${auth.currentUser?.uid}")
                } else {
                    callback(false, "${it.exception?.message}", "")
                }
            }
    }

    override fun addUserToDatabase(
        userId: String,
        model: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        //val id = ref.push().key.toString()

        ref.child(userId).setValue(model)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback(true, "User added to database")
                } else {
                    callback(false, "${it.exception?.message}")
                }
            }

    }

    override fun forgotPassword(
        email: String,
        callback: (Boolean, String) -> Unit
    ) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback(true, "Verification sent to $email")

                } else {
                    callback(false, "${it.exception?.message}")

                }
            }
    }

    override fun getUserByGender(
        gender: String,
        callback: (Boolean, String, List<UserModel>) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getUserByID(
        userId: String,
        callback: (Boolean, String, UserModel?) -> Unit
    ) {
        ref.child(userId)
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(UserModel::class.java)
                    if (user != null) {
                        callback(true, "Profile fetched successfully",user)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }

    override fun getAllUsers(callback: (Boolean, String, List<UserModel>) -> Unit) {
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val allUsers = mutableListOf<UserModel>()
                    for (data in snapshot.children){
                        val user = data.getValue(UserModel::class.java)
                        if (user != null) {
                            allUsers.add(user)
                        }

                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false, "${error.message}", emptyList())
            }

        })
    }

    override fun editProfile(
        userId: String,
        model: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(userId).updateChildren(model.toMap())
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback(true, "User updated successfully")
                } else {
                    callback(false, "${it.exception?.message}")
                }
            }
    }


    override fun deleteAccount(
        userId: String,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(userId).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback(true, "User deleted successfully")
                } else {
                    callback(false, "${it.exception?.message}")
                }
            }
    }

}