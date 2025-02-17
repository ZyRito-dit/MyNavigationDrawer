package com.example.mynavigationdrawer.ui

import adapter.PostMengikuti
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynavigationdrawer.R
import com.example.mynavigationdrawer.ui.data_class.PostModelMengikuti

class Mengikuti : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:PostMengikuti
    private lateinit var postList: List<PostModelMengikuti>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_mengikuti, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView_mengikuti)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        postList = listOf(
            PostModelMengikuti(
                nama = "Kiana Kaslana",
                username = "@Kiana Chan",
                komentar = "4rb",
                like = "68rb",
                retweet = "7,9rb",
                views = "23jt",
                postText = "Kehidupan Tidak La Seindah Dunia Mimpi, Tapi Kita Harus Tetap Bertahan Di Ke nyataan. :)",
                profileImage = R.drawable.kiana_kaslana,
                postImage = 0,
                postVideo = R.raw.kianaku
            ),
            PostModelMengikuti(
                nama = "MaskFoll",
                username = "@Sparkle",
                komentar = "2,1rb",
                like = "45rb",
                retweet = "5,3rb",
                views = "19jt",
                postText = "Semua Kebohongan akan Terungkap Pada Waktunya, Kecuali Berbohong Demi Kebaikan Yang Benar. He he he ",
                profileImage = R.drawable.sparkle,
                postImage =0,
                postVideo = R.raw.sprklee_x_march
            ),
            PostModelMengikuti(
                nama = "Ruan Mei",
                username = "@RuanMei",
                komentar = "1rb",
                like = "30rb",
                retweet = "3,7rb",
                views = "12jt",
                postText = "\"Manusia melebih-lebihkan ketidakmampuan logika, dan dengan berpegang teguh pada alasan, mereka bisa menjadi budak emosi mereka. Sains lahir dari fanatisme — itu adalah hadiah.\"\n" +
                        "Di sini, Ruan Mei menyoroti paradoks dalam mengandalkan logika dan alasan, serta mengakui bahwa sains sering kali didorong oleh hasrat yang mendalam. ",
                profileImage = R.drawable.ruanmei,
                postImage = R.drawable.ruanmei_post,
                postVideo = 0
            ),
            PostModelMengikuti(
                nama = "Hu Tao",
                username = "@HuuTao",
                komentar = "2jt",
                like = "300rb",
                retweet = "100rb",
                views = "10jt",
                postText = "Hei Guys Im Play May Song, Watching Guys Tengs For My Life",
                profileImage = R.drawable.hutao,
                postImage = 0,
                postVideo = R.raw.hutao_jj
            ),
            PostModelMengikuti(
                nama = "furina",
                username = "@Furina",
                komentar = "230rb",
                like = "300rb",
                retweet = "100rb",
                views = "10jt",
                postText = "Kehidupan Itu Cuma Sesaat Ya Sisanya Tergantung Dirimu, Yang Penting Musik",
                profileImage = R.drawable.furina,
                postImage = 0,
                postVideo = R.raw.furina
            ),
            PostModelMengikuti(
                nama = "furina",
                username = "@Furina",
                komentar = "660rb",
                like = "700rb",
                retweet = "120rb",
                views = "12jt",
                postText = "Musik Kita Part 2, Di Tonton Guys",
                profileImage = R.drawable.waifu3,
                postImage = 0,
                postVideo = R.raw.furina_aether
            ),
            PostModelMengikuti(
                nama = "AetherXCitlali",
                username = "@CitlaliWife",
                komentar = "350rb",
                like = "470rb",
                retweet = "120rb",
                views = "8jt",
                postText = "huy Guys Gua Aether Kali Ini Gua aka Berbagi Moment Indah Bersama Istri Tua Silahkan Di Saksikan",
                profileImage = R.drawable.aether,
                postImage = 0,
                postVideo = R.raw.citlali_aether
            ),
            PostModelMengikuti(
                nama = "wise",
                username = "@Wise",
                komentar = "350rb",
                like = "470rb",
                retweet = "120rb",
                views = "8jt",
                postText = "\"Berhentilah bermain game atau kurangi sampai pada tahap bahwa Anda yakin benar, kehidupan nyata Anda tak terganggu meski Anda bermain game.\"",
                profileImage = R.drawable.wise,
                postImage = R.drawable.wise,
                postVideo = 0
            ),



        )

        adapter = PostMengikuti(postList)
        recyclerView.adapter = adapter


    }
}
