package com.example.algoritma_pemrograman.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.algoritma_pemrograman.R
import com.example.algoritma_pemrograman.databinding.FragmentKondisiBinding

class GalleryFragment : Fragment() {

  private lateinit var galleryViewModel: GalleryViewModel
private var _binding: FragmentKondisiBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

    _binding = FragmentKondisiBinding.inflate(inflater, container, false)
    val root: View = binding.root
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}