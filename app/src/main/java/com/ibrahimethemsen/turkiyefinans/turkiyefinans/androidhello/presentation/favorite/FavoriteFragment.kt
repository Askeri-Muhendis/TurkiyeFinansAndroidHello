package com.ibrahimethemsen.turkiyefinans.turkiyefinans.androidhello.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ibrahimethemsen.turkiyefinans.turkiyefinans.androidhello.adapter.LibraryAdapter
import com.ibrahimethemsen.turkiyefinans.turkiyefinans.androidhello.databinding.FragmentFavoriteBinding
import com.ibrahimethemsen.turkiyefinans.turkiyefinans.androidhello.presentation.library.data.favoriteList
import com.ibrahimethemsen.turkiyefinans.turkiyefinans.androidhello.utility.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val libraryAdapter = LibraryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }
    private fun setAdapter(){
        if (favoriteList.distinct().isEmpty()){
            binding.favoriteRv.visibility = View.GONE
            binding.favoriteEmptyList.visibility = View.VISIBLE
        }else{
            binding.favoriteRv.visibility = View.VISIBLE
            binding.favoriteEmptyList.visibility = View.GONE
            libraryAdapter.updateList(favoriteList.distinct())
        }
        libraryAdapter.setDetailClickBook(::toDetailFragment)
        binding.favoriteRv.adapter = libraryAdapter
    }
    private fun toDetailFragment(bookId : Int){
        val action = FavoriteFragmentDirections.actionFavoriteFragmentToBookDetailFragment(
            bookId,
            Constants.START_FAVORITE
        )
        findNavController().navigate(action)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}