package com.jesil.toborowei.learnfirestore.domain

import com.jesil.toborowei.learnfirestore.data.remote.FirebaseService

class BloggerRepository constructor (
   private val userSignIn: FirebaseService
) {
    fun signInUserFromRepo(email: String, password: String){
        userSignIn.firebaseSignInUser(email, password)
    }
}