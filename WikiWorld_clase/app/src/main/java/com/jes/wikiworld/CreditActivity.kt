package com.jes.wikiworld

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class CreditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        // Obtén el nombre de usuario del intent
        val userName = intent.getStringExtra("userName")  // Cambiado a "userName"

        // Muestra el nombre de usuario y la versión de la aplicación
        val userInfoText = findViewById<TextView>(R.id.userInfoText)
        userInfoText.text = "¡Gracias, $userName! Estás usando la versión 1 de la aplicación."




        val contactButton = findViewById<Button>(R.id.contactButton)
        contactButton.setOnClickListener {
            // Crea un intent implícito para enviar un correo electrónico
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("xusbarreda@hotmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app WikiWorld")

            // Verifica si hay alguna aplicación que pueda manejar el intent
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Si no hay ninguna aplicación de correo electrónico instalada, puedes mostrar un mensaje al usuario
                // indicando que no hay aplicaciones disponibles para manejar la acción.
                // Puedes personalizar este mensaje según tus necesidades.
                Toast.makeText(this, "No hay aplicaciones de correo electrónico instaladas.", Toast.LENGTH_SHORT).show()
            }

        }



    }
}