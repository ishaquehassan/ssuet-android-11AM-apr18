package android.ssuet.retrofitapp

import android.support.v4.widget.CircularProgressDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BooksAdapter(val data:ArrayList<VolumesResponse.VolumeItem>) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BookViewHolder = BookViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.book_item,p0,false))
    override fun getItemCount(): Int = data.size
    override fun onBindViewHolder(p0: BookViewHolder, p1: Int) = p0.bindBook(data[p1])

    class BookViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val bookImage:ImageView = itemView.findViewById(R.id.bookImage)
        val bookTitle:TextView = itemView.findViewById(R.id.bookTitleTv)
        val bookAuthors:TextView = itemView.findViewById(R.id.bookAuthorsTv)

        fun bindBook(book:VolumesResponse.VolumeItem){
            bookTitle.text = book.volumeInfo?.title
            bookAuthors.text = book.volumeInfo?.authors?.joinToString()
            Glide.with(itemView.context).applyDefaultRequestOptions(RequestOptions().apply {
                placeholder(CircularProgressDrawable(itemView.context).apply {
                    strokeWidth = 2f
                    centerRadius = 50f
                    start()
                })
            }).load(book.volumeInfo?.imageLinks?.smallThumbnail).into(bookImage)
        }
    }

}