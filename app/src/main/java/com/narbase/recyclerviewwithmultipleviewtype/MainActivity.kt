package com.narbase.recyclerviewwithmultipleviewtype

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val characterList = fillList()
        setupRecyclerView(characterList)

    }

    private fun fillList(): ArrayList<Model> {

        val QUOTE_TYPE = 0
        val CHARACTER_INFO_TYPE = 1

        val characterList: ArrayList<Model> = ArrayList()

        characterList.add(Model(CHARACTER_INFO_TYPE, "Erwin Smith", "Scout Regiment",
                "", R.drawable.erwin))
        characterList.add(Model(QUOTE_TYPE, "", "", "One day, we'll break it down. This wall hiding the truth...will fall", 0))

        characterList.add(Model(CHARACTER_INFO_TYPE, "Levi Ackermann", "Scout Regiment",
                "", R.drawable.levi))
        characterList.add(Model(QUOTE_TYPE, "", "", "I don't know the answer to that. I never have. " +
                "Whether I trusted myself or the choices of my dependable comrades, there was no telling how things would turn out. " +
                "So, just do the best you can and choose whichever you'll regret the least", 0))

        characterList.add(Model(CHARACTER_INFO_TYPE, "Eren Jaeger", "Scout Regiment",
                "", R.drawable.eren))
        characterList.add(Model(QUOTE_TYPE, "", "", "I'll control the Titans. I'll plug up Wall Maria." +
                " I'll capture Reiner and make him pay. That's what I've gotta do to atone for all those lives lost.", 0))

        characterList.add(Model(CHARACTER_INFO_TYPE, "Mikasa Ackermann", "Scout Regiment",
                "", R.drawable.mikasa))
        characterList.add(Model(QUOTE_TYPE, "", "", "There's only so many lives that I actually care about." +
                " My enemies made deciding that easy six years ago. So...you're mistaken to seek any compassion from me. Because right now, " +
                "I'm all out of time and room in my heart to care", 0))

        characterList.add(Model(CHARACTER_INFO_TYPE, "Armin Arlelt", "Scout Regiment",
                "", R.drawable.armin))
        characterList.add(Model(QUOTE_TYPE, "", "", "Fiery water! Lands of ice! Sandy snowfields! " +
                "The outside world must be many times larger than the inside of these Walls!", 0))

        return characterList
    }

    private fun setupRecyclerView(characterList: ArrayList<Model>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(characterList)
    }
}
