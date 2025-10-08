package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

val NavHeaderStyle = CssStyle.base {
    Modifier.fillMaxWidth().padding(1.cssRem)
}

@Composable
fun NavHeader() {
    Row(
        NavHeaderStyle.toModifier(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Logo()
        Name()
    }
}

@Composable
fun Logo() {
    Image("/TestLogo.png", modifier = Modifier.size(4.cssRem))
}

@Composable
fun Name() {
    Text("Sample text")
}

@Composable
private fun NavigationItems() {

}

@Composable
private fun Phone() {

}

@Composable
private fun Email() {

}

@Composable
private fun RequestButton() {

}


