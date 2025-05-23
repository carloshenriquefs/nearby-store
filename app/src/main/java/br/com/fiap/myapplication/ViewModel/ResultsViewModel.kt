package br.com.fiap.myapplication.ViewModel

import androidx.lifecycle.LiveData
import br.com.fiap.myapplication.Domain.CategoryModel
import br.com.fiap.myapplication.Domain.StoreModel
import br.com.fiap.myapplication.Repository.ResultsRepository

class ResultsViewModel {
    private val repository = ResultsRepository()

    fun loadSubCategory(id: String): LiveData<MutableList<CategoryModel>> {
        return repository.loadSubCategory(id)
    }

    fun loadPopular(id: String): LiveData<MutableList<StoreModel>> {
        return repository.loadPopular(id)
    }

    fun loadNearest(id: String): LiveData<MutableList<StoreModel>> {
        return repository.loadNearest(id)
    }
}
