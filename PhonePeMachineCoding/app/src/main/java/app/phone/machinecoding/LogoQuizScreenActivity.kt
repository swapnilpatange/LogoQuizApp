package app.phone.machinecoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.phone.machinecoding.model.LogoQuizModel
import app.phone.machinecoding.ui.logolisting.LogoListScreenFragment
import app.phone.machinecoding.ui.logolisting.callback.LogoListCallback
import app.phone.machinecoding.ui.logoguess.LogoGuessFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogoQuizScreenActivity : AppCompatActivity(), LogoListCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragContainer, LogoListScreenFragment.newInstance())
            .commit()
    }

    override fun onItemClicked(model: LogoQuizModel) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragContainer, LogoGuessFragment.newInstance(logoQuizModel = model))
            .addToBackStack(null)
            .commit()
    }
}