package app.phone.machinecoding.ui.logolisting.callback

import app.phone.machinecoding.model.LogoQuizModel

interface LogoListCallback {

    fun onItemClicked(logoQuizModel: LogoQuizModel)
}