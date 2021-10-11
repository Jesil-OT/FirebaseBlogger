package com.jesil.toborowei.learnfirestore.data.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.jesil.toborowei.learnfirestore.presentation.fragments.utils.BloggerState

class FirebaseServiceImpl constructor(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance(),
    private val _bloggerListener : BloggerState
) : FirebaseService {
    val progressBarObserver = MutableLiveData<Boolean>()
    override fun firebaseSignInUser(userEmail: String, userPassword: String) {
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener {
            progressBarObserver.value = true
            if (it.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                // do navigation
                Log.d("FirebaseServiceImpl", "signInWithEmail:success")
                val user = auth.currentUser
                _bloggerListener.navigateToNextFragment(user)

            } else {
                // If sign in fails, display a message to the user.
                // show error dialog
                progressBarObserver.value = false
                _bloggerListener.showErrorDialog(it.exception)
                Log.w("FirebaseServiceImpl", "signInWithEmail:failure", it.exception)
            }
        }
    }

}