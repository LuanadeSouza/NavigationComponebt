package br.com.luanadev.navigationcomponentapplication.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.luanadev.navigationcomponentapplication.R
import br.com.luanadev.navigationcomponentapplication.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        viewModel.authenticationStateEvent.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.Authenticated -> {
                    textProfileWelcome.text = getString(R.string.profile_text_welcome, viewModel.username)
                }
                LoginViewModel.AuthenticationState.Unauthenticated -> {
                    navController.navigate(R.id.loginFragment)
                }
            }
        })
    }

}