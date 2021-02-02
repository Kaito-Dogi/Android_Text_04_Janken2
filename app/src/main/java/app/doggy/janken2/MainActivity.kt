package app.doggy.janken2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //手の画像を用意。
    val handImages: Array<Int> = arrayOf(R.drawable.goo, R.drawable.choki, R.drawable.pa)

    //結果の文を用意。
    val resultTexts: Array<String> = arrayOf("あなたの勝ち！", "CPUの勝ち！", "あいこ！")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //クリックリスナを設定。
        gooButton.setOnClickListener(JankenListener())
        chokiButton.setOnClickListener(JankenListener())
        paButton.setOnClickListener(JankenListener())

    }

    private inner class JankenListener: View.OnClickListener {
        override fun onClick(view: View) {

            //CPUの手を決定。
            var cpuHand: Int = Random.nextInt(3)
            Log.d("cpuHand", "$cpuHand")

            //CPUの手を表示。
            cpuHandImageView.setImageResource(handImages[cpuHand])

            //ボタンのidに応じて処理を変更。
            when(view.id) {
                R.id.gooButton -> {

                    //プレイヤーの手をTextViewに表示。
                    playerHandImageView.setImageResource(handImages[0])

                    //勝敗判定。
                    when(cpuHand) {
                        0 -> resultTextView.text = resultTexts[2]
                        1 -> resultTextView.text = resultTexts[0]
                        2 -> resultTextView.text = resultTexts[1]
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
                    when(cpuHand) {
                        0 -> resultTextView.text = resultTexts[1]
                        1 -> resultTextView.text = resultTexts[2]
                        2 -> resultTextView.text = resultTexts[0]
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
                    when(cpuHand) {
                        0 -> resultTextView.text = resultTexts[0]
                        1 -> resultTextView.text = resultTexts[1]
                        2 -> resultTextView.text = resultTexts[2]
                    }

                    //ボタンの色を変更。
                    paButton.setBackgroundColor(Color.parseColor("#6200ee"))
                    gooButton.setBackgroundColor(Color.parseColor("#9e9e9e"))
                    chokiButton.setBackgroundColor(Color.parseColor("#9e9e9e"))
                }
            }

            //勝敗に応じて、resultTextViewの文字色を変更。
            when(resultTextView.text) {
                resultTexts[0] -> resultTextView.setTextColor(Color.parseColor("#0000dd"))
                resultTexts[1] -> resultTextView.setTextColor(Color.parseColor("#dd0000"))
                resultTexts[2] -> resultTextView.setTextColor(Color.parseColor("#00dd00"))
            }
        }
    }
}