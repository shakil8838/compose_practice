import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _vector: ImageVector? = null

public val Vector: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 102.dp,
            defaultHeight = 51.dp,
            viewportWidth = 102f,
            viewportHeight = 51f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFEEF8F5)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(1.48076f, 25.8638f)
                lineTo(6.01548f, 28.509f)
                curveTo(7.2443f, 29.2259f, 8f, 30.5415f, 8f, 31.9641f)
                verticalLineTo(32f)
                horizontalLineTo(12f)
                verticalLineTo(18f)
                horizontalLineTo(8f)
                verticalLineTo(18.0359f)
                curveTo(8f, 19.4585f, 7.2443f, 20.7741f, 6.0155f, 21.491f)
                lineTo(1.48076f, 24.1362f)
                curveTo(0.8193f, 24.5221f, 0.8193f, 25.4779f, 1.4808f, 25.8638f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFEEF8F5)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(16f, 0.5f)
                horizontalLineTo(94f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 101.5f, 8f)
                verticalLineTo(43f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 94f, 50.5f)
                horizontalLineTo(16f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8.5f, 43f)
                verticalLineTo(8f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16f, 0.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFFEEF8F5)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(16f, 0.5f)
                horizontalLineTo(94f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 101.5f, 8f)
                verticalLineTo(43f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 94f, 50.5f)
                horizontalLineTo(16f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8.5f, 43f)
                verticalLineTo(8f)
                arcTo(7.5f, 7.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16f, 0.5f)
                close()
            }
        }.build()
        return _vector!!
    }

