package com.alvarengadev.mealzapp.repository

import com.alvarengadev.mealzapp.data.MealsWebService
import com.alvarengadev.mealzapp.data.resposes.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}
// Project has a objective learning Android Compose
