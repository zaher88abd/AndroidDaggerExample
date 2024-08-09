package dev.zaherabd.daggerexample.mainactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.zaherabd.daggerexample.databinding.RecyclerViewListItemBinding
import dev.zaherabd.daggerexample.model.RecyclerData

class RepoRCVAdapter : RecyclerView.Adapter<RepoRCVAdapter.RepoVieHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setUpdateData(listData: List<RecyclerData>) {
        this.listData = listData
    }

    class RepoVieHolder(val bindItem: RecyclerViewListItemBinding) :
        RecyclerView.ViewHolder(bindItem.root) {
        fun bind(data: RecyclerData) {
            this.bindItem.tvName.text = data.name
            this.bindItem.tvDescription.text = data.description
            Glide.with(this.bindItem.avatarImageView).load(data.owner?.avatar_url)
                .apply(RequestOptions.centerCropTransform()).into(this.bindItem.avatarImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoVieHolder {
        val view =
            RecyclerViewListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoVieHolder(view)
    }

    override fun getItemCount(): Int {
        return if (listData == null) 0;
        else listData?.size!!
    }

    override fun onBindViewHolder(holder: RepoVieHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }
}