package com.jes.wikiworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent;
import android.os.PersistableBundle
import android.util.Log

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Intent para detectar si se ha pulsado salir.
        if (intent.getBooleanExtra("Exit", false)) {
            finish()
        }

        val btnGoToCredit = findViewById<Button>(R.id.btnGoToCredit)
        btnGoToCredit.setOnClickListener {
            val etName = findViewById<EditText>(R.id.etName)
            val userName = etName.text.toString()

            // Crear el intent para iniciar CreditActivity
            val creditIntent = Intent(this@MainActivity, CreditActivity::class.java)
            creditIntent.putExtra("userName", userName)
            startActivity(creditIntent)
        }
    }

    companion object {
        const val LIFECLICLE = "LifeCycle"
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LIFECLICLE,"La Activity ha sido reiniciada (Restarted)")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECLICLE,"La Activity ha sido iniciada (Started)")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECLICLE,"La Activity ha pasado a primer plano (Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECLICLE,"La Activity ha sido pausada (Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECLICLE,"La Activity ha sido parada (Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECLICLE,"La Activity ha sido destruida (Destroyed)")
    }

    fun goToCreditActivity(view: View) {}


}