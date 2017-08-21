package br.com.kosawalabs.tictactoechallenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var board: RecyclerView
    private lateinit var presenter: Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board = findViewById(R.id.board) as RecyclerView

        Contract.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun injectPresenter(presenter: Contract.Presenter) {
        this.presenter = presenter
    }

    override fun startGame() {
        board.adapter = BoardAdapter(presenter)
        board.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        board.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
    }

    private class BoardAdapter(val presenter: Contract.Presenter) : RecyclerView.Adapter<BoardAdapter.Item>() {

        override fun getItemViewType(position: Int): Int = when (presenter.getMark(position)) {
            GameModel.POSITION_CROSS -> VIEW_TYPE_CROSS
            GameModel.POSITION_CIRCLE -> VIEW_TYPE_CIRCLE
            else -> VIEW_TYPE_EMPTY
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item = when (viewType) {
            VIEW_TYPE_CROSS -> Item(LayoutInflater.from(parent.context)
                    .inflate(R.layout.component_item_cross, parent, false))
            VIEW_TYPE_CIRCLE -> Item(LayoutInflater.from(parent.context)
                    .inflate(R.layout.component_item_circle, parent, false))
            else -> Item(LayoutInflater.from(parent.context)
                    .inflate(R.layout.component_item_empty, parent, false))
        }

        override fun onBindViewHolder(holder: Item, position: Int) {
            holder.button.setOnClickListener {
                this.presenter.onClicked(position)
                this.notifyItemChanged(position)
            }
        }

        override fun getItemCount(): Int = presenter.getBoardSize()

        inner class Item(view: View) : RecyclerView.ViewHolder(view) {
            val button: ImageButton = view.findViewById(R.id.position) as ImageButton
        }

        companion object {
            private val VIEW_TYPE_EMPTY = 3
            private val VIEW_TYPE_CROSS = 5
            private val VIEW_TYPE_CIRCLE = 7
        }
    }

}
