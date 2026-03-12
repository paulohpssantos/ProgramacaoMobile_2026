package com.example.meuprimeiroapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meuprimeiroapp.ui.theme.MeuPrimeiroAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        

        val edTexto = findViewById<EditText>(R.id.edTexto)
        val tvTextoDigitado = findViewById<TextView>(R.id.tvTextoDigitado)
        val btMudarNome = findViewById<Button>(R.id.btMudarNome)

        btMudarNome.setOnClickListener {
            val texto = edTexto.text.toString();
            tvTextoDigitado.text = "Texto digitado: $texto"
        }

    }
}

