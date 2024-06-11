package com.example.tec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tec.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var adapter: WordsAdapter;
    private val wordsData = mutableListOf<Datum>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAll()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = WordsAdapter(wordsData)
        binding.rvWords.layoutManager = LinearLayoutManager(this)
        binding.rvWords.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/api/words/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getAll() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getAll("")
            val obj = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val data = obj?.data ?: emptyList()
                    wordsData.clear()
                    wordsData.addAll(data)
                    adapter.notifyDataSetChanged()
                } else {
                    //show error
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}
