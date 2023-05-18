package com.example.myfirstapplication.Dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Dictionary : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dictionary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retroFit = Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/entries/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val service = retroFit.create(DictionaryApi::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.meaning_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)



        val searchButton = view.findViewById<View>(R.id.search_button) as ImageButton
        searchButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val editTextName : EditText? = view?.findViewById(R.id.search_line)
                val word = editTextName?.text

                GlobalScope.launch(Dispatchers.IO) {
                    val response = service.getWord(word.toString())
                    withContext(Dispatchers.Main) {
                        view?.findViewById<TextView?>(R.id.header_word)?.text = response[0].word
                        view?.findViewById<TextView?>(R.id.part_of_speech)?.text = response[0].meanings[0].partOfSpeech
                        view?.findViewById<TextView?>(R.id.phonetic)?.text =
                            "[${response[0].phonetic.drop(1).dropLast(1)}]"
                        val adapter = MeaningAdapter(response[0])
                        recyclerView.adapter = adapter
                    }
                }
            }
        })
    }
}