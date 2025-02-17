package com.example.mynavigationdrawer.ui.data_class

data class PostModel(
val nama: String,
val username: String,
val komentar: String,
val like: String,
val retweet: String,
val views: String,
val postText: String,
val profileImage: Int,
val postImage: Int = -1,
) {

}

