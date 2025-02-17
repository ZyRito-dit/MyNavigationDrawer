package adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mynavigationdrawer.ui.FagmentTerverifikasi
import com.example.mynavigationdrawer.ui.FragmentSebutan
import com.example.mynavigationdrawer.ui.FragmentSemua

class NotificationsAdapter (fragment: Fragment) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int = 3


    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> FragmentSemua()
            1 -> FagmentTerverifikasi()
            2 -> FragmentSebutan()
            else -> FragmentSemua()
        }
    }

}