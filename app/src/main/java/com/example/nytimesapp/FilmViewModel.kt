package com.example.nytimesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimesapp.data.Film
import kotlinx.coroutines.launch

class FilmViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Film>>()
    val items: LiveData<List<Film>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = NewYorkTimesApiImpl.getListOfFilms()
        }
    }
}