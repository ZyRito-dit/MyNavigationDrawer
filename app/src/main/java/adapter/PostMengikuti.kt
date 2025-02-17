package adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynavigationdrawer.R
import com.example.mynavigationdrawer.ui.data_class.PostModelMengikuti
import de.hdodenhof.circleimageview.CircleImageView

class PostMengikuti(private val postmode: List<PostModelMengikuti>) :
    RecyclerView.Adapter<PostMengikuti.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: CircleImageView = itemView.findViewById(R.id.img_profile_mengikuiti)
        val name: TextView = itemView.findViewById(R.id.text_username_mengikuiti)
        val username: TextView = itemView.findViewById(R.id.text_handle_mengikuiti)
        val postText: TextView = itemView.findViewById(R.id.text_post_mengikuiti)
        val postImage: ImageView = itemView.findViewById(R.id.img_post_mengikuti)
        val postVideo: VideoView = itemView.findViewById(R.id.videoPost_mengikuti)
        val btnShare: ImageView = itemView.findViewById(R.id.btn_share_mengikuiti)
        val btnBookmark: ImageView = itemView.findViewById(R.id.btn_bookmark_mengikuiti)
        val btnLike: ImageView = itemView.findViewById(R.id.btn_like_mengikuiti)
        val commentCount: TextView = itemView.findViewById(R.id.commentCount_mengikuiti)
        val retweetCount: TextView = itemView.findViewById(R.id.retweetCount_mengikuiti)
        val likeCount: TextView = itemView.findViewById(R.id.likeCount_mengikuiti)
        val viewCount: TextView = itemView.findViewById(R.id.viewCount_mengikuiti)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_untukmu, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postmode[position]

        holder.name.text = post.nama
        holder.username.text = "@${post.username}"
        holder.postText.text = post.postText
        holder.commentCount.text = post.komentar
        holder.retweetCount.text = post.retweet
        holder.likeCount.text = post.like
        holder.viewCount.text = post.views
        holder.profileImage.setImageResource(post.profileImage)

        // Jika ada gambar, tampilkan. Jika tidak, sembunyikan
        if (post.postImage != 0) {
            holder.postImage.setImageResource(post.postImage)
            holder.postImage.visibility = View.VISIBLE
        } else {
            holder.postImage.visibility = View.GONE
        }

        if (post.postVideo != 0) {
            holder.postVideo.visibility = View.VISIBLE
            val videoUri = Uri.parse("android.resource://${holder.itemView.context.packageName}/${post.postVideo}")
            holder.postVideo.setVideoURI(videoUri)

            val mediaController = MediaController(holder.itemView.context)
            mediaController.setAnchorView(holder.postVideo)
            holder.postVideo.setMediaController(mediaController)

            holder.postVideo.setOnPreparedListener { mp ->
                mp.setOnVideoSizeChangedListener { _, _, _ ->
                    holder.postVideo.start()  // Mulai video setelah siap
                }
            }
        } else {
            holder.postVideo.visibility = View.GONE
        }


        // Event Bookmark
        var isBookmarked = false
        holder.btnBookmark.setOnClickListener {
            isBookmarked = !isBookmarked
            holder.btnBookmark.setColorFilter(
                if (isBookmarked) android.graphics.Color.CYAN
                else android.graphics.Color.WHITE
            )
        }

        // Event Like
        var isLiked = false
        holder.btnLike.setOnClickListener {
            isLiked = !isLiked
            holder.btnLike.setColorFilter(
                if (isLiked) android.graphics.Color.RED
                else android.graphics.Color.WHITE
            )
        }

        // Event Share (Bagikan ke aplikasi lain)
        holder.btnShare.setOnClickListener {
            val context = holder.itemView.context
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${post.username}: ${post.postText}")
                type = "text/plain"
            }
            context.startActivity(Intent.createChooser(shareIntent, "Bagikan postingan via"))
        }
    }

    override fun getItemCount() = postmode.size
}
