package com.arshboughan

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.arshboughan.databinding.ActivityMainBinding
import com.arshboughan.databinding.CustomdialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var tvName:TextView
    lateinit var tvAddress:TextView
    lateinit var tvGender:TextView
    lateinit var btnUpdate:Button
    lateinit var Binding: CustomdialogBinding
    lateinit var binding: ActivityMainBinding
    private lateinit var dialog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvName=findViewById(R.id.tvName)
        tvAddress=findViewById(R.id.tvAddress)
        tvGender=findViewById(R.id.tvGender)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Binding = CustomdialogBinding.inflate(layoutInflater)
        dialog = Dialog(this)
        dialog.setContentView(Binding.root)


        binding.btnUpdate.setOnClickListener {
            Binding.etName.setText(binding.tvName.text.toString())
            Binding.etAddress.setText(binding.tvAddress.text.toString())
            if(Binding.rbHe.isChecked) {
                binding.tvGender.text = "She"
            }else if(Binding.rbShe.isChecked){
                binding.tvGender.text = "He"
            }
            else
            {
                Binding.rbOther.isChecked
                Binding.et1.visibility = View.VISIBLE
                Binding.et1.setText(tvGender.text.toString())
            }
            dialog.show()}

        Binding.rgGender.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.rbOther -> {
                    Binding.et1.visibility = View.VISIBLE
                }
                else -> {
                    Binding.et1.visibility = View.INVISIBLE
                }
            }
        }

        Binding.btnUpdate.setOnClickListener {
            if (Binding.et1.text.isNullOrEmpty()) {
                Toast.makeText(this, "Enter Name", Toast.LENGTH_LONG).show()
                Binding.et1.requestFocus()
            } else if (Binding.etAddress.text.isNullOrEmpty()) {
                Toast.makeText(this, "Enter Address", Toast.LENGTH_LONG).show()
                Binding.etAddress.requestFocus()
            } else if ((Binding.rbOther.isChecked) && (Binding.et1.text.isNullOrEmpty())) {
                Toast.makeText(this, "Enter Other Gender", Toast.LENGTH_LONG).show()
                Binding.et1.requestFocus()
            } else {
                binding.tvName.text = Binding.et1.text.toString()
                binding.tvAddress.text = Binding.etAddress.text.toString()
                if (Binding.rbOther.isChecked) {
                    binding.tvGender.text = Binding.et1.text.toString()
                } else if (Binding.rbHe.isChecked) {
                    binding.tvGender.text = "She"
                } else if (Binding.rbShe.isChecked) {
                    binding.tvGender.text = "He"
                }
                dialog.dismiss()
            }
        }
    }
}
