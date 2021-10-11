package com.jesil.toborowei.learnfirestore.presentation.fragments.sign_in

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseUser
import com.jesil.toborowei.learnfirestore.R
import com.jesil.toborowei.learnfirestore.data.remote.FirebaseServiceImpl
import com.jesil.toborowei.learnfirestore.databinding.SignInFragmentBinding
import com.jesil.toborowei.learnfirestore.domain.BloggerRepository
import com.jesil.toborowei.learnfirestore.presentation.fragments.utils.*

class SignInFragment : Fragment(), BloggerState {

    private var _binding: SignInFragmentBinding? = null
    private val binding get() = _binding!!
    private val firebaseServiceImpl = FirebaseServiceImpl(_bloggerListener = this)
    private val repo: BloggerRepository by lazy {
        BloggerRepository(firebaseServiceImpl)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SignInFragmentBinding.inflate(inflater, container, false)
        initViews()

        return binding.root

    }

    private fun initViews() = with(binding) {
        validateEmailInput(emailInput, emailInputLayout, signInButton)
        validatePasswordInput(passwordInput, passwordInputLayout, signInButton)

        if (!signInButton.isEnabled) {
            signInButton.setOnClickListener {
                signInProgressBar showProgress true
                signInButton enable false
                val email = emailInput.text.toString()
                val password = passwordInput.text.toString()
                signInUser(email, password)
            }
        }

        signUpTextView.setOnClickListener {
            context showErrorDialog getString(R.string.sign_up_message)
        }
    }

    private fun signInUser(email: String, password: String) {
        repo.signInUserFromRepo(email, password)
    }

    private fun validateEmailInput(
        emailInput: TextInputEditText,
        emailInputLayout: TextInputLayout,
        signInButton: Button
    ) {
        emailInput.validateEmail(
            validate = {
                emailInputLayout error getString(R.string.error_valid_email)
                signInButton enable false
            }, secondValidate = {
                emailInputLayout error getString(R.string.error_enter_email)
                signInButton enable false
            }, denied = {
                emailInputLayout.error = null
            })

    }

    private fun validatePasswordInput(
        passwordInput: TextInputEditText,
        passwordInputLayout: TextInputLayout,
        signInButton: Button
    ) {
        passwordInput.validatePassword(
            validate = {
                passwordInputLayout error getString(R.string.error_enter_pasword)
            }, secondValidate = {
                passwordInputLayout error getString(R.string.error_password_length)
                signInButton enable false
            }, denied = {
                passwordInputLayout error null
                signInButton enable true
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun navigateToNextFragment(user: FirebaseUser?) {
        binding.signInProgressBar showProgress false
        binding.signInButton enable true

        findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
    }

    override fun showErrorDialog(e: Exception?) {
        context showErrorDialog e?.localizedMessage
        binding.signInProgressBar showProgress false
        binding.signInButton enable true

    }
    }