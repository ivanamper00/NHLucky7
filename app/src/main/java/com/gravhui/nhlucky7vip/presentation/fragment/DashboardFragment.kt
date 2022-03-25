package com.gravhui.nhlucky7vip.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.ui.base.BaseFragment
import com.dakuinternational.common.ui.binding.viewBinding
import com.dakuinternational.common.ui.utils.writeLog
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gravhui.nhlucky7vip.R
import com.gravhui.nhlucky7vip.databinding.FragmentDashboardBinding
import com.gravhui.nhlucky7vip.presentation.adapter.DashboardAdapter
import java.lang.reflect.Type


class DashboardFragment : BaseFragment(R.layout.fragment_dashboard) {

    private val binding by viewBinding(FragmentDashboardBinding::bind)

    private val args: DashboardFragmentArgs by navArgs()

    private val dashboardAdapter by lazy {
        DashboardAdapter(requireActivity() as DashboardAdapter.OnItemClickListener)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.recyclerView){
            adapter = dashboardAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        val list: List<DataContent> = Gson().fromJson(args.listContent, object:TypeToken<List<DataContent>>(){}.type)
        dashboardAdapter.setList(list)
    }

    companion object{
        const val LIST_CONTENT = "listContent"
    }
}