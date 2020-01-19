package com.orqa.fpv.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.orqa.fpv.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var btnDone : Button;
    lateinit var editNickname : EditText;
    lateinit var textNickname: TextView
    lateinit var inputMethodManager: InputMethodManager
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Matej")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        btnDone = binding.btnDone
        binding.myName = myName
        editNickname = binding.editNickname
        textNickname = binding.textNickname
        binding.btnDone.setOnClickListener { saveNickname(it) }
        binding.textNickname.setOnClickListener { editNickname(it) }
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    fun saveNickname(view: View){
        binding.apply {
            myName?.nickname = editNickname.text.toString();
            invalidateAll()
            editNickname.visibility = View.GONE;
            textNickname.visibility = View.VISIBLE;
            view.visibility = View.GONE
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun editNickname(view : View){
        editNickname.visibility = View.VISIBLE;
        textNickname.visibility = View.GONE;
        btnDone.visibility = View.VISIBLE
        editNickname.requestFocus()
        inputMethodManager.showSoftInput(editNickname, 0)
    }
}
