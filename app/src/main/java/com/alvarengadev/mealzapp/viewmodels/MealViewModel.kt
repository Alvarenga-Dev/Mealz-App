package com.alvarengadev.mealzapp.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.alvarengadev.mealzapp.data.resposes.MealResponse
import com.alvarengadev.mealzapp.repository.MealsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealViewModel (
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {

    private val _mealsState = mutableStateOf(listOf<MealResponse>()) // <- requires init value
    val mealsState: State<List<MealResponse>> = _mealsState // <- keep both variables immutable 'val'
    /* always expose the immutable form of State */

    init {
        CoroutineScope(Dispatchers.IO).launch() {
            _mealsState.value = getMeals()
        }
    }

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}
