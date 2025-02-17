package com.example.mynavigationdrawer.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynavigationdrawer.R
import com.example.mynavigationdrawer.ui.data_class.PostModel
import de.hdodenhof.circleimageview.CircleImageView

class PostAdapter(private val postList: ArrayList<PostModel>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: CircleImageView = itemView.findViewById(R.id.img_profile)
        val name: TextView = itemView.findViewById(R.id.text_username)
        val username: TextView = itemView.findViewById(R.id.text_handle)
        val postText: TextView = itemView.findViewById(R.id.text_post)
        val postImage: ImageView = itemView.findViewById(R.id.img_post)
        val btnshare: ImageView = itemView.findViewById(R.id.btn_share)
        val btnbookmark: ImageView = itemView.findViewById(R.id.btn_bookmark)
        val btnlike: ImageView = itemView.findViewById(R.id.btn_like)
        val momentary: TextView = itemView.findViewById(R.id.commentCount)
        val retweet: TextView = itemView.findViewById(R.id.retweetCount)
        val like: TextView = itemView.findViewById(R.id.likeCount)
        val views: TextView = itemView.findViewById(R.id.viewCount)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]

        holder.name.text = post.nama
        holder.username.text = "@${post.username}"
        holder.postText.text = post.postText
        holder.momentary.text = post.komentar
        holder.retweet.text = post.retweet
        holder.like.text = post.like
        holder.views.text = post.views
        holder.profileImage.setImageResource(post.profileImage)






        if (post.postImage != 0) {
            holder.postImage.setImageResource(post.postImage)
            holder.postImage.visibility = View.VISIBLE
        } else {
            holder.postImage.visibility = View.GONE
        }

        var isBookmarked = false

        holder.btnbookmark.setOnClickListener {
            if (!isBookmarked) {
                holder.btnbookmark.setColorFilter(android.graphics.Color.CYAN)
                isBookmarked = true
            } else {
                holder.btnbookmark.setColorFilter(android.graphics.Color.WHITE) // Ganti dengan warna default
                isBookmarked = false
            }
        }

        var isLikepro = false

        holder.btnlike.setOnClickListener {
            if (!isLikepro){
                holder.btnlike.setColorFilter(android.graphics.Color.RED)
                isLikepro = true
            } else {
                holder.btnlike.setColorFilter(android.graphics.Color.WHITE)
                isLikepro = false
            }
        }

        // Event Share (Bagikan ke aplikasi lain)
        holder.btnshare.setOnClickListener {
            val context = holder.itemView.context
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${post.username}: ${post.postText}")
                type = "text/plain"
            }
            context.startActivity(Intent.createChooser(shareIntent, "Bagikan postingan via"))
        }


    }

    override fun getItemCount() = postList.size

    }




