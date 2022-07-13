package com.graphqldemoapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.exception.ApolloException
import com.graphqldemoapp.CharactersListQuery
import com.graphqldemoapp.repository.CharacterRepository
import com.graphqldemoapp.view.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) :
    ViewModel() {
    val charactersList:
            LiveData<ViewState<ApolloResponse<CharactersListQuery.Data>>>
        get() = _charactersList

        fun queryCharacterList() = viewModelScope.launch {
            _charactersList.postValue(ViewState.Loading())
            try {
                val response = repository.queryCharacterList()
                _charactersList.postValue(ViewState.Success(response))
            }catch (exception: ApolloException){
                Log.d("ApolloException", "Exception: $exception")
                _charactersList.postValue(ViewState.Error("Error fetching character"))
            }
        }
}
private val _charactersList by lazy {
    MutableLiveData<ViewState<ApolloResponse<CharactersListQuery.Data>>>()
}
