package app.phone.machinecoding.ui.logolisting

import androidx.lifecycle.*
import app.phone.machinecoding.R
import app.phone.machinecoding.provider.resourceprovider.ResourceProvider
import app.phone.machinecoding.model.LogoQuizModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LogoListScreenViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val screenState: MutableLiveData<LogoListScreenState> = MutableLiveData()

    val logoQuizList: LiveData<ArrayList<LogoQuizModel>> = screenState.map {
        (it as? LogoListScreenState.LoadingSuccess)?.logoQuizModels ?: ArrayList()
    }

    fun loadLogoList() {
        try {
            screenState.value = LogoListScreenState.Loading
            val logoQuizModels = resourceProvider.readRawJson<ArrayList<LogoQuizModel>>(R.raw.logo)
            screenState.value = LogoListScreenState.LoadingSuccess(
                logoQuizModels = logoQuizModels
            )
        } catch (e:Exception) {
            screenState.value = LogoListScreenState.LoadingFailed
        }
    }
}