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
            this.context?.getSharedPreferences(mFileSharedPreferences, Context.MODE_PRIVATE)
                ?: return binding.root
    }



        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)



            view.findViewById<Button>(R.id.textview_first).setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }

        fun Save() {

            val mUserKey = ""
            var mUserRead = myapppersistencia.getString(mUserKey, "")
            if (mUserRead != null) {
                Log.d("TAG", mUserRead)
            }


            //obtener un int
            myapppersistencia.getInt("TestInt", -1)


            //obtener un boolean
            myapppersistencia.getBoolean("TestBoolean", false)


            //obtener un String
            myapppersistencia.getString("TestString", "NotFound")

            //obtener un Set<String>
            myapppersistencia.getStringSet("TestStringSet", setOf())
        }
    }

}



