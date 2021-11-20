package app.phone.machinecoding.ui.logolisting

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import app.phone.machinecoding.databinding.LogoListingBinding
import app.phone.machinecoding.model.LogoQuizModel
import app.phone.machinecoding.ui.logolisting.callback.LogoListCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogoListScreenFragment : Fragment(), LogoListCallback {

    companion object {
        fun newInstance() = LogoListScreenFragment()
    }

    private val viewModel: LogoListScreenViewModel by viewModels()

    private var logoListCallback: LogoListCallback?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logoListCallback = requireActivity() as? LogoListCallback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadLogoList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = LogoListingBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.callback = this
        return binding.root
    }

    override fun onItemClicked(logoQuizModel: LogoQuizModel) {
        logoListCallback?.onItemClicked(logoQuizModel = logoQuizModel)
    }
}