package com.example.app_catatan


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app_catatan.KoneksiDB.RetrofitService
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val api by lazy { RetrofitService().endpoint}
    private lateinit var viewAdater: MainAdapter
    private lateinit var listNote: RecyclerView
    private lateinit var btnTambah : ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupList()
        setupListener()

    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun setupView() {
        listNote = findViewById(R.id.recyclerView)
        btnTambah = findViewById(R.id.btn_tambah)
    }

    private fun setupListener() {
        btnTambah.setOnClickListener {
            startActivity(Intent(this,CreateActivity::class.java))
        }
    }

    private fun setupList() {
        viewAdater = MainAdapter(arrayListOf(), object : MainAdapter.OnAdapterListener{
            override fun onUpdate(hasil: Read.Data) {
                startActivity(
                    Intent(this@MainActivity,EditActivitiy::class.java)
                        .putExtra("note",hasil)
                )
            }

            override fun onDelete(hasil: Read.Data) {
                api.hapus(hasil.id!!)
                    .enqueue(object : Callback<KirimInputan>{
                        override fun onResponse(
                            call: Call<KirimInputan>,
                            response: Response<KirimInputan>
                        ) {
                            if (response.isSuccessful){
                                val submit = response.body()
                                Toast.makeText(applicationContext,submit!!.pesan, Toast.LENGTH_SHORT).show()
                                getData()
                            }
                        }

                        override fun onFailure(call: Call<KirimInputan>, t: Throwable) {
                        }

                    })
            }

        })
        listNote.adapter = viewAdater
    }

    private fun getData() {
        api.data().enqueue(object : Callback<Read> {
            override fun onResponse(call: Call<Read>, response: Response<Read>) {
                if (response.isSuccessful) {
                    val listData = response.body()!!.hasil

                    //menampilkan data mysql di layout
                    viewAdater.setData(listData)

                }
            }

            override fun onFailure(call: Call<Read>, t: Throwable) {
                Log.e("MainActivity-Log", t.toString())
            }

        })
    }
}