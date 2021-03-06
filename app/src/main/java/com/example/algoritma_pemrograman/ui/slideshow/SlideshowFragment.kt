package com.example.algoritma_pemrograman.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.algoritma_pemrograman.R
import com.example.algoritma_pemrograman.databinding.FragmentPerulanganBinding

class SlideshowFragment : Fragment() {

  private lateinit var slideshowViewModel: SlideshowViewModel
private var _binding: FragmentPerulanganBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

    _binding = FragmentPerulanganBinding.inflate(inflater, container, false)
    val root: View = binding.root

    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}