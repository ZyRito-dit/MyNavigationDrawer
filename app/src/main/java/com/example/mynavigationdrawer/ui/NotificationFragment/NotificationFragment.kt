package com.example.mynavigationdrawer.ui.NotificationFragment

import adapter.NotificationsAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.example.mynavigationdrawer.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class NotificationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_notofication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layouttab: TabLayout = view.findViewById(R.id.tabLayout)
        val viewPager: ViewPager2 = view.findViewById(R.id.view_pager)

        val adapter = NotificationsAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(layouttab, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "SEMUA"
                1 -> "TEVERIVIKASI"
                2 -> "SEBUTAN"

                else -> ""
            }
        }.attach()

        return
    }
}