package br.com.fiap.myapplication.Activities.Results

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.myapplication.Domain.CategoryModel
import br.com.fiap.myapplication.Domain.StoreModel
import br.com.fiap.myapplication.R
import br.com.fiap.myapplication.ViewModel.ResultsViewModel

class ResultsActivity : AppCompatActivity() {
    private var id: String = ""
    private var title: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        id = intent.getStringExtra("id") ?: ""
        title = intent.getStringExtra("title") ?: ""

        setContent {
            ResultList(id, title, onBackClick = { finish() })
        }
    }
}

@Preview
@Composable
fun ResultList(id: String = "1", title: String = "result", onBackClick: () -> Unit = {}) {

    val viewModel = ResultsViewModel()

    val subCategory = remember { mutableStateListOf<CategoryModel>() }

    val popular = remember { mutableStateListOf<StoreModel>() }

    var showsubCategoryLoading by remember { mutableStateOf(true) }
    var showPopularLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        viewModel.loadSubCategory(id).observeForever {
            subCategory.clear()
            subCategory.addAll(it)
            showsubCategoryLoading = false
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadPopular(id).observeForever {
            popular.clear()
            popular.addAll(it)
            showPopularLoading = false
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.lightBlue))
    ) {
        item {
            TopTitle(title, onBackClick)
        }
        item { Search() }
        item { SubCategorySection(subCategory, showsubCategoryLoading) }
        item { PopularSection(popular, showPopularLoading) }
    }
}
