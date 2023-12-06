package com.example.appexamenpmdm1eva

import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appexamenpmdm1eva.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cadenaCheckBox=intent.getStringExtra("cadenaCB")
        var cadenaRadioButton=intent.getStringExtra("cadenaRB")

        binding.resultados.text=cadenaCheckBox+"\n"+cadenaRadioButton

        //Inicio Spinner de numeros
        val numberSpinner: Spinner = binding.numberSpinner
        // Crear un ArrayAdapter de números
        val adapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_item,
            generateNumberList(1, 3) // Genera una lista de números del 1 al 3
        )
        // Especificar el diseño a utilizar cuando aparece la lista de opciones
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        // Asignar el adaptador al Spinner
        numberSpinner.adapter = adapter

        // Manejar eventos de selección del Spinner
        numberSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long) {
                // Manejar la selección del número
                val selectedNumber = parentView.getItemAtPosition(position) as Int
                showToast("Numero seleccionado: $selectedNumber")
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Manejar el caso cuando no se selecciona nada
            }


        }
        //FIN del Spinner de numeros


        //inicio del spinner de paises
        val countrySpinner: Spinner = binding.countrySpinner
        val paises = arrayOf("Argentina", "Brasil", "Chile", "Colombia", "México")

        // Crear un ArrayAdapter de strings
        val adapterPaises = ArrayAdapter(this,R.layout.simple_spinner_item,paises)

        // Especificar el diseño a utilizar cuando aparece la lista de opciones
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        // Asignar el adaptador al Spinner
        countrySpinner.adapter = adapterPaises

        // Manejar eventos de selección del Spinner

        countrySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Manejar la selección del país
                val selectedCountry = parentView.getItemAtPosition(position).toString()
                showToast("País seleccionado: $selectedCountry")
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Manejar el caso cuando no se selecciona nada
            }
        }
        //Fin del spinner de paises



    }
    // Método para generar una lista de números en el rango especificado
    private fun generateNumberList(start: Int, end: Int): Array<Int> {
        return (start..end).toList().toTypedArray()
    }

    private fun showToast(string: String) {
        Toast.makeText(this,string, Toast.LENGTH_SHORT).show()

    }

}