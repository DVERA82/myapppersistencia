package com.example.myapppersistencia

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.myapppersistencia.databinding.ActivityMainBinding
import com.example.myapppersistencia.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
private const val mFileSharedPreferences = "myapppersistencia"

class FirstFragment : Fragment() {

    private lateinit var myapppersistencia: SharedPreferences
    private lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        myapppersistencia =
            requireActivity().getSharedPreferences(mFileSharedPreferences, Context.MODE_PRIVATE)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.guardarEntero.text = myapppersistencia.getInt("Clave1", 0).toString()
        binding.guardarTexto.text = myapppersistencia.getString("Danny", "").toString()
        binding.guardarDecimal.text = myapppersistencia.getFloat("number", 0.0f).toString()
        var decimal = "number"
        var claveEntero = "Clave1"
        var textoingresado = "Danny"
        binding.buttonGuardar.setOnClickListener {

            var valor = binding.editNumber.text.toString().toInt()
            myapppersistencia.edit().putInt(claveEntero, valor).apply()
            var valor2 = myapppersistencia.getInt(claveEntero, 0).toString().toInt()
            binding.guardarEntero.setText(getString(R.string.valor_entero, valor2))


            var texto = binding.ingTexto.text.toString()
            myapppersistencia.edit().putString(textoingresado, texto).apply()
            var texto2 = myapppersistencia.getString(textoingresado, "").toString()
            binding.guardarTexto.setText(getString(R.string.texto_almacenado_1_s, texto2))


            var decimal2 = binding.editDecimal.text.toString().toFloat()
            myapppersistencia.edit().putFloat(decimal, decimal2).apply()
            var valor3 = myapppersistencia.getFloat(decimal, 0.0f).toString().toFloat()
            binding.guardarDecimal.setText(getString(R.string.valor_decimal, valor3.toString()))


        }
        binding.buttonBorrar.setOnClickListener {
            myapppersistencia.edit().remove(claveEntero).apply()
            myapppersistencia.edit().remove(decimal).apply()
            myapppersistencia.edit().remove(textoingresado).apply()
            binding.editNumber.setText("")
            binding.guardarEntero.setText("")
            binding.ingTexto.setText("")
            binding.guardarTexto.setText("")
            binding.editDecimal.setText("")
            binding.guardarDecimal.setText("")
        }


    }

}


