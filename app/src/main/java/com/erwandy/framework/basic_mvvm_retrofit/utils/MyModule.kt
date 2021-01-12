package com.erwandy.framework.basic_mvvm_retrofit.utils

import com.erwandy.framework.basic_mvvm_retrofit.data.repository.InfoRepository
import com.erwandy.framework.basic_mvvm_retrofit.ui.main.viewmodel.InfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    viewModel { InfoViewModel(get()) }
}

val repoModule = module {
    single { InfoRepository() }
}