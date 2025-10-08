package ru.gelder.testkobweb.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions

val TopScrollButtonStyle = CssStyle.base {
    Modifier
        .position(Position.Fixed)
        .bottom(20.px)
        .right(20.px)
        .zIndex(100)
        .borderRadius(50.percent)
        .size(56.px)
}

@Composable
fun TopScrollButton() {
    Button(
        onClick = {
            window.scrollTo(
                ScrollToOptions(
                    top = 0.0,
                    behavior = ScrollBehavior.SMOOTH
                )
            )
        },
        modifier = TopScrollButtonStyle.toModifier()
    ) {
        FaArrowUp()
    }
}