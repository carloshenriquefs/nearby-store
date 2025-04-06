package br.com.fiap.myapplication.ViewModel

import androidx.lifecycle.LiveData
import br.com.fiap.myapplication.Domain.CategoryModel

class DashboardViewModel {
    private val repository = DashboardViewModel()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }
}
