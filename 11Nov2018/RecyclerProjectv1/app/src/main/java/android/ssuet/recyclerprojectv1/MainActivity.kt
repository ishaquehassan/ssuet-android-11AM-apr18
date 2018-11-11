package android.ssuet.recyclerprojectv1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //myRecyclerList.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        /*myRecyclerList.layoutManager = GridLayoutManager(this,2)
        myRecyclerList.adapter = MyRvAdapter(R.layout.item_view_grid,arrayListOf(
            "Item 1","Item 2","Item 3","Item 4","Item 1","Item 2","Item 3","Item 4","Item 1","Item 2","Item 3","Item 4","Item 1","Item 2","Item 3","Item 4"
        ),::onItemClick)*/

        myRecyclerList.layoutManager = StaggeredGridLayoutManager(3,LinearLayout.VERTICAL)
        myRecyclerList.adapter = MyRvStaggedAdapter(arrayListOf(
            R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6
        ),::onItemClick)
    }

    fun onItemClick(position:Int,holder:RecyclerView.ViewHolder){
        t("clicked on $position")
    }
}
