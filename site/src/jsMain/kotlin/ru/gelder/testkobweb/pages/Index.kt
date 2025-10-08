package ru.gelder.testkobweb.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import ru.gelder.testkobweb.components.widgets.TopScrollButton

@Page
@Layout(".components.layouts.MainLayout")
@Composable
fun HomePage() {
    Box(Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.fillMaxWidth().backgroundColor(Color.blue).height(3000.px)
        ) {

        }
        TopScrollButton()
    }
}
