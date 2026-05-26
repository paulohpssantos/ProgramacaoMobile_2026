package com.example.exemplojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.reflect.typeOf


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinhaTela()
        }
    }
}

@Composable
fun MinhaTela(){

    //Variavel do componente TextField
    var nome by remember {
        mutableStateOf("")
    }

    var mensagem by remember {
        mutableStateOf(0)
    }

    var numero1 by remember {
        mutableStateOf("")
    }

    var numero2 by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ){
        Text(
            "Hello World",
            fontSize = 32.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Clique aqui",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = {
                nome = it
            },
            label = {
                Text("Nome")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Olá $nome",
            fontSize = 32.sp,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
          Button(
              onClick = {},
              modifier = Modifier.weight(1f)
          ) {
              Text(
                  "Cancelar"
              )
            }
            Button(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "Salvar"
                )
            }
        }

        OutlinedTextField(
            value = numero1,
            onValueChange = {
                numero1 = it
            },
            label = {
                Text("Numero 1")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        OutlinedTextField(
            value = numero2,
            onValueChange = {
                numero2 = it
            },
            label = {
                Text("Numero 2")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )

        )

        Button(
            onClick = {
                val n1 = numero1.toInt()
                val n2 = numero2.toInt()
                mensagem = n1 + n2
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Somar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text("Resultado da Soma: $mensagem",
            fontSize = 30.sp)

    }


}