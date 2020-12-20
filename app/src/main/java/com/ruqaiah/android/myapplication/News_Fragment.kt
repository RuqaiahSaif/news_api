package com.ruqaiah.android.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class News_Fragment : Fragment() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newsViewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsViewModel =
            ViewModelProviders.of(this).get(NewsViewModel::class.java)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.newsLiveData.observe(
            viewLifecycleOwner,
            Observer {
                newRecyclerView.adapter = NewsAdapter(it)
            })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        newRecyclerView = view.findViewById(R.id.news_recyclereview)
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    private inner class NewsHolder(items: View) : RecyclerView.ViewHolder(items),
        View.OnClickListener {
        private lateinit var new: NewsData
        val imgView = items.findViewById(R.id.image) as TextView
        val titleView = items.findViewById(R.id.title) as TextView
        val dateView = items.findViewById(R.id.date) as TextView
        val detialesView = items.findViewById(R.id.details) as TextView

        fun bindNew(new: NewsData) {
            titleView.text = new.title
            dateView.text = new.date?.toString()
            detialesView.text = new.details
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }
    private inner class NewsAdapter(private val newItems: List<NewsData>)
        : RecyclerView.Adapter<NewsHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
            val v=  LayoutInflater.from(parent.context).inflate(
                R.layout.news_list,
                parent,
                false
            )
            return NewsHolder(v)
        }

        override fun onBindViewHolder(holder: NewsHolder, position: Int) {
            val newItem=newItems[position]
            holder.bindNew(newItem)
        }

        override fun getItemCount(): Int {
            return  newItems.size
        }
    }

    companion object {

        fun newInstance() = News_Fragment()
            }
    }
