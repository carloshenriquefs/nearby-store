package br.com.fiap.myapplication.Activities.Results

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.myapplication.R

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
fun ResultList(id: String = "1", title: String = "result", onBackClick: () -> Unit={}) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.lightBlue))
    ) {
        item {
            TopTitle(title, onBackClick)
        }
        item { Search() }
    }
}
