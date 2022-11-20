package com.example.azcar.screens.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.azcar.R
import com.example.azcar.adapters.QuraanAdapter
import com.example.azcar.adapters.QuraanListener
import com.example.azcar.database.DataBase
import com.example.azcar.databinding.FragmentMainBinding
import com.example.azcar.model.Surah
import javax.sql.DataSource

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
//    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//region DECLIRATION
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        val application = requireNotNull(this.activity).application
//        val dataSource = DataBase.getInstance(application).dataSource
//        viewModelFactory = ViewModelFactory(dataSource)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.qraanList.adapter = QuraanAdapter(QuraanListener())

//endregion



        return binding.root
    }





}