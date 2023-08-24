package com.example.assessment_three.ui.theme.UI

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assessment_three.ViewModels.PostViewModel
import com.example.assessment_three.ui.theme.Assessment_threeTheme

class MainActivity : ComponentActivity() {
    val postViewModel: PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var productAdapter: ProductsAdapter
    var productList: List<Products> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productAdapter = ProductsAdapter(emptyList())

    }

    override fun onResume() {
        super.onResume()
        productViewModel.fetchProduct()
        productViewModel.productsLiveData.observe(this, Observer { productList->
            var productAdapter = ProductsAdapter(productList ?: emptyList())
            binding.rvProducts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvProducts.adapter = productAdapter
            Toast.makeText(
                baseContext,
                "fetched ${productList?.size} products",
                Toast.LENGTH_LONG
            ).show()
        })
        productViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG)
                .show()
        })
    }
}