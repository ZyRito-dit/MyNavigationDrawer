package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynavigationdrawer.R
import com.example.mynavigationdrawer.ui.data_class.PostModelSemuaNotif
import de.hdodenhof.circleimageview.CircleImageView

class PostAdapterSemuaNotif(
    private val postList: List<PostModelSemuaNotif>,
    private val onItemClick: (PostModelSemuaNotif) -> Unit
) : RecyclerView.Adapter<PostAdapterSemuaNotif.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: CircleImageView = itemView.findViewById(R.id.img_profile_notif)
        val textUsername: TextView = itemView.findViewById(R.id.text_username_notif)
        val txtContent: TextView = itemView.findViewById(R.id.text_content_notif)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_semua_notif, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.profileImage.setImageResource(post.profileimg)
        holder.textUsername.text = post.textusename
        holder.txtContent.text = post.textcontent


        holder.itemView.setOnClickListener {
            onItemClick(post)
        }
    }

    override fun getItemCount() = postList.size
}
