package com.example.appexamenpmdm1eva

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.URLUtil
import android.widget.CheckBox
import android.widget.Toast
import com.example.appexamenpmdm1eva.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var cadenaCheckBox:String=""
        var cadenaRadioButton:String=""

        //eventos de botones de radio
        binding.radiogroup.setOnCheckedChangeListener  { _,clave ->

            when (clave){
                R.id.rb1 -> showToast(getString(R.string.radiobutton1))
                R.id.rb2 -> showToast(getString(R.string.radiobutton2))
                R.id.rb3 -> showToast(getString(R.string.radiobutton3))

            }
        }

        //eventos de checkbox
        binding.chB1.setOnClickListener{
            DiferenciarCheckbox(binding.chB1)
        }
        binding.chB2.setOnClickListener{
            DiferenciarCheckbox(binding.chB2)
        }
        binding.chB3.setOnClickListener{
            DiferenciarCheckbox(binding.chB3)
        }

        binding.boton1.setOnClickListener {
            cadenaCheckBox=""
            cadenaRadioButton=""
            if(binding.chB1.isChecked) cadenaCheckBox+=binding.chB1.text.toString() + "\n"
            if(binding.chB2.isChecked) cadenaCheckBox+=binding.chB2.text.toString() + "\n"
            if(binding.chB3.isChecked) cadenaCheckBox+=binding.chB3.text.toString() + "\n"

            if(binding.rb1.isChecked) cadenaRadioButton+=binding.rb1.text.toString()
            if(binding.rb2.isChecked) cadenaRadioButton+=binding.rb2.text.toString()
            if(binding.rb3.isChecked) cadenaRadioButton+=binding.rb3.text.toString()


            val intent = Intent(this, SegundaActivity::class.java)

            intent.putExtra("cadenaCB", cadenaCheckBox)
            intent.putExtra("cadenaRB", cadenaRadioButton)
            startActivity(intent)

        }









    }

    private fun showToast(string: String) {
        Toast.makeText(this,string, Toast.LENGTH_SHORT).show()

    }
    private fun DiferenciarCheckbox(checkBox: CheckBox){
        val estaChequeado=checkBox.isChecked
        val checkBoxText=checkBox.text
        if(estaChequeado){
            showToast("$checkBoxText "+getString(R.string.selecionado))
        }else{
            showToast("$checkBoxText "+getString(R.string.deselecionado))
        }
    }

    //menu desde aqui
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_examen, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.acerca_de){
            showToast(getString(R.string.autor))
        }
        if(item.itemId==R.id.pizza_hut){
            openWebPage(this,"https://www.pizzahut.es/")
        }
        if(item.itemId==R.id.inicio){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        if(item.itemId==R.id.compartir){
            showToast(getString(R.string.compartir))

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, getString(R.string.texto_enviar))
                type = "text/plain"
            }

            try {

                startActivity(sendIntent)
            } catch (e: ActivityNotFoundException) {
                showToast(getString(R.string.no_se_puede))

            }

        }
        return true
    }

    fun openWebPage(context: Context, url: String?) {
        try {
            if (!URLUtil.isValidUrl(url)) {
                showToast(getString(R.string.enlace_no_valido))

            } else {
                val intent = Intent (Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(intent)

            }
        } catch (e: ActivityNotFoundException) {
            showToast(getString(R.string.no_hay_navegador))
        }
    }
    //menu hasta aqui

}