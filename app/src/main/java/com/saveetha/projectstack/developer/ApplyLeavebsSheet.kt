package com.saveetha.projectstack.developer

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.saveetha.projectstack.R
import com.saveetha.projectstack.databinding.BsAttendenceListoutBinding
import com.saveetha.projectstack.util.Static
import java.text.Format
import java.text.Normalizer.Form

class AddAddressBottomSheet(): BottomSheetDialogFragment()  {





    private lateinit var activity: FragmentActivity

    @Override
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val view = LayoutInflater.from(context).inflate(R.layout.bs_attendence_listout, null)
        val binding = BsAttendenceListoutBinding.bind(view)
        dialog.setContentView(binding.root)
        activity = requireActivity()


        val form:String = binding.fromDate.text.toString()
        val to:String = binding.toDate.text.toString()
        val numberofdays   :String = binding.daysCount.toString()
        val   leavetype  :String = binding.leaveType.toString()
        val  reason  :String = binding.reason.toString()
        binding.submitButton.setOnClickListener {
            Static.AdminBackStack(activity)
        }
        binding.btnCancel.setOnClickListener {
            Static.AdminBackStack(activity)
        }
        
        return dialog
    }




}