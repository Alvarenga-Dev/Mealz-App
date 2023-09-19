package com.alvarengadev.mealzapp.repository

import com.alvarengadev.mealzapp.data.MealsWebService
import com.alvarengadev.mealzapp.data.resposes.MealResponse
import com.alvarengadev.mealzapp.data.resposes.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    private var cachedMeals = listOf<MealResponse>()
    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealsRepository().also { instance = it }
        }
    }
}
// Project has a objective learning Android Compose
