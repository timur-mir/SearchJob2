package home.product.favorite.presentation.utils

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class ItemOffsetDecoration(private val context: Context): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val offset = 8.fromDpToPixels(context)

        with(outRect) {
            left = 0
            top = offset
            bottom = offset
            right = 0
        }
    }

    companion object {
       fun Int.fromDpToPixels(context: Context): Int {
            val density = context.resources.displayMetrics.densityDpi
            val pixelInDp = density / DisplayMetrics.DENSITY_DEFAULT
            return this * pixelInDp
        }
    }
}
