package com.bignerdranch.android.programming1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "GameInfoFragment"
class GameInfoFragment : Fragment() {
    private lateinit var gameRecyclerView: RecyclerView
    private var adapter: GameAdapter? = null
    private val gameInfoModel: GameInfoModel by lazy {
        ViewModelProviders.of(this).get(GameInfoModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${gameInfoModel.listOfGames.size}")
    }

    companion object {
        fun newInstance(): GameInfoFragment {
            return GameInfoFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game_list, container, false)
        gameRecyclerView =
            view.findViewById(R.id.crime_recycler_view) as RecyclerView
        gameRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI()

        return view
    }

    private fun updateUI() {
        val games = gameInfoModel.listOfGames
        adapter = GameAdapter(games)
        gameRecyclerView.adapter = adapter
    }

    private inner class GameHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var game: Game

        val titleTextView: TextView = itemView.findViewById(R.id.game_title)
        val dateTextView: TextView = itemView.findViewById(R.id.game_date)

        private val teamImageView: ImageView = itemView.findViewById(R.id.teamImageView)

        init {
           itemView.setOnClickListener(this)
        }

        fun bind(game: Game){
            this.game = game
            titleTextView.text = this.game.index
            dateTextView.text = this.game.date.toString()


            //DO NOT TOUCH THIS CODE SADIE!!!!!!!
            if(game.scoreA > game.scoreB) {
                teamImageView.setImageResource(R.drawable.fiiiiish)
             }else{
                teamImageView.setImageResource(R.drawable.catherine)
            }

            teamImageView.visibility = View.VISIBLE
        }

        override fun onClick(p0: View?) {
            Toast.makeText(context, "${game.teamA} clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private inner class GameAdapter(var games: List<Game>)
        : RecyclerView.Adapter<GameHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : GameHolder {
            val view = layoutInflater.inflate(R.layout.list_item_game, parent, false)
            return GameHolder(view)
        }
        override fun getItemCount() : Int{
            return games.size
        }
        override fun onBindViewHolder(holder: GameHolder, position: Int) {
            val game = games[position]
            holder.bind(game)
        } }
}