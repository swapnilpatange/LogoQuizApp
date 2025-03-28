package app.phone.machinecoding.bindingadapter

import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import app.phone.machinecoding.baseclasses.BaseRecycleviewAdapter
import phonepemachinecoding.R

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter(
        value = ["tools:data", "tools:itemList", "tools:listener"],
        requireAll = false
    )
    fun <T> setAdapter(
        recyclerView: RecyclerView,
        data: LiveData<List<T>>?,
        @LayoutRes listItem: Int = R.layout.logo_quiz_item,
        listener: Any?
    ) {
        if (recyclerView.adapter == null) {
            recyclerView.adapter = BaseRecycleviewAdapter(
                listItem,
                data?.value ?: ArrayList(),
                listener
            )
        } else {
            if (recyclerView.adapter is BaseRecycleviewAdapter<*>) {
                val items = data?.value ?: ArrayList()
                (recyclerView.adapter as BaseRecycleviewAdapter<T>).updateData(items)
            }
        }
    }
}