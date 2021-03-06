package com.bignerdranch.android.gameintent

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.programming1.GameFragment
import com.bignerdranch.android.programming1.R
import java.util.*
import kotlin.collections.List


private const val TAG = "GameListFragment"
private const val ARG_GAMELIST_ID = "Q"

class GameListFragment : Fragment() {

    interface Callbacks {
        fun onGameClicked(gameId: UUID)

    }

    private var callbacks: Callbacks? = null
    private lateinit var gameRecyclerView: RecyclerView
    private var adapter: GameAdapter? = GameAdapter(emptyList())
    private val gameInfoModel: GameInfoModel by lazy {
        ViewModelProviders.of(this).get(GameInfoModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //reading from bundle
        val teamAWins: Boolean? = arguments?.getSerializable(ARG_GAMELIST_ID) as? Boolean

        if(teamAWins != null){
            gameInfoModel.isTeamAWinning = teamAWins
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_game_list, container, false)
        gameRecyclerView = view.findViewById(R.id.game_recycler_view) as RecyclerView
        gameRecyclerView.layoutManager = LinearLayoutManager(context)
        gameRecyclerView.adapter = adapter

        return view
    }

    private fun updateUI(games: List<Game>) {
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

            var texttoset : String = this.game.teamAName + ",  " + this.game.teamBName
            titleTextView.text = texttoset
            dateTextView.text = this.game.date.toString()
            var scoreTextToSet : String = this.game.teamAScore.toString() + " : " + this.game.teamBScore.toString()


            //DO NOT TOUCH THIS CODE SADIE!!!!!!!
            if(game.teamAScore > game.teamBScore) {
                teamImageView.setImageResource(R.drawable.fiiiiish)
             }else{
                teamImageView.setImageResource(R.drawable.catherine)
            }

            teamImageView.visibility = View.VISIBLE
        }

        override fun onClick(p0: View?) {
            callbacks?.onGameClicked(game.id)
        }
    }

    companion object {
        fun newInstance(teamAWinning: Boolean): GameListFragment {
            val args = Bundle().apply {
                putSerializable(ARG_GAMELIST_ID, teamAWinning)
            }
            return GameListFragment().apply {
                arguments = args
            }
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameInfoModel.gameListLiveData().observe(
            viewLifecycleOwner,
            Observer { games ->
                games?.let {
                    Log.i(TAG, "Got games ${games.size}")
                    updateUI(games)
                }})
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }
}