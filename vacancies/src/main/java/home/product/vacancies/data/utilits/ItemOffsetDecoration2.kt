package home.howework.searchjob.Utilts

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import home.howework.searchjob.Utilts.ItemOffsetDecoration.Companion.fromDpToPixels

class ItemOffsetDecoration2 (private val context: Context): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val offset = 4.fromDpToPixels(context)
        val position = parent.getChildAdapterPosition(view)
        val last = position==state.itemCount-1
        if (position==0){
            with(outRect) {
                left = 0
                top = offset
                bottom = offset
                right = offset
            }
        }
        if(last)
        {
            with(outRect) {
                left = offset
                top = offset
                bottom = offset
                right = 0
            }
        }
        with(outRect) {
            left = offset
            top = offset
            bottom = offset
            right = offset
        }
    }
}