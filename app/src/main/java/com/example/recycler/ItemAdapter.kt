package com.example.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ItemListBinding

class ItemAdapter(var itemList: List<ItemData>,
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private val diffCallback = object : DiffUtil.ItemCallback<ItemData>(){
        override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem.nama == newItem.nama
        }

        override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: List<ItemData>) = differ.submitList(value)

    inner class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*with(holder){
            with(itemList[position]){
                binding.tvNama.text = this.nama
                binding.tvHarga.text = this.harga
            }
        }*/
        val data = differ.currentList[position]

        holder.binding.apply {
            tvNama.text=data.nama
            tvHarga.text=data.harga
        }
        holder.binding.tvHarga.text = data.harga

    }

    /*override fun getItemCount(): Int {
        return itemList.size
    }*/

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}