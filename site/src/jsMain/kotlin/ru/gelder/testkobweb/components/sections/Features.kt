package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import ru.gelder.testkobweb.SitePalette

val FeaturesSectionStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .backgroundColor(Color.white)
        .padding(topBottom = 80.px, leftRight = 20.px)
}

val FeaturesContainerStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .maxWidth(1200.px)
        .margin(leftRight = 0.px)
        .display(DisplayStyle.Grid)
        .gap(40.px)
}

val FeatureItemStyle = CssStyle.base {
    Modifier
        .textAlign(TextAlign.Center)
        .padding(30.px)
}

val FeatureIconStyle = CssStyle.base {
    Modifier
        .width(60.px)
        .height(60.px)
        .backgroundColor(Color("#e3f2fd"))
        .borderRadius(50.percent)
        .margin(bottom = 20.px, leftRight = 0.px)
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .justifyContent(JustifyContent.Center)
        .fontSize(24.px)
        .color(SitePalette.theme.primary)
}

val FeatureTitleStyle = CssStyle.base {
    Modifier
        .fontSize(20.px)
        .fontWeight(600)
        .color(Color("#1a1a1a"))
        .margin(bottom = 12.px)
}

val FeatureDescriptionStyle = CssStyle.base {
    Modifier
        .fontSize(16.px)
        .color(Color("#666"))
        .lineHeight(1.6)
}

@Composable
fun Features() {
    Section(attrs = FeaturesSectionStyle.toAttrs()) {
        Div(attrs = FeaturesContainerStyle.toAttrs()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Feature 1
                Column(
                    modifier = FeatureItemStyle.toModifier(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Div(attrs = FeatureIconStyle.toAttrs()) {
                        Text("🛡️")
                    }
                    H3(attrs = FeatureTitleStyle.toAttrs()) {
                        Text("Гарантия надёжности")
                    }
                    P(attrs = FeatureDescriptionStyle.toAttrs()) {
                        Text("Лицензированная деятельность, прозрачные условия, работаем по договору с полным соблюдением законодательства РФ")
                    }
                }

                // Feature 2
                Column(
                    modifier = FeatureItemStyle.toModifier(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Div(attrs = FeatureIconStyle.toAttrs()) {
                        Text("⚡")
                    }
                    H3(attrs = FeatureTitleStyle.toAttrs()) {
                        Text("Максимальная скорость")
                    }
                    P(attrs = FeatureDescriptionStyle.toAttrs()) {
                        Text("Предварительное решение за 30 минут, окончательное — за 1 рабочий день. Получение денег в день подписания договора")
                    }
                }

                // Feature 3
                Column(
                    modifier = FeatureItemStyle.toModifier(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Div(attrs = FeatureIconStyle.toAttrs()) {
                        Text("📋")
                    }
                    H3(attrs = FeatureTitleStyle.toAttrs()) {
                        Text("Выгодные условия")
                    }
                    P(attrs = FeatureDescriptionStyle.toAttrs()) {
                        Text("Ставки от 1% в месяц, сумма кредита до 70% от стоимости залога, гибкие условия погашения")
                    }
                }
            }
        }
    }
}