package ru.gelder.testkobweb.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.layout.Layout
import ru.gelder.testkobweb.components.sections.NAV_HEADER_HEIGHT
import ru.gelder.testkobweb.components.sections.NavHeader

@Layout
@Composable
fun MainLayout(ctx: PageContext, content: @Composable () -> Unit) {
    Box {
        NavHeader()
        Column(modifier = Modifier.fillMaxWidth().padding(top = NAV_HEADER_HEIGHT)) {
            content()
        }
    }
}
