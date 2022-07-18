package com.example.databaseunderstanding.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databaseunderstanding.model.FixtureItem
import com.example.databaseunderstanding.repository.fixtures.FixtureRepository
import com.example.databaseunderstanding.repository.timeZone.TimeZoneRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val mainRepository: FixtureRepository,
    private val timeZoneRepository: TimeZoneRepository
) : ViewModel() {
    val fixtureData = mutableStateOf<List<FixtureItem>>(listOf())
    val listOfTimeZones = mutableStateOf<List<String>>(listOf())

    val cost = "Cost"
    fun getFixtureData() {
        viewModelScope.launch(Dispatchers.IO) {
            val t = mainRepository.getFixtures()
            fixtureData.value = t
        }
    }

    fun getTimeZones() {
        viewModelScope.launch(Dispatchers.IO) {
            val times = timeZoneRepository.getTimeZones()
            if(times.isNotEmpty()) {
                listOfTimeZones.value = times[0].response
            }
        }
    }
}