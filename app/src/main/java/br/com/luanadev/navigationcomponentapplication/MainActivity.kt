package br.com.luanadev.navigationcomponentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.luanadev.navigationcomponentapplication.ui.profile.ProfileFragment
import br.com.luanadev.navigationcomponentapplication.ui.start.StartFragment

class MainActivity : AppCompatActivity(), StartFragment.OnButtonClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.my_container, StartFragment.newInstance())
            .commit()
    }

    override fun buttonClicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_container, ProfileFragment.newInstance())
            .commit()
    }
}