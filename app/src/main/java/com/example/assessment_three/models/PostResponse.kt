package com.example.assessment_three.models

data class PostResponse(
    var posts:List<Post>,
    var total:Int,
    var skip:Int,
    var limit:Int

)
