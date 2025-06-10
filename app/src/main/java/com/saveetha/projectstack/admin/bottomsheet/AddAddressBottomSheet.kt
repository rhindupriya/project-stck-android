package com.saveetha.projectstack.admin.bottomsheet

import android.os.Bundle
import com.saveetha.projectstack.R


import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.saveetha.projectstack.databinding.BsStudentListBinding

class AddAddressBottomSheet(): BottomSheetDialogFragment()  {

    companion object {
        const val TAG = "AddAddressBottomSheet"
        const val HEADER = "Add Address"
    }

    private lateinit var activity: FragmentActivity

    @Override
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val view = LayoutInflater.from(context).inflate(R.layout.bs_student_list, null)
        val binding = BsStudentListBinding.bind(view)
        dialog.setContentView(binding.root)
        activity = requireActivity()

//        dialog.setOnShowListener {
//            val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
//            bottomSheet?.background = ContextCompat.getDrawable(requireContext(), R.drawable.bottom_sheet_background)
//        }



        return dialog
    }

//    @Override
//    override fun onStart() {
//        super.onStart()
//        dialog?.window?.attributes?.windowAnimations = R.style.BottomSheetAnimation
//    }

}