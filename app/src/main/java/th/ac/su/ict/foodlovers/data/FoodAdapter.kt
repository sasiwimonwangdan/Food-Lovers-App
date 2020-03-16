package th.ac.su.ict.foodlovers.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.list_item_food.view.*
import th.ac.su.ict.foodlovers.R
import java.util.zip.Inflater
import javax.sql.CommonDataSource

class FoodAdapter(private val context: Context,
                  private  val dataSource:ArrayList<Food>) : BaseAdapter() {

    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.list_item_food, null)

        rowView.tvTitle.text = dataSource[position].foodName
        rowView.tvSubtitle.text = dataSource[position].description
        rowView.tvDetail.text = dataSource[position].price.toString()

        val res = context.resources
        val drawableId:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)
        val drawableId2:Int = res.getIdentifier(dataSource[position].reviewScore,"drawable",context.packageName)

        rowView.imgThumbnail.setImageResource(drawableId)
        rowView.reviewScore.setImageResource(drawableId2)


        return  rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getCount(): Int {

        return dataSource.size
    }
}