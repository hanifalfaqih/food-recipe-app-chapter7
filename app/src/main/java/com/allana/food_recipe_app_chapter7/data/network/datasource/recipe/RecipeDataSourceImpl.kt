package com.allana.food_recipe_app_chapter7.data.network.datasource.recipe

import com.allana.food_recipe_app_chapter7.data.model.response.recipe.Recipe
import com.allana.food_recipe_app_chapter7.data.model.response.recipe.RecipeResponse
import com.allana.food_recipe_app_chapter7.data.model.response.recipe.detail.RecipeDetailResponse
import com.allana.food_recipe_app_chapter7.data.network.services.RecipeApiService
import retrofit2.Call
import javax.inject.Inject

class RecipeDataSourceImpl @Inject constructor(private val recipeApiService: RecipeApiService) :
    RecipeDataSource {

    override suspend fun getAllRecipes(): RecipeResponse {
        return recipeApiService.getAllRecipes()
    }

    override suspend fun getRecipeDetail(recipeId: Long): RecipeDetailResponse {
        return recipeApiService.getRecipeDetail(recipeId)
    }

}