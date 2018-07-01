package com.ouweibin.interview.features.main.view


import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ouweibin.interview.R
import com.ouweibin.interview.core.exception.Failure
import com.ouweibin.interview.core.extension.failure
import com.ouweibin.interview.core.extension.observe
import com.ouweibin.interview.core.extension.viewModel
import com.ouweibin.interview.core.platform.BaseFragment
import com.ouweibin.interview.features.main.adapter.CityGuideAdapter
import com.ouweibin.interview.features.main.bean.CityGuide
import com.ouweibin.interview.features.main.viewmodel.CityGuideViewModel
import kotlinx.android.synthetic.main.fragment_city_guide.*

class CityGuideFragment : BaseFragment(){

    private var isLoadMoreCityGuide:Boolean = false

    private lateinit var cityGuideViewModel: CityGuideViewModel
    override fun layoutId(): Int = R.layout.fragment_city_guide

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityGuideViewModel = viewModel(CityGuideViewModel.CityGuideViewModelFactory()) {
            observe(cityGuides, ::renderCityGuideList)
            observe(moreCityGuides, ::renderMoreCityGuideList)
            failure(failure, ::handleFailure)
        }
        initRecyclerView()
        initRefreshView()

        loadCityGuides()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CityGuideAdapter()
    }

    private fun initRefreshView() {
        refreshLayout.setOnRefreshListener { layout ->
            isLoadMoreCityGuide = false
            layout.finishRefresh()
            loadCityGuides()
//            (recyclerView.adapter as CityGuideAdapter).updateData(arrayListOf(CityGuide("ojo", "ohj")))
        }
        refreshLayout.setOnLoadMoreListener { layout ->
            isLoadMoreCityGuide = true
            layout.finishLoadMore()
//            (recyclerView.adapter as CityGuideAdapter).addData(arrayListOf(CityGuide("ijo")))
            loadMoreCityGuides()
        }
    }

    /**
     * 首次加载数据
     */
    private fun loadCityGuides() {
        cityGuideViewModel.loadCityGuides()
    }

    private fun loadMoreCityGuides() {
        cityGuideViewModel.loadMoreCityGuides()
    }

    private fun renderCityGuideList(cityGuides: List<CityGuide>?) {
//        (recyclerView.adapter as CityGuideAdapter).updateData(arrayListOf(CityGuide("ojo", "ohj")))
        (recyclerView.adapter as CityGuideAdapter).updateData(cityGuides ?: emptyList())
    }

    private fun renderMoreCityGuideList(cityGuides: List<CityGuide>?) {
//        (recyclerView.adapter as CityGuideAdapter).addData(arrayListOf(CityGuide("ijo")))
        (recyclerView.adapter as CityGuideAdapter).addData(cityGuides ?: emptyList())
    }

    private fun handleFailure(failure: Failure?) {
        if (isLoadMoreCityGuide) {
            refreshLayout.finishRefresh()
        } else {
            refreshLayout.finishLoadMore()
        }
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
        }
    }

    private fun renderFailure(@StringRes msg: Int) {
        notify(msg)
    }
}
