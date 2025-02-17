package com.example.mynavigationdrawer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynavigationdrawer.R
import com.example.mynavigationdrawer.ui.adapter.PostAdapter
import com.example.mynavigationdrawer.ui.data_class.PostModel

class UntukMu : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PostAdapter
    private lateinit var postList: ArrayList<PostModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_untuk_mu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView_untuk_mu)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        postList = getListPost()
        adapter = PostAdapter(postList)
        recyclerView.adapter = adapter
    }

    private fun getListPost(): ArrayList<PostModel> {
        val nama = resources.getStringArray(R.array.data_nameprofile)
        val username = resources.getStringArray(R.array.data_nameGmail)
        val komentar = resources.getStringArray(R.array.data_commentcount)
        val like = resources.getStringArray(R.array.data_likecount)
        val retweet = resources.getStringArray(R.array.data_retretcount)
        val views = resources.getStringArray(R.array.data_read)
        val postText = resources.getStringArray(R.array.data_titlepost)
        val profileImage = resources.obtainTypedArray(R.array.gambar_profile)
        val postImage = resources.obtainTypedArray(R.array.gambar_post)

        val listPost = ArrayList<PostModel>()
        for (i in nama.indices) {
            val post = PostModel(
                nama[i],
                username[i],
                komentar[i],
                like[i],
                retweet[i],
                views[i],
                postText[i],
                profileImage.getResourceId(i, -1),
                postImage.getResourceId(i, -1)
            )
            listPost.add(post)
        }

        profileImage.recycle()
        postImage.recycle()

        return listPost
    }
}
