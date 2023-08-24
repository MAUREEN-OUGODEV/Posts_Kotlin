package com.example.assessment_three.models





import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment_three.dataBinding.PostListsBinding



class PostAdapter (var postList:List<Post>):RecyclerView.Adapter<PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder{
        val binding =PostListsBinding .inflate(LayoutInflater.from(parent.context),parent ,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentProduct =postList[position]
        var  binding=holder.binding
//        binding.tvId.text=currentProduct.id.toString()
//        binding.tvTitle.text=currentProduct.title.toString()
//        binding.tvDescription.text=currentProduct.description.toString()
//        binding.tvPrice.text=currentProduct.price.toString()
//        binding.tvRating.text=currentProduct.rating.toString()
//        binding.tvStock.text=currentProduct.stock.toString()
//        binding.tvCategory.text=currentProduct.category.toString()


    }
    override fun getItemCount(): Int {
        return postList.size
    }
}
class PostViewHolder( var binding:PostListsBinding): RecyclerView.ViewHolder(binding.root)

