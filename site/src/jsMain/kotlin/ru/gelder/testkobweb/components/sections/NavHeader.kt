package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaPhone
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text
import ru.gelder.testkobweb.SitePalette

val NAV_HEADER_HEIGHT = 80.px
val NavHeaderStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .position(Position.Sticky)
        .top(0.px)
        .padding(1.cssRem)
        .zIndex(99)
        .height(NAV_HEADER_HEIGHT)
        .backgroundColor(Color.white)
        .gap(1.cssRem)
}

@Composable
fun NavHeader() {
    Row(
        NavHeaderStyle.toModifier(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Logo()
        Name()
        NavigationItems()
        Phone()
        Email()
        RequestButton()
    }
}

@Composable
fun Logo() {
    Image("/TestLogo.png", modifier = Modifier.size(60.px))
}

val TitleStyle = CssStyle.base { Modifier.margin(bottom = 0.5.cssRem).color(SitePalette.theme.primary) }

val DescriptionStyle = CssStyle.base { Modifier }

@Composable
fun Name() {
    Column(modifier = Modifier) {
        H4(TitleStyle.toAttrs()) { Text("ГельдерФинанс") }
        Div(DescriptionStyle.toAttrs()) { Text("Кредиты под залог") }
    }
}

val NavItemsStyle = CssStyle.base { Modifier.display(DisplayStyle.Flex).gap(1.cssRem) }

@Composable
fun NavItem(text: String, anchorId: String) {
    Link(
        path = "#$anchorId",
        text = text
    )
}

@Composable
private fun NavigationItems() {
    Nav(attrs = NavItemsStyle.toAttrs()) {
        NavItem("О нас", "")
        NavItem("Калькулятор", "")
        NavItem("Заявка", "")
        NavItem("Контакты", "")
    }
}

@Composable
private fun Phone() {
    Row {
        FaPhone()
        Text("+7 (999) 99-99-99")
    }
}

@Composable
private fun Email() {
    Row {
        FaEnvelope()
        Text("gelder@finance.ru")
    }
}

@Composable
private fun RequestButton() {
    Button(
        {

        }
    ) {
        Text("Оставить заявку")
    }
}


