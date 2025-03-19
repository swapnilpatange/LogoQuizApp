package app.phone.machinecoding.ui.logoguess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import app.phone.machinecoding.model.LogoQuizModel
import phonepemachinecoding.databinding.LogoGuessBinding

class LogoGuessFragment : Fragment() {

    companion object {

        fun newInstance(logoQuizModel: LogoQuizModel): LogoGuessFragment {
            return LogoGuessFragment().apply {
                arguments = bundleOf("logoModel" to logoQuizModel)
            }
        }
    }

    private val viewModel: LogoGuessViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadArguments(arguments?.get("logoModel") as? LogoQuizModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = LogoGuessBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}