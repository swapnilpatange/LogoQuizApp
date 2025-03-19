package app.phone.machinecoding.ui.logolisting

import androidx.lifecycle.*
import app.phone.machinecoding.provider.resourceprovider.ResourceProvider
import app.phone.machinecoding.model.LogoQuizModel
import dagger.hilt.android.lifecycle.HiltViewModel
import phonepemachinecoding.R
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LogoListScreenViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val screenState: MutableLiveData<LogoListScreenState> = MutableLiveData()

    val logoQuizList: LiveData<List<LogoQuizModel>> = screenState.map {
        (it as? LogoListScreenState.LoadingSuccess)?.logoQuizModels ?: ArrayList()
    }

    fun loadLogoList() {
        try {
            screenState.value = LogoListScreenState.Loading
            val logoQuizModels:List<LogoQuizModel> = resourceProvider.readRawJson(R.raw.logo)
            screenState.value = LogoListScreenState.LoadingSuccess(
                logoQuizModels = logoQuizModels
            )
        } catch (e:Exception) {
            screenState.value = LogoListScreenState.LoadingFailed
        }
    }
}