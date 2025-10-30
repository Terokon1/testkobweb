package ru.gelder.testkobweb.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import ru.gelder.testkobweb.components.sections.*
import ru.gelder.testkobweb.components.widgets.TopScrollButton

@Page
@Layout(".components.layouts.MainLayout")
@Composable
fun HomePage() {
    Box(Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Hero()
            Features()
            Calculator()
            Application()
            Footer()
        }
        TopScrollButton()
    }
}
