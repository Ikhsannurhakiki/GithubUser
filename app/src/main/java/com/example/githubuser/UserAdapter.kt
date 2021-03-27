package com.example.githubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.databinding.ItemUserBinding

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var user = arrayListOf<User>()
    override fun getCount(): Int {
        return user.size
    }

    override fun getItem(i: Int): Any {
        return user[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }


    private inner class ViewHolder internal constructor(view: View) {
        private val binding = ItemUserBinding.bind(view)
        internal fun bind(user: User) {
            binding.txtUsername.text = user.username
            binding.txtCompany.text = user.company
            binding.txtLocation.text = user.location
            binding.imgAvatar.setImageResource(user.avatar)
        }
    }
}
