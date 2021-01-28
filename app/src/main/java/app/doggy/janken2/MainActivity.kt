package app.doggy.janken2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //手を用意。
    val hands: List<String> = listOf("グー", "チョキ", "パー")
    val handImages: List<Int> = listOf(R.drawable.goo, R.drawable.choki, R.drawable.pa)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //クリックリスナを設定。
        gooButton.setOnClickListener(OnClickListener())
        chokiButton.setOnClickListener(OnClickListener())
        paButton.setOnClickListener(OnClickListener())

    }

    private inner class OnClickListener: View.OnClickListener {
        override fun onClick(view: View) {

            //CPUの手を決定。
            var cpuHand: Int = Random.nextInt(3)

            //CPUの手を表示。
            cpuHandImageView.setImageResource(handImages[cpuHand])

            //ボタンのidに応じて処理を変更。
            when(view.id) {
                R.id.gooButton -> {

                    //プレイヤーの手をTextViewに表示。
                    playerHandImageView.setImageResource(handImages[0])

                    //勝敗判定。
                    when(hands[cpuHand]) {
                        "グー" -> {
                            resultTextView.text = "あいこ！"
                        }
                        "チョキ" -> {
                            resultTextView.text = "あなたの勝ち！"
                        }
                        "パー" -> {
                            resultTextView.text = "CPUの勝ち！"
                        }
                    }

                    //ボタンの色を変更。
                    gooButton.setBackgroundColor(Color.parseColor("#6200ee"))
                    chokiButton.setBackgroundColor(Color.parseColor("#9e9e9e"))
                    paButton.setBackgroundColor(Color.parseColor("#9e9e9e"))
                }

                R.id.chokiButton -> {

                    //プレイヤーの手をTextViewに表示。
                    playerHandImageView.setImageResource(handImages[1])

                    //勝敗判定。
                    when(hands[cpuHand]) {
                        "グー" -> {
                            resultTextView.text = "CPUの勝ち！"
                        }
                        "チョキ" -> {
                            resultTextView.text = "あいこ！"
                        }
                        "パー" -> {
                            resultTextView.text = "あなたの勝ち！"
                        }
                    }

                    //ボタンの色を変更。
                    chokiButton.setBackgroundColor(Color.parseColor("#6200ee"))
                    paButton.setBackgroundColor(Color.parseColor("#9e9e9e"))
                    gooButton.setBackgroundColor(Color.parseColor("#9e9e9e"))
                }

                R.id.paButton -> {

                    //プレイヤーの手をTextViewに表示。
                    playerHandImageView.setImageResource(handImages[2])

                    //勝敗判定。
                    when(hands[cpuHand]) {
                        "グー" -> {
                            resultTextView.text = "あなたの勝ち！"
                        }
                        "チョキ" -> {
                            resultTextView.text = "CPUの勝ち！"
                        }
                        "パー" -> {
                            resultTextView.text = "あいこ！"
                        }
                    }

                    //ボタンの色を変更。
                    paButton.setBackgroundColor(Color.parseColor("#6200ee"))
                    gooButton.setBackgroundColor(Color.parseColor("#9e9e9e"))
                    chokiButton.setBackgroundColor(Color.parseColor("#9e9e9e"))
                }
            }

            //勝敗に応じて、resultTextViewの文字色を変更。
            when(resultTextView.text) {
                "あなたの勝ち！" -> {
                    resultTextView.setTextColor(Color.parseColor("#0000dd"))
                }

                "CPUの勝ち！" -> {
                    resultTextView.setTextColor(Color.parseColor("#dd0000"))
                }

                "あいこ！" -> {
                    resultTextView.setTextColor(Color.parseColor("#00dd00"))
                }
            }
        }
    }
}