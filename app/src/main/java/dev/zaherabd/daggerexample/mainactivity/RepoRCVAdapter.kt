package dev.zaherabd.daggerexample.mainactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.zaherabd.daggerexample.R
import dev.zaherabd.daggerexample.model.RecycleData
import dev.zaherabd.daggerexample.model.RecycleList
import kotlinx.android.synthetic.main.recycler_view_list_item.view.avatarImageView
import kotlinx.android.synthetic.main.recycler_view_list_item.view.tvDescription
import kotlinx.android.synthetic.main.recycler_view_list_item.view.tvName
import okhttp3.Request

class RepoRCVAdapter : RecyclerView.Adapter<RepoRCVAdapter.RepoVieHolder>() {

    private var listData: List<RecycleData>? = null

    fun setUpdateData(listData: List<RecycleData>) {
        this.listData = listData
    }

    class RepoVieHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.avatarImageView
        val tvName = view.tvName
        val tvDesc = view.tvDescription
        fun bind(data: RecycleData) {
            tvName.text = data.name
            tvDesc.text = data.description
            Glide.with(imageView).load(data.owner?.avatar_url)
                .apply(RequestOptions.centerCropTransform()).into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoVieHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_list_item, parent, false)
        return RepoVieHolder(view)
    }

    override fun getItemCount(): Int {
        if (listData == null) return 0;
        else return listData?.size!!
    }

    override fun onBindViewHolder(holder: RepoVieHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }
}