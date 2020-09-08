package cn.cxy.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 星形
 */
class StarView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private val mPaint = Paint()
    private val strokeWidth = dip2px(context, 4f)
    private val path = Path()

    init {
        //设置实心
        mPaint.style = Paint.Style.FILL
        //设置颜色
        mPaint.color = Color.BLUE
        //设置线宽
        mPaint.strokeWidth = strokeWidth
        // 设置画笔的锯齿效果
        mPaint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawArc(canvas)
    }

    /**
     * 画圆弧
     */
    private fun drawArc(canvas: Canvas) {
        setPaintStyle(true)
        val xxSize = dip2px(context, 1f)
        path.moveTo(width / 2.toFloat(), 0f)
        path.lineTo(width / 2.toFloat() + xxSize, height.toFloat() / 2 - xxSize)
        path.lineTo(width.toFloat(), height.toFloat() / 2)
        path.lineTo(width / 2.toFloat() + xxSize, height.toFloat() / 2 + xxSize)
        path.lineTo(width / 2.toFloat(), height.toFloat())
        path.lineTo(width / 2.toFloat() - xxSize, height.toFloat() / 2 + xxSize)
        path.lineTo(0f, height / 2.toFloat())
        path.lineTo(width / 2.toFloat() - xxSize, height.toFloat() / 2 - xxSize)
        path.close()
        canvas.drawPath(path, mPaint)
    }

    private fun setPaintStyle(isFilled: Boolean) {
        mPaint.style = if (isFilled) Paint.Style.FILL else Paint.Style.STROKE
    }

    private fun dip2px(context: Context, dpValue: Float): Float {
        val scale = context.resources.displayMetrics.density
        return dpValue * scale + 0.5f
    }
}