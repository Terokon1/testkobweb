package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
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
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

val NavHeaderStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .position(Position.Sticky)
        .top(0.px)
        .padding(1.cssRem)
        .zIndex(99)
        .height(80.px)
        .backgroundColor(Color.white)
}

@Composable
fun NavHeader() {
    Row(
        NavHeaderStyle.toModifier(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Logo()
        Name()
        Spacer()
        NavigationItems()
        Spacer()
        Phone()
        Email()
        RequestButton()
    }
}

@Composable
fun Logo() {
    Image("/TestLogo.png", modifier = Modifier.size(40.px))
}

val TitleStyle = CssStyle.base { Modifier }

val DescriptionStyle = CssStyle.base { Modifier }

@Composable
fun Name() {
    Column(modifier = Modifier) {
        Div(TitleStyle.toAttrs()) { Text("Гельдер Финанс") }
        Div(DescriptionStyle.toAttrs()) { Text("Кредиты под залог") }
    }
}

val NavItemsStyle = CssStyle.base { Modifier.gap(1.cssRem) }

@Composable
fun NavItem(text: String, anchorId: String) {
    Link(
        path = "#$anchorId",
        text = text
    )
}

@Composable
private fun NavigationItems() {
    Row(modifier = NavItemsStyle.toModifier()) {
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
        Text("+7 999 99-99-99")
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


