package ru.gelder.testkobweb.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import ru.gelder.testkobweb.SitePalette

val HeroSectionStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .backgroundColor(Color("#f5f6fa"))
        .padding(topBottom = 80.px, leftRight = 20.px)
        .alignItems(AlignItems.Center)
}

val HeroContainerStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .maxWidth(1200.px)
        .margin(leftRight = 0.px)
}

val HeroLeftContentStyle = CssStyle.base {
    Modifier
        .padding(right = 40.px)
}

val HeroTitleStyle = CssStyle.base {
    Modifier
        .fontSize(52.px)
        .fontWeight(700)
        .lineHeight(1.1)
        .color(Color("#2c2c2c"))
        .margin(bottom = 24.px)
}

val HeroTitleBlueStyle = CssStyle.base {
    Modifier
        .color(SitePalette.theme.primary)
}

val HeroDescriptionStyle = CssStyle.base {
    Modifier
        .fontSize(18.px)
        .color(Color("#6c757d"))
        .lineHeight(1.6)
        .margin(bottom = 32.px)
        .maxWidth(580.px)
}

val HeroBenefitsStyle = CssStyle.base {
    Modifier
        .margin(bottom = 40.px)
}

val BenefitRowStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .margin(bottom = 16.px)
}

val BenefitItemStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .margin(right = 40.px)
        .fontSize(16.px)
        .color(Color("#2c2c2c"))
        .fontWeight(500)
}

val CheckmarkStyle = CssStyle.base {
    Modifier
        .width(20.px)
        .height(20.px)
        .backgroundColor(Color("#10b981"))
        .borderRadius(50.percent)
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .justifyContent(JustifyContent.Center)
        .margin(right = 12.px)
        .fontSize(12.px)
        .color(Color.white)
        .flexShrink(0)
}

val HeroButtonsStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .gap(24.px)
        .alignItems(AlignItems.Center)
}

val PrimaryButtonStyle = CssStyle.base {
    Modifier
        .backgroundColor(SitePalette.theme.primary)
        .color(Color.white)
        .padding(16.px, 32.px)
        .borderRadius(8.px)
        .fontSize(16.px)
        .fontWeight(600)
        .border(0.px)
}

val SecondaryLinkStyle = CssStyle.base {
    Modifier
        .color(SitePalette.theme.primary)
        .fontSize(16.px)
        .fontWeight(600)
}

val HeroImageContainerStyle = CssStyle.base {
    Modifier
        .width(520.px)
        .height(400.px)
        .borderRadius(16.px)
        .overflow(Overflow.Hidden)
        .position(Position.Relative)
}

@Composable
fun Hero() {
    Section(attrs = HeroSectionStyle.toAttrs()) {
        Div(attrs = HeroContainerStyle.toAttrs()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Left content
                Column(modifier = Modifier.weight(1).then(HeroLeftContentStyle.toModifier())) {
                    H1(attrs = HeroTitleStyle.toAttrs()) {
                        Text("Кредиты под залог ")
                        Br()
                        Span(attrs = HeroTitleBlueStyle.toAttrs()) {
                            Text("недвижимости и автомобилей")
                        }
                    }

                    P(attrs = HeroDescriptionStyle.toAttrs()) {
                        Text("ООО \"ГельдерФинанс\" — ваш надёжный партнер в получении кредитов под залог. Работаем с физическими и юридическими лицами. Минимальные требования к заёмщику, сумма до 100 млн рублей, ставка от 1% в месяц.")
                    }

                    Div(attrs = HeroBenefitsStyle.toAttrs()) {
                        Div(attrs = BenefitRowStyle.toAttrs()) {
                            Div(attrs = BenefitItemStyle.toAttrs()) {
                                Div(attrs = CheckmarkStyle.toAttrs()) { Text("✓") }
                                Text("От 1% в месяц")
                            }
                            Div(attrs = BenefitItemStyle.toAttrs()) {
                                Div(attrs = CheckmarkStyle.toAttrs()) { Text("✓") }
                                Text("До 100 млн ₽")
                            }
                        }
                        Div(attrs = BenefitRowStyle.toAttrs()) {
                            Div(attrs = BenefitItemStyle.toAttrs()) {
                                Div(attrs = CheckmarkStyle.toAttrs()) { Text("✓") }
                                Text("За 1 день")
                            }
                            Div(attrs = BenefitItemStyle.toAttrs()) {
                                Div(attrs = CheckmarkStyle.toAttrs()) { Text("✓") }
                                Text("Без справок")
                            }
                        }
                    }

                    Div(attrs = HeroButtonsStyle.toAttrs()) {
                        Button(
                            onClick = { /* TODO: Scroll to calculator */ },
                            modifier = PrimaryButtonStyle.toModifier()
                        ) {
                            Text("Рассчитать кредит")
                        }
                        A(
                            href = "#application",
                            attrs = SecondaryLinkStyle.toAttrs()
                        ) {
                            Text("Подать заявку →")
                        }
                    }
                }

                // Right image - точно как на скриншоте с рукой и долларом
                Div(attrs = HeroImageContainerStyle.toAttrs()) {
                    // Используем div с background вместо img для лучшего контроля
                    Div(attrs = {
                        style {
                            width(100.percent)
                            height(100.percent)
                            backgroundColor(Color("#7dd3fc"))
                            display(DisplayStyle.Flex)
                            alignItems(AlignItems.Center)
                            justifyContent(JustifyContent.Center)
                            fontSize(80.px)
                        }
                    }) {
                        Text("💵")
                    }
                }
            }
        }
    }
}