package com.aungpyaesone.weekthreeassignment.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import com.aungpyaesone.weekthreeassignment.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.bottom_sheet_item_view.*

class FilterBottomSheetFragment: BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_item_view,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtCancel.setOnClickListener {
           dismiss()
        }

        val arrayAdapter = ArrayAdapter.createFromResource(activity!!,R.array.price,android.R.layout.simple_dropdown_item_1line)
        customSpinner.adapter = arrayAdapter


    }




}