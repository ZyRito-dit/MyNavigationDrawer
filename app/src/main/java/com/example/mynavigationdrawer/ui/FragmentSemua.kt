package com.example.mynavigationdrawer.ui

import adapter.PostAdapterSemuaNotif
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynavigationdrawer.R
import com.example.mynavigationdrawer.ui.data_class.PostModelSemuaNotif

class FragmentSemua : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PostAdapterSemuaNotif
    private lateinit var postList: MutableList<PostModelSemuaNotif>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_semua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView_Semua)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Buat daftar data dummy
        postList = mutableListOf(
            PostModelSemuaNotif(
                profileimg = R.drawable.kiana_kaslana,
                textusename = "@KianaKaslana",
                textcontent = "Hari ini menyenangkan! Terimakasih ya telah menemaniku hari ini 😳"
            ),
            PostModelSemuaNotif(
                profileimg = R.drawable.bronya_zychik,
                textusename = "@BronyaZaychik",
                textcontent = "Besok ada event besar! Temani ku untuk mendapatkan Boneka HomuMomu 😎😎"
            ),
            PostModelSemuaNotif(
                profileimg = R.drawable.raiden_mei,
                textusename = "@MeiRaiden",
                textcontent = "Cuaca hari ini bagus! Mau jalan gak kita hari ini? 😳😳"
            ),
            PostModelSemuaNotif(
                profileimg = R.drawable.raiden_shougun,
                textusename = "@Raiden_Shougun",
                textcontent = "Hei, mau mencoba masakanku hari ini! 😊"
            ),
            PostModelSemuaNotif(
                profileimg = R.drawable.furina,
                textusename = "@Furina_Arc",
                textcontent = "Hei, apakah besok kita pergi ke sekolah?"
            ),
            PostModelSemuaNotif(
                profileimg = R.drawable.anby_demara,
                textusename = "@Anby",
                textcontent = "Ini seperti mi yang hanya menggunakan air biasa sebagai kaldu. Sebagus apa pun bahan tambahan lainnya, rasanya tidak akan begitu enak 🤗"
            ),
                PostModelSemuaNotif(
                    profileimg = R.drawable.raiden_mei,
                textusename = "@MeiRaiden",
                textcontent = "Cuaca hari ini bagus! Mau jalan gak kita hari ini? 😳😳"
            ),
             PostModelSemuaNotif(
            profileimg = R.drawable.raiden_shougun,
            textusename = "@Raiden_Shougun",
            textcontent = "Hei, mau mencoba masakanku hari ini! 😊"
        ),
        PostModelSemuaNotif(
            profileimg = R.drawable.furina,
            textusename = "@Furina_Arc",
            textcontent = "Hei, apakah besok kita pergi ke sekolah?"
        ),
        PostModelSemuaNotif(
            profileimg = R.drawable.anby_demara,
            textusename = "@Anby",
            textcontent = "Ini seperti mi yang hanya menggunakan air biasa sebagai kaldu. Sebagus apa pun bahan tambahan lainnya, rasanya tidak akan begitu enak 🤗"
        )


        )


        adapter = PostAdapterSemuaNotif(postList) { post ->
            Toast.makeText(requireContext(), "Klik: ${post.textusename}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter
    }
}
