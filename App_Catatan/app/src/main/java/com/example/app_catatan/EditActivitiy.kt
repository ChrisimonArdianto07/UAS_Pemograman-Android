package com.example.app_catatan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.app_catatan.KoneksiDB.RetrofitService
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditActivitiy : AppCompatActivity() {
    private val api by lazy { RetrofitService().endpoint }
    private lateinit var edTgl: EditText
    private lateinit var edJudul: EditText
    private lateinit var edCatatan: EditText
    //val total1? : ?

    private lateinit var btnEdit: MaterialButton
    private val note by lazy {intent.getSerializableExtra("note") as Read.Data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setupView()
        setupListener()
    }
    private fun setupView(){
        edTgl = findViewById(R.id.et_tgl)
        edJudul = findViewById(R.id.et_Judul)
        edCatatan = findViewById(R.id.et_Catatan)
        btnEdit = findViewById(R.id.btn_simpan)

        edTgl.setText(note.tgl)
        edJudul.setText(note.judul)
        edCatatan.setText(note.catatan)


    }
    private fun setupListener(){

        btnEdit.setOnClickListener{
            api.edit(note.id!!, edJudul.text.toString(), edCatatan.text.toString(),edTgl.text.toString() )
                .enqueue(object : Callback<KirimInputan>{
                    override fun onResponse(
                        call: Call<KirimInputan>,
                        response: Response<KirimInputan>
                    ) {
                        if (response.isSuccessful){
                            val submit = response.body()
                            Toast.makeText(applicationContext,submit!!.pesan,Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<KirimInputan>, t: Throwable) {

                    }

                })
        }
    }
}

