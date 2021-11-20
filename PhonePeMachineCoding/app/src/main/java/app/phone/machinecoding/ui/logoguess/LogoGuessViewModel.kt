package app.phone.machinecoding.ui.logoguess

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.phone.machinecoding.model.LogoQuizModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogoGuessViewModel @Inject constructor(): ViewModel() {

    val logoModel: MutableLiveData<LogoQuizModel> = MutableLiveData()

    fun loadArguments(logoQuizModel: LogoQuizModel?) {
        logoModel.value = logoQuizModel
    }
}