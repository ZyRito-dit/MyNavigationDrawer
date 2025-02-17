package adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mynavigationdrawer.ui.Mengikuti
import com.example.mynavigationdrawer.ui.UntukMu

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UntukMu()
            1 -> Mengikuti()
            else -> UntukMu()
        }
    }
}
