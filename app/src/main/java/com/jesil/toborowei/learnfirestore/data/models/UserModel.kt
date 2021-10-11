package com.jesil.toborowei.learnfirestore.data.models

data class UserModel(
    val uid : String,
    val username : String,
    val userEmail : String,
    val userImage: String,
    val userGender: String,
    val userBiography: String
)