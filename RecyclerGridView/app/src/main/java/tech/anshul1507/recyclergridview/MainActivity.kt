package tech.anshul1507.recyclergridview

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ListAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item_main.view.*

class MainActivity : AppCompatActivity() {

    private var apiDataList = ArrayList<modelApi>()
    private var groupMap = hashMapOf<Int, List<Int>>()
    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //to add JSON data in list
        apiData()
        //to grouping apiDataList into HashMaps
        groupingData(apiDataList)

        //setting data into grid-recycler view
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = RecyclerAdapter(index, this, groupMap)

    }

    private fun apiData() {
        //June
        apiDataList.add(modelApi("20200601", R.drawable.group_12871))
        //July
        apiDataList.add(modelApi("20200702", R.drawable.group_12871))
        apiDataList.add(modelApi("20200703", R.drawable.group_12871))
        apiDataList.add(modelApi("20200704", R.drawable.group_12871))
        apiDataList.add(modelApi("20200705", R.drawable.group_12871))
        apiDataList.add(modelApi("20200706", R.drawable.group_12871))
        apiDataList.add(modelApi("20200707", R.drawable.group_12871))
        apiDataList.add(modelApi("20200702", R.drawable.group_12871))
        apiDataList.add(modelApi("20200703", R.drawable.group_12871))
        apiDataList.add(modelApi("20200704", R.drawable.group_12871))
        apiDataList.add(modelApi("20200705", R.drawable.group_12871))
        apiDataList.add(modelApi("20200706", R.drawable.group_12871))
        apiDataList.add(modelApi("20200707", R.drawable.group_12871))
        apiDataList.add(modelApi("20200702", R.drawable.group_12871))
        apiDataList.add(modelApi("20200703", R.drawable.group_12871))
        apiDataList.add(modelApi("20200704", R.drawable.group_12871))
        apiDataList.add(modelApi("20200705", R.drawable.group_12871))
        apiDataList.add(modelApi("20200706", R.drawable.group_12871))
        apiDataList.add(modelApi("20200707", R.drawable.group_12871))
        //August
        apiDataList.add(modelApi("20200808", R.drawable.group_12871))
        apiDataList.add(modelApi("20200809", R.drawable.group_12871))
        apiDataList.add(modelApi("20200810", R.drawable.group_12871))
        apiDataList.add(modelApi("20200811", R.drawable.group_12871))
        apiDataList.add(modelApi("20200812", R.drawable.group_12871))
        apiDataList.add(modelApi("20200808", R.drawable.group_12871))
        apiDataList.add(modelApi("20200809", R.drawable.group_12871))
        apiDataList.add(modelApi("20200810", R.drawable.group_12871))
        apiDataList.add(modelApi("20200811", R.drawable.group_12871))
        apiDataList.add(modelApi("20200812", R.drawable.group_12871))
        apiDataList.add(modelApi("20200808", R.drawable.group_12871))
        apiDataList.add(modelApi("20200809", R.drawable.group_12871))
        apiDataList.add(modelApi("20200810", R.drawable.group_12871))
        apiDataList.add(modelApi("20200811", R.drawable.group_12871))
        apiDataList.add(modelApi("20200812", R.drawable.group_12871))
        //Sept
        apiDataList.add(modelApi("20200913", R.drawable.group_12871))
        apiDataList.add(modelApi("20200914", R.drawable.group_12871))
        apiDataList.add(modelApi("20200915", R.drawable.group_12871))
        apiDataList.add(modelApi("20200916", R.drawable.group_12871))
        apiDataList.add(modelApi("20200917", R.drawable.group_12871))
        apiDataList.add(modelApi("20200918", R.drawable.group_12871))
        apiDataList.add(modelApi("20200919", R.drawable.group_12871))
        apiDataList.add(modelApi("20200913", R.drawable.group_12871))
        apiDataList.add(modelApi("20200914", R.drawable.group_12871))
        apiDataList.add(modelApi("20200915", R.drawable.group_12871))
        apiDataList.add(modelApi("20200916", R.drawable.group_12871))
        apiDataList.add(modelApi("20200917", R.drawable.group_12871))
        apiDataList.add(modelApi("20200918", R.drawable.group_12871))
        apiDataList.add(modelApi("20200919", R.drawable.group_12871))
        apiDataList.add(modelApi("20200913", R.drawable.group_12871))
        apiDataList.add(modelApi("20200914", R.drawable.group_12871))
        apiDataList.add(modelApi("20200915", R.drawable.group_12871))
        apiDataList.add(modelApi("20200916", R.drawable.group_12871))
        apiDataList.add(modelApi("20200917", R.drawable.group_12871))
        apiDataList.add(modelApi("20200918", R.drawable.group_12871))
        apiDataList.add(modelApi("20200919", R.drawable.group_12871))

    }

    private fun groupingData(list: ArrayList<modelApi>) {
        var defaultOld: Int = -1
        val tempList: ArrayList<Int> = ArrayList<Int>()
        tempList.clear()
        index = list[0].date.toString().substring(5, 6).toInt()
        for (i in list) {
            if (i.date.toString().substring(5, 6) == defaultOld.toString()) {

                tempList.add(i.score as Int)
            } else {

                if (defaultOld != -1) {
                    groupMap[defaultOld] = tempList.toList()
                    tempList.clear()
                }
                defaultOld = i.date.toString().substring(5, 6).toInt()
                tempList.add(i.score as Int)
            }
        }
        //adding last case in which we have left else loop
        if (tempList.isNotEmpty()) {
            groupMap[defaultOld] = tempList.toList()
        }
    }

    class GridAdapter(mContext: Context, mList: List<Int>) : BaseAdapter() {
        private var list = mList
        private var context: Context? = mContext

        override fun getCount(): Int {
            return list.size
        }

        @SuppressLint("InflateParams", "ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val itemGrid = this.list[position]
            val inflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.item, null, false)

            view.imgItem.setImageResource(itemGrid)

            return view
        }

        override fun getItem(p0: Int): Any {
            return list[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }
    }

    class RecyclerAdapter(idx: Int, mContext: Context, hashList: HashMap<Int, List<Int>>) :
        RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
        private var list = hashList
        private var mIdx = idx
        private var context: Context? = mContext

        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            companion object {
                //layout objects/class objects/keys
            }
        }

        @SuppressLint("InflateParams")
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.item_main, null, false)

            return MyViewHolder(view)
        }

        override fun getItemCount() = list.size

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val idx = mIdx
            val item = list[position + idx] as List<Int>
            val monthsList = mutableListOf ("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec")
            holder.itemView.text_month.text = monthsList[position + idx]
            holder.itemView.gridview.adapter = context?.let { MainActivity2.GridAdapter(it, item) }
        }

    }

}