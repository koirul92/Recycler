package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var itemList: List<ItemData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadLanguage()

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        // pass it to rvLists layoutManager
        binding.rvList.setLayoutManager(layoutManager)

        // initialize the adapter,
        // and pass the required argument
        itemAdapter = ItemAdapter(itemList)

        // attach adapter to the recycler view
        binding.rvList.adapter = itemAdapter
    }

    // add items to the list manually in our case
    private fun loadLanguage() {

        itemList = listOf(
            ItemData("Sepatu Air Jordan" , "Rp. 2.000.000"),
            ItemData("Sempak Calvin Klein" , "Rp. 1.800.000"),
            ItemData("Jaket Balenciaga" , "Rp. 1.200.000"),
            ItemData("Handuk Gucci KW" , "Rp. 60.000"),
            ItemData("Keset Welcome" , "Rp. 40.000"),
            ItemData("Janji Manismu" , "Rp. 0.000.000"),
        )
        itemAdapter.submitData(itemList)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
