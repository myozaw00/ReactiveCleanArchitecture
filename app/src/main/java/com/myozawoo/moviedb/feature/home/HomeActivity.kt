package com.myozawoo.moviedb.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.myozawoo.moviedb.R
import com.myozawoo.moviedb.feature.movie.list.MovieListContainerFragment
import com.myozawoo.moviedb.feature.movie.upcoming.UpComingMovieFragment
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavTransactionOptions
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity(),FragNavController.TransactionListener,
    FragNavController.RootFragmentListener {

    private var fragNavController: FragNavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = arrayListOf<androidx.fragment.app.Fragment>()
        fragments.add(MovieListContainerFragment())
        fragments.add(UpComingMovieFragment())

        fragNavController = FragNavController.newBuilder(savedInstanceState, supportFragmentManager,
            R.id.container
        )
            .rootFragments(fragments)
            .rootFragmentListener(this, 2)
            .defaultTransactionOptions(FragNavTransactionOptions.newBuilder().transition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE).build())
            .build()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.home
        navigation.itemIconTintList = null
    }

    override fun onFragmentTransaction(p0: Fragment?, p1: FragNavController.TransactionType?) {

    }

    override fun onTabTransaction(p0: Fragment?, p1: Int) {

    }

    override fun getRootFragment(p0: Int): Fragment {
        return when(p0){
            0 -> MovieListContainerFragment()
            1 -> UpComingMovieFragment()
            else -> throw IllegalStateException("Need to send right index")
        }
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                fragNavController?.switchTab(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_coming_soon -> {
                fragNavController?.switchTab(1)
                return@OnNavigationItemSelectedListener true
            }


        }
        false
    }
}
