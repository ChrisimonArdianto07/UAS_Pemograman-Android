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

class CreateActivity : AppCompatActivity() {

    private val api by lazy { RetrofitService().endpoint }

    private lateinit var inCatatan: EditText
    private lateinit var inTgl: EditText
    private lateinit var inJudul: EditText
    private lateinit var btnSimpan: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        setupView()
        setupListener()
    }

    private fun setupView(){
        inJudul = findViewById(R.id.in_judul)
        inCatatan = findViewById(R.id.in_Catatan)
        inTgl = findViewById(R.id.in_tgl)
        btnSimpan = findViewById(R.id.btn_simpan)

    }

    private fun setupListener(){
        btnSimpan.setOnClickListener{
            if (inCatatan.text.toString().isNotEmpty()){
                //Log.e("CreateActivity",inCatatan.text.toString())
                api.tambah(inJudul.text.toString(),inCatatan.text.toString(),inTgl.text.toString())
                    .enqueue(object :Callback<KirimInputan>{
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

                        override fun onFailure(call: Call<KirimInputan>, t: Throwable) { }
                    })
            }
            else{
                Toast.makeText(applicationContext,"Inputan Tidak Boleh Kosong",Toast.LENGTH_LONG).show()
            }
        }
    }
}