package com.example.assessment_three.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment_three.models.Post
import com.example.assessment_three.repository.postRepository
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    val productsRepo=postRepository()
    val postLiveData = MutableLiveData<List<Post>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchPost(){
        viewModelScope.launch {
            val response =postRepository.getPost()
            if(response.isSuccessful){
                postLiveData.postValue(response.body()?.products)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }

        }
    }
}