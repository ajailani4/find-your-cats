package com.ajailani.kmpexample.di

import com.ajailani.kmpexample.ui.screen.cat_detail.CatDetailViewModel
import com.ajailani.kmpexample.ui.screen.cat_list.CatListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CatListViewModel(get()) }
    viewModel { CatDetailViewModel(get(), get()) }
}