package cn.cxy.customviews.runningline

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import cn.cxy.customviews.R
import kotlinx.android.synthetic.main.activity_running_line.*


class RunningLineActivity : AppCompatActivity() {
    private lateinit var gradientColors: IntArray
    private var viewList = mutableListOf<RunningLineView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_running_line)
        gradientColors = intArrayOf(
            resources.getColor(R.color.color1),
            resources.getColor(R.color.color2),
            resources.getColor(R.color.color3)
        )

        startRunning()
    }


    private fun startRunning() {
        val layoutParams = LinearLayout.LayoutParams(300, 300)
        layoutParams.setMargins(20, 20, 20, 20)
        repeat((0..8).count()) {
            val runningLineView = RunningLineView(this)
            runningLineView.layoutParams = layoutParams
            flowLayout.addView(runningLineView, layoutParams)
            viewList.add(runningLineView)
        }
        viewList.forEach { startRunning(it) }
    }

    private fun startRunning(runningLineView: RunningLineView) {
        runningLineView
            .setStartPosition(0.2f, 0f)
            .setLineWidth(5f)
            .setGradient(gradientColors)
            .setStepSize(5)
            .setLineLength(100f)
            //            .setLineColorRes(R.color.colorAccent)
            .start()
    }
}