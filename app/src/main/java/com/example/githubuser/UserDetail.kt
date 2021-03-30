package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubuser.databinding.ActivityUserDetailBinding

class UserDetail : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    companion object {
        const val EXTRA_USER = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        binding.imgAvatar.setImageResource(user.avatar)
        binding.tvUsername.text = user.username
        binding.tvName.text = user.name
        binding.tvFollowers.text = user.followers
        binding.tvFollowing.text = user.following
        binding.tvRepository.text = user.repository
        binding.tvLocation.text = user.location
        binding.tvCompany.text = user.company
    }
}