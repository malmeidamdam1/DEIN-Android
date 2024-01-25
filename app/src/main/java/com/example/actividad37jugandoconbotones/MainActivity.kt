package com.example.actividad37jugandoconbotones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private  val numBotones = 10

    private lateinit var llBotonera: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llBotonera  =  findViewById(R.id.llBotonera)

        //Creamos las propiedades de layout que tendrán los botones
        val lp = LinearLayout.LayoutParams(
           LinearLayout.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.button_height)
        )
        //Creamos los botones en bucle
        for (i in 0 until numBotones){
            val button = Button(this)
            //Asignamos propiedades de layout al botón
            button.layoutParams = lp
            //Asignamos Texto al botón
            button.text = "Botón " + String.format("%02d", i)

            //Asignamos el Listener a cada botón
            button.setOnClickListener(buttonClickListener(i))

            //Añadimos botón a la botonera
            llBotonera.addView(button)
        }
    }
    //Fuera del metodo clickboton para que no se este refactorizando siempre
    val numAleatorio = Random.nextInt(1,10)

    private fun buttonClickListener(index: Int): View.OnClickListener? {

        println("Valor de numAleatorio: $numAleatorio")

        Log.d("MyApp", "Valor de numAleatorio: $numAleatorio")


        return  View.OnClickListener {
            println("Valor de index: $index")
            Log.d("MyApp", "Valor de numAleatorio: $numAleatorio")



            if (index == numAleatorio) {
                Toast.makeText(
                    this@MainActivity,
                    "ME ENCONTRASTE", Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Sigue buscando",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

//Antigua Version
//val lp = LinearLayout.LayoutParams(
//    LinearLayout.LayoutParams.MATCH_PARENT,
//    LinearLayout.LayoutParams.WRAP_CONTENT
//)