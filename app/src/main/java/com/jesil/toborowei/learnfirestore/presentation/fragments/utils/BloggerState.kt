package com.jesil.toborowei.learnfirestore.presentation.fragments.utils

import com.google.firebase.auth.FirebaseUser

interface BloggerState{

    fun navigateToNextFragment (user: FirebaseUser?)

    fun showErrorDialog(e: Exception?)

}