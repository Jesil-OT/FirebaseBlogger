package com.jesil.toborowei.learnfirestore.presentation.fragments.sign_in

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.android.gms.common.SignInButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.jesil.toborowei.learnfirestore.R
import com.jesil.toborowei.learnfirestore.databinding.SignInFragmentBinding
import com.jesil.toborowei.learnfirestore.presentation.fragments.utils.enableButton
import com.jesil.toborowei.learnfirestore.presentation.fragments.utils.error
import com.jesil.toborowei.learnfirestore.presentation.fragments.utils.validateEmail
import com.jesil.toborowei.learnfirestore.presentation.fragments.utils.validatePassword

class SignInFragment : Fragment() {

    private val viewModel by viewModels<SignInViewModel>()
    private var _binding: SignInFragmentBinding? = null
    private val binding get() = _binding!!

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
                Toast.makeText(requireContext(), "Done", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateEmailInput(
        emailInput: TextInputEditText,
        emailInputLayout: TextInputLayout,
        signInButton: Button
    ) {
        emailInput.validateEmail(
            validate = {
                emailInputLayout error getString(R.string.error_valid_email)
                signInButton enableButton false
            }, secondValidate = {
                emailInputLayout error getString(R.string.error_enter_email)
                signInButton enableButton false
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
                signInButton enableButton false
            }, denied = {
                passwordInputLayout error null
                signInButton enableButton true
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}