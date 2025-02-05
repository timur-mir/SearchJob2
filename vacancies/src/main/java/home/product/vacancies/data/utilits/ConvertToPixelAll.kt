package home.product.vacancies.data.utilits

import android.content.Context
import android.util.DisplayMetrics


    fun convertToPixels(context: Context, nDP: Int): Float {
        var density:Float=0.0f
        var resultValue=0.0f
        when (context.resources.displayMetrics.densityDpi) {
            DisplayMetrics.DENSITY_LOW -> density = 0.75f
            DisplayMetrics.DENSITY_140 -> density = 0.75f
            DisplayMetrics.DENSITY_MEDIUM -> density = 1.0f
            DisplayMetrics.DENSITY_180, DisplayMetrics.DENSITY_200, DisplayMetrics.DENSITY_220 -> density = 1.3f
            DisplayMetrics.DENSITY_HIGH -> {density = 1.5f
            }
            DisplayMetrics.DENSITY_260, DisplayMetrics.DENSITY_280, DisplayMetrics.DENSITY_300 -> {density = 1.6f
            }
            DisplayMetrics.DENSITY_XHIGH -> {density = 2.0f
            }
            DisplayMetrics.DENSITY_340, DisplayMetrics.DENSITY_360, DisplayMetrics.DENSITY_400, DisplayMetrics.DENSITY_420, DisplayMetrics.DENSITY_440 -> {density =
                2.5f
            }
            DisplayMetrics.DENSITY_XXHIGH ->{ density = 3.0f
            }
            DisplayMetrics.DENSITY_560, DisplayMetrics.DENSITY_600 ->{ density = 3.6f
            }
            DisplayMetrics.DENSITY_XXXHIGH -> {density = 4.0f
            }
            //  DisplayMetrics.DENSITY_TV -> density = "TVDPI"
            else -> density = 1.0f
        }
        if(density==1.6f){
            resultValue=(nDP * density*1 + 0.5f).toFloat()
        }
        if(density==2.0f){
            resultValue=(nDP * density*1 + 0.5f).toFloat()
        }
        else if(density==3.0f)
        {
            resultValue=(nDP * density*1 + 0.5f).toFloat()
        }
        else if(density==2.5f)
        {
            resultValue=(nDP * density*1+ 0.5f).toFloat()
        }

        else {
            resultValue=(nDP * 3*2.5 + 0.5f).toFloat()
        }


        return resultValue
    }
//    fun convertToPixels28(context: Context, nDP: Int): Float {
//        val conversionScale:Int = context.resources.displayMetrics.densityDpi
//        return (nDP *conversionScale+ 0.5f).toFloat()
//    }

