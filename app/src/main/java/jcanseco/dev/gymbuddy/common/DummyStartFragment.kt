package jcanseco.dev.gymbuddy.common

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jcanseco.dev.gymbuddy.R

class DummyStartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dummy_start, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DummyStartFragment()
    }
}