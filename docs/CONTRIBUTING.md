# Contributing to Periodic Table Game

We love your input! We want to make contributing to Periodic Table Game as easy and transparent as possible.

## Development Process

We use GitHub to host code, to track issues and feature requests, as well as accept pull requests.

1. Fork the repo and create your branch from `main`
2. Make your changes following our guidelines
3. Add tests for any new functionality
4. Update documentation as needed
5. Run all tests and ensure they pass
6. Submit a pull request

## Code Style Guidelines

### Kotlin Style

- Follow the [official Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable and function names
- Write comments for complex logic
- Keep functions small and focused
- Use composition over inheritance

### Compose UI Guidelines

- Follow Material Design 3 principles
- Use the existing color scheme and typography defined in the theme
- Maintain consistent spacing using the provided modifiers
- Reuse existing composable components when possible
- Support both portrait and landscape orientations

### Example Component Structure

```kotlin
@Composable
fun GameComponent(
    state: GameState,
    onEvent: (GameEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Component implementation
}
```

## Project Structure

```
app/
├── src/
│   └── main/
│       ├── java/dev/toufikforyou/periodictable/
│       │   ├── di/          # Dependency injection modules
│       │   ├── main/
│       │   │   ├── data/    # Repository implementations
│       │   │   ├── domain/  # Business logic, models
│       │   │   ├── presentation/ # UI components, ViewModels
│       │   │   └── utils/   # Helper classes, constants
│       │   └── ui/          # Theme and styling
│       └── res/             # Resources
```

## Testing Guidelines

- Write unit tests for ViewModels and Repository classes
- Write UI tests for critical user flows
- Use fake repositories for testing
- Follow the given-when-then pattern for test structure

## Issue Reporting

When creating issues, please use the appropriate issue template:

- Bug Report
- Feature Request
- UI Enhancement

## Pull Request Process

1. Update the README.md with details of significant changes
2. Update the CHANGELOG.md with notes on your changes
3. The PR will be merged once you have the sign-off of one reviewer
4. All GitHub actions checks must pass

## License

By contributing, you agree that your contributions will be licensed under the MIT License.
