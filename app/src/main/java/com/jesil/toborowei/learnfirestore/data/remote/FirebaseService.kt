package com.jesil.toborowei.learnfirestore.data.remote

import com.google.firebase.auth.FirebaseAuth

interface FirebaseService {

    fun firebaseSignInUser(userEmail: String, userPassword: String)
}