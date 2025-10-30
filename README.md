# ГельдерФинанс - Lending Company Landing Page

A modern, responsive landing page for ГельдерФинанс (GelderFinance), a lending company specializing in secured loans
against real estate and vehicles. Built with **Kobweb** and **Silk UI**.

## 🚀 Features

- **Responsive Design** - Fully adaptive layout that works on all devices
- **Sticky Navigation** - Always accessible navigation header
- **Interactive Loan Calculator** - Real-time loan calculations with sliders
- **Modern UI Components** - Built with Kotlin Compose for Web (Kobweb)
- **Smooth Animations** - Enhanced user experience with smooth transitions
- **Contact Forms** - Application form for loan requests
- **SEO Optimized** - Semantic HTML structure

## 📋 Sections

1. **Hero Section** - Main value proposition with call-to-action
2. **Features** - Key advantages and guarantees
3. **Loan Calculator** - Interactive calculator for loan parameters
4. **Application Form** - Complete loan application with validation
5. **Footer** - Company information, contacts, and legal details

## 🛠 Tech Stack

- **Framework**: [Kobweb](https://github.com/varabyte/kobweb) - Kotlin web framework
- **UI Library**: Silk UI - Compose-based web components
- **Language**: Kotlin/JS
- **Build Tool**: Gradle
- **Styling**: CSS-in-Kotlin with Compose modifiers

## 🏗 Project Structure

```
site/src/jsMain/kotlin/ru/gelder/testkobweb/
├── components/
│   ├── layouts/
│   │   └── MainLayout.kt           # Main page layout with header
│   ├── sections/
│   │   ├── NavHeader.kt           # Navigation header
│   │   ├── Hero.kt                # Hero section
│   │   ├── Features.kt            # Features/advantages section
│   │   ├── Calculator.kt          # Loan calculator
│   │   ├── Application.kt         # Application form
│   │   └── Footer.kt              # Footer section
│   └── widgets/
│       └── OnTopButton.kt         # Scroll to top button
├── pages/
│   └── Index.kt                   # Main page
├── AppEntry.kt                    # App initialization
└── SitePalette.kt                 # Color scheme
```

## 🎨 Design Features

### Color Scheme

- **Primary**: Blue (#3b5bdb) - Professional and trustworthy
- **Success**: Green (#4CAF50) - For positive indicators
- **Background**: Light gray (#f5f6fa) - Clean and modern
- **Text**: Dark gray (#1a1a1a) - High contrast readability

### Components

- **Responsive Grid Layout** - Adapts to different screen sizes
- **Interactive Calculator** - Real-time loan calculations
- **Form Validation** - User-friendly input validation
- **Smooth Scrolling** - Enhanced navigation experience

## 🚀 Getting Started

### Prerequisites

- JDK 11 or higher
- Node.js (for frontend dependencies)

### Installation

1. Clone the repository:

```bash
git clone <repository-url>
cd testkobweb
```

2. Run the development server:
```bash
./gradlew kobwebStart
```

3. Open your browser and navigate to `http://localhost:8080`

### Building for Production

```bash
./gradlew kobwebExport
```

The built files will be in the `.kobweb/site/build` directory.

## 📱 Responsive Design

The landing page is fully responsive with breakpoints optimized for:

- **Desktop** (1200px+) - Full layout with all features
- **Tablet** (768px - 1199px) - Adapted grid and navigation
- **Mobile** (< 768px) - Stacked layout with mobile-optimized forms

## 🧮 Calculator Features

The loan calculator includes:

- **Property Type Selection** - Different rates for different collateral types
- **Interactive Sliders** - Easy adjustment of loan parameters
- **Real-time Calculations** - Instant results as users adjust parameters
- **Payment Schedule** - Monthly payment and total cost calculations
- **Important Disclaimers** - Legal and financial disclaimers

## 📝 Form Handling

The application form includes:

- **Required Field Validation** - Clear marking of mandatory fields
- **Input Types** - Appropriate input types for better UX
- **Legal Compliance** - GDPR/152-ФЗ compliance checkboxes
- **Multi-step Process** - Clear explanation of the application process

## 🔧 Customization

### Adding New Sections

1. Create a new composable in `components/sections/`
2. Add the section to the main page in `pages/Index.kt`
3. Update navigation links if needed

### Modifying Colors

Update the color scheme in `SitePalette.kt`:

```kotlin
data class ColorScheme(
    val primary: Color.Rgb = Color.rgb(0x3b5bdb),
    // ... other colors
)
```

### Adding New Pages

1. Create a new file in `pages/` directory
2. Annotate with `@Page` and `@Layout`
3. Add navigation links in `NavHeader.kt`

## 📞 Contact Information

- **Phone**: +7 (495) 777-88-99
- **Email**: info@gelderfinance.ru
- **Address**: Москва, Красная площадь, д. 1

## 📄 License

This project is proprietary software for ГельдерФинанс. All rights reserved.

## 🤝 Contributing

This is a private project. For internal development guidelines, please refer to the internal documentation.

---