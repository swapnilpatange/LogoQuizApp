package app.phone.machinecoding.ui.logolisting

import app.phone.machinecoding.model.LogoQuizModel

sealed class LogoListScreenState {
    object Loading : LogoListScreenState()
    data class LoadingSuccess(val logoQuizModels: List<LogoQuizModel>) : LogoListScreenState()
    object LoadingFailed : LogoListScreenState()
}