package com.werockstar.tourandroid.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.werockstar.tourandroid.data.remote.User
import com.werockstar.tourandroid.databinding.ItemRowBinding

class HomeAdapter(private val users: List<User>, val onItemDidTap: (url: String) -> Unit) :
	RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

	class HomeViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
		fun bind(user: User, onItemDidTap: (url: String) -> Unit) {
			binding.ivUser.load(user.url)
			binding.tvUser.text = user.user
			binding.root.setOnClickListener { onItemDidTap(user.pageUrl) }
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
		val view = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return HomeViewHolder(view)
	}

	override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
		val user = users[position]
		holder.bind(user) { onItemDidTap(it) }
	}

	override fun getItemCount(): Int = users.size
}
