package br.com.fiap.myapplication.ViewModel

import androidx.lifecycle.LiveData
import br.com.fiap.myapplication.Domain.CategoryModel
import br.com.fiap.myapplication.Repository.ResultsRepository

class ResultsViewModel {
    private val repository = ResultsRepository()

    fun loadSubCategory(id: String): LiveData<MutableList<CategoryModel>> {
        return repository.loadSubCategory(id)
    }
}
