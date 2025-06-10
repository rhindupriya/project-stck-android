package com.saveetha.projectstack.developer

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.saveetha.projectstack.R
import com.saveetha.projectstack.databinding.BsAddtaskListoutBinding
import com.saveetha.projectstack.util.Static

class ApplytaskbsSheet(): BottomSheetDialogFragment()  {
    private lateinit var activity: FragmentActivity

    @Override
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val view = LayoutInflater.from(context).inflate(R.layout.bs_addtask_listout, null)
        val binding = BsAddtaskListoutBinding.bind(view)
        dialog.setContentView(binding.root)
        activity = requireActivity()

        val registrationId:String = binding.etRegistrationId.text.toString()
        val Studentname:String = binding.etStudentName.text.toString()
        val projectname   :String = binding.etProjectName.toString()
        val   task  :String = binding.ettask.toString()


        binding.submitButton.setOnClickListener {

        }
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        return dialog
    }

}