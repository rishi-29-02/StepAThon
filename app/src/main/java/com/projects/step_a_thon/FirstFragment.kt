package com.projects.step_a_thon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.projects.step_a_thon.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    companion object {
        fun newInstance(pos:Int) : FirstFragment {
            val fragment = FirstFragment()
            val bundle = Bundle().apply {
                putInt("pos", pos)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        init()

        return binding.root
    }

    private fun init(){
        setGIFs()
        val position = arguments?.getInt("pos")
        setUI(position)
    }

    private fun setUI(position: Int?) {
        when (position) {
            0 -> {
                binding.ivCurrent.setImageResource(R.drawable.group_1)
                binding.ivNext.setImageResource(R.drawable.group_2)
                binding.ivShine.visibility  =View.INVISIBLE
                binding.tvHeader.text = getString(R.string.step_up)
                binding.tvSubHeader.text = "Join the Race, Lace Up, and\n Embrace Health!"
            }
            1 -> {
                binding.ivCurrent.setImageResource(R.drawable.group_2)
                binding.ivNext.setImageResource(R.drawable.group_3)
                binding.tvHeader.text = getString(R.string.claim)
                binding.tvSubHeader.text = "Compete with your colleagues for Top\n Ranks"
                binding.ivShine.visibility  =View.VISIBLE
            }
            2 -> {
                binding.ivCurrent.setImageResource(R.drawable.group_3)
                binding.ivNext.visibility = View.INVISIBLE
                binding.ivShine.visibility = View.VISIBLE
                binding.tvHeader.text = getString(R.string.score_big)
                binding.tvSubHeader.text = "Victory Unlocks Spectacular Vouchers,\n Cashbacks, and Beyond"
            }
        }
    }

    private fun setGIFs() {
        Glide.with(this)
            .asGif()
            .load(R.drawable.stars)
            .into(binding.ivStars1)

        Glide.with(this)
            .asGif()
            .load(R.drawable.stars)
            .into(binding.ivStars2)
    }
}