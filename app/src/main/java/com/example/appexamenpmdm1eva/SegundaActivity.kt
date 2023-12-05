package com.example.appexamenpmdm1eva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


    }
}