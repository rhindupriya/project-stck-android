package com.saveetha.projectstack.util

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.saveetha.projectstack.R

object Static {

    private fun getAdminNavHostFragment(activity: FragmentActivity): NavHostFragment {
        return activity.supportFragmentManager.findFragmentById(R.id.adminNavContainer) as NavHostFragment
    }

    fun getAdminNavController(activity: FragmentActivity): NavController {
        return getAdminNavHostFragment(activity).navController
    }

    fun adminNavigate(activity: FragmentActivity, action: Int, bundle: Bundle? = null) {
        if (bundle == null) getAdminNavController(activity).navigate(action)
        else getAdminNavController(activity).navigate(action, bundle)
    }

    fun AdminBackStack(activity: FragmentActivity) {
        getAdminNavController(activity).popBackStack()
    }

    private fun getdeveloperNavHostFragment(activity: FragmentActivity): NavHostFragment {
        return activity.supportFragmentManager.findFragmentById(R.id.developerNavContainer) as NavHostFragment
    }

    fun getdeveloperNavController(activity: FragmentActivity): NavController {
        return getdeveloperNavHostFragment(activity).navController
    }

    fun developerNavigate(activity: FragmentActivity, action: Int, bundle: Bundle? = null) {
        if (bundle == null) getdeveloperNavController(activity).navigate(action)
        else getdeveloperNavController(activity).navigate(action, bundle)
    }

    fun developerBackStack(activity: FragmentActivity) {
        getdeveloperNavController(activity).popBackStack()
    }

    private fun getuserNavHostFragment(activity: FragmentActivity): NavHostFragment {
        return activity.supportFragmentManager.findFragmentById(R.id.userNavContainer) as NavHostFragment
    }

    fun getuserNavController(activity: FragmentActivity): NavController {
        return getuserNavHostFragment(activity).navController
    }

    fun userNavigate(activity: FragmentActivity, action: Int, bundle: Bundle? = null) {
        if (bundle == null) getdeveloperNavController(activity).navigate(action)
        else getuserNavController(activity).navigate(action, bundle)
    }

    fun userBackStack(activity: FragmentActivity) {
        getuserNavController(activity).popBackStack()
    }
}