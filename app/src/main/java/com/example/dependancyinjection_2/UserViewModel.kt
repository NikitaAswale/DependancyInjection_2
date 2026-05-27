package com.example.dependancyinjection_2

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor( userRepository: UserRepository) : ViewModel(){

    val character : Flow<PagingData<Result>> = userRepository.getPosts()


    }