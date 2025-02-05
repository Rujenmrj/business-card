package com.rujenm.businesscard

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


class CurvedBottomShape : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(0f, 0f) // Start from top-left
            lineTo(0f, size.height - 150f) // Left side
            quadraticBezierTo(
                size.width / 2, size.height + 150f, // Control point
                size.width, size.height - 150f // Right side
            )
            lineTo(size.width, 0f) // Top side
            close()
        }
        return Outline.Generic(path)
    }
}