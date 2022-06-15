# Chuck Norris Android App
It is a Android application that allows the user to get normal Chuck Norris Facts or search for them.

The application is created with Android Studio and can run on any Android device running Android 5.0 (API 21) or greater.

## Libraries

- [Kotlin](https://kotlinlang.org/) , [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) , [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
- [Retrofit](https://square.github.io/retrofit/)
- [Glide](https://github.com/bumptech/glide)
- [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started)
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Timber](https://github.com/JakeWharton/timber)

## Chuck Norris API

[Click](https://api.chucknorris.io/) for API details.

## Architectural Decisions
The app is based on MVVM Design Pattern. Here is the package structure:

#### Data
Data package should include response models, data source and api methods. It shouldn't know any logic.

### Domain
Domain package should include mappers, ui models and usecases that is used to separate repeating logic from the ViewModel to reduce complexity

#### Presentation
Presentation like a feature. It contains Fragments, view models.

#### Ui-Component
Custom view components that are used in the project.