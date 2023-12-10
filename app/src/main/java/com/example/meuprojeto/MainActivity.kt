package com.example.meuprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.meuprojeto.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calcularPreco (view : View){
        val precoAlcool = binding.editPrecoAlcool.text.toString()
        val precoGasolina = binding.editPrecoGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if (validaCampos) calcularMelhorPreco(precoAlcool, precoGasolina) else binding.textResultado.setText("Preeencha os preços campos")
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{
        var camposValidados = true
        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
    }
        return camposValidados
    }
    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()
        val resultadoPreco = valorAlcool/valorGasolina
        if (resultadoPreco >= 0.7) binding.textResultado.setText("Melhor Utilizar Gasolina") else binding.textResultado.setText("Melhor utilizar Álcool")
    }
}