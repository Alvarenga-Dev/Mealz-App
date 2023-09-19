package com.alvarengadev.mealzapp.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alvarengadev.mealzapp.data.resposes.MealResponse
import com.alvarengadev.mealzapp.repository.MealsRepository

class MealsDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val repository: MealsRepository = MealsRepository.getInstance()

    private val _mealState = mutableStateOf<MealResponse?>(null)
    val mealState: State<MealResponse?> = _mealState

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        _mealState.value = repository.getMeal(mealId)
    }
}
