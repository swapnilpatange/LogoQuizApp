package app.phone.machinecoding.baseclasses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import phonepemachinecoding.BR

class BaseRecycleviewAdapter<T>(
    @LayoutRes val resource: Int,
    var data: List<T>,
    val listener: Any? = null
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    fun updateData(data: List<T>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflator, resource, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BaseRecycleviewAdapter<*>.MyViewHolder) {
            val item = data.get(position)
            if (item != null)
                holder.setupData(item)
        }
    }

    inner class MyViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setupData(model: Any) {
            binding.setVariable(BR.model, model)
            binding.setVariable(BR.listener, listener)
        }
    }
}