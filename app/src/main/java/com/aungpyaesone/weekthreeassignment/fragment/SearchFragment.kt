package com.aungpyaesone.weekthreeassignment.fragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi

import com.aungpyaesone.weekthreeassignment.R
import com.aungpyaesone.weekthreeassignment.adapter.TopSearchAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.bottom_sheet_item_view.*
import kotlinx.android.synthetic.main.fragment_search.*
import java.text.DateFormatSymbols
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SearchFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etCheckIn.setOnClickListener {
          callDatePickerDialog(etCheckIn)
        }
        etCheckOut.setOnClickListener {
            callDatePickerDialog(etCheckOut)
        }

        val pagerAdapter = TopSearchAdapter()
        viewPager.adapter = pagerAdapter

        btnFilter.setOnClickListener {
            val bottomSheetFragment = FilterBottomSheetFragment()
            bottomSheetFragment.show(activity!!.supportFragmentManager,bottomSheetFragment.tag)

            }


    }

    fun callDatePickerDialog(etText:EditText){
        val calendar = Calendar.getInstance()
        val day = calendar[Calendar.DAY_OF_MONTH]
        val month = calendar[Calendar.MONTH]
        val year = calendar[Calendar.YEAR]

        // date picker
        val datePicker =
            activity?.let { it1 ->
                DatePickerDialog(it1, DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
                    val customFormat = month.toMonthName()
                    etText.setText(dayOfMonth.toString()+" "+ customFormat + ", " + year)
                },year,month,day)
            }
        datePicker?.show()
    }

    fun Int.toMonthName():String{
        val montName = DateFormatSymbols().months[this]
        return montName.take(3)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
   //     listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
       // listener = null
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
