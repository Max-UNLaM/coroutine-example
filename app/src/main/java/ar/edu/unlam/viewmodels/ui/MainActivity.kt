package ar.edu.unlam.viewmodels.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import ar.edu.unlam.viewmodels.viewmodels.MainViewModel
import ar.edu.unlam.viewmodels.R

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels { MainViewModel.Factory(0) }
    lateinit var texto: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.texto)
        val clicksObserver = Observer<Number> { newInt ->
            texto.text = newInt.toString()
        }

        val otroObserver = Observer<Number> { newInt ->
            Toast.makeText(applicationContext, newInt.toString(), Toast.LENGTH_SHORT).show()
        }

        viewModel.clicksAmount.observe(this, clicksObserver)
        viewModel.clicksAmount.observe(this, otroObserver)
        findViewById<Button>(R.id.btnContar).setOnClickListener {
            viewModel.increaseClicks()
        }
    }

}